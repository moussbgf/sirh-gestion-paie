package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfileRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	// @Autowired private RemunerationEmploye r ;

	@Autowired
	GradeRepository gradeRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	ProfileRemunerationRepository profileRemunerationRepository;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {

		List<Grade> listeGrade = gradeRepository.findAll();
		List<Entreprise> listeEntreprise = entrepriseRepository.findAll();
		List<ProfilRemuneration> listProfile = profileRemunerationRepository.findAll();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("employes/creerEmploye");

		mv.addObject("listeGrade", listeGrade);
		mv.addObject("listeEntreprise", listeEntreprise);
		mv.addObject("listProfile", listProfile);

		RemunerationEmploye employe = new RemunerationEmploye();

		// String matricule = UUID.randomUUID().toString();

		return mv;

	}

	@RequestMapping(method = RequestMethod.POST)

	public String saveEmploye(@ModelAttribute("employe") RemunerationEmploye employe, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {

		RemunerationEmploye employe2 = employe;

		// clientService.make(client);
		
		remunerationEmployeRepository.save(employe2);
		
		return "redirect:/lister";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {

		ModelAndView mv = new ModelAndView();

		/*
		 * 
		 * Acces aux données via repository / creer un repo par classe d'accés
		 * 
		 * 
		 * 
		 */

		List<Grade> listeGrade = gradeRepository.findAll();

		mv.setViewName("employes/listerEmployes");

		mv.addObject("prefixMatricule", "M00");
		mv.addObject("listeGrade", listeGrade);

		return mv;

	}
}
