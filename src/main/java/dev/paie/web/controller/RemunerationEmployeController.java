package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	@Autowired private RemunerationEmploye r ;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("employes/creerEmploye");

		mv.addObject("prefixMatricule", "M00");

		return mv;

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
		 * */ 
		
		mv.setViewName("employes/listerEmployes");
		
		mv.addObject("prefixMatricule", "M00");

		return mv;

	}
}
