package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRemunerationRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationServiceSimple;
import dev.paie.web.form.BulletinForm;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@Autowired
	PeriodeRepository periodeRepository;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	BulletinSalaireRemunerationRepository bulletinSalaireRemunerationRepository;
	
	@Autowired
	CalculerRemunerationServiceSimple calculerRemunerationService;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		
		List<Periode> listePeriodes = periodeRepository.findAll();
		List<RemunerationEmploye> listEmployes = remunerationEmployeRepository.findAll();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("bulletins/creerBulletin");

		mv.addObject("listePeriodes", listePeriodes);
		mv.addObject("listEmployes", listEmployes);
		mv.addObject("bulletin", new BulletinSalaire());
		
		mv.addObject("calcul", calculerRemunerationService);

		
		// String matricule = UUID.randomUUID().toString();

		return mv;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String saveBulletin(@ModelAttribute("bulletin") BulletinForm bulletinForm, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {

		
		BulletinSalaire bulletin = new BulletinSalaire();
		
		Periode periode = periodeRepository.findOne(bulletinForm.getPeriode());
		RemunerationEmploye employe = remunerationEmployeRepository.findOne(bulletinForm.getRemunerationEmploye());
		

		bulletin.setPeriode(periode);
		bulletin.setRemunerationEmploye(employe);
		bulletin.setPrimeExceptionnelle(new BigDecimal(bulletinForm.getPrimeExceptionnelle()) );
		bulletin.setDateCreation(ZonedDateTime.now());

		bulletinSalaireRemunerationRepository.save(bulletin);

		// clientService.make(client);

		// remunerationEmployeRepository.save(employe2);

		return "redirect:/mvc/bulletins/lister";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletin() {

		ModelAndView mv = new ModelAndView();

		List<BulletinSalaire> listeBulletins = bulletinSalaireRemunerationRepository.findAll();
		
		mv.setViewName("bulletins/listerBulletin");
		
		mv.addObject("bulletins", listeBulletins);
		
		mv.addObject("calcul", calculerRemunerationService);
		
		return mv;

	}

}
