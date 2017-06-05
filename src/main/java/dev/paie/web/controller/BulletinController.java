package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRemunerationRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@Autowired
	PeriodeRepository periodeRepository;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	BulletinSalaireRemunerationRepository bulletinSalaireRemunerationRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {

		List<Periode> listePeriodes = periodeRepository.findAll();
		List<RemunerationEmploye> listEmployes = remunerationEmployeRepository.findAll();
		
		

		ModelAndView mv = new ModelAndView();

		mv.setViewName("bulletins/creerBulletin");

		mv.addObject("listePeriodes", listePeriodes);
		mv.addObject("listEmployes", listEmployes);

		RemunerationEmploye employe = new RemunerationEmploye();

		// String matricule = UUID.randomUUID().toString();

		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletin() {

		ModelAndView mv = new ModelAndView();


		List<BulletinSalaire> listeBulletins = bulletinSalaireRemunerationRepository.findAll();

		mv.setViewName("bulletins/listerBulletin");


		return mv;

	}

}
