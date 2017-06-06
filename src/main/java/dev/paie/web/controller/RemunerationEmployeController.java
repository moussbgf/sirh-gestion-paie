package dev.paie.web.controller;

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

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfileRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.web.form.EmployeForm;

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
		mv.addObject("employe", new EmployeForm());

		// String matricule = UUID.randomUUID().toString();

		return mv;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String saveEmploye(@ModelAttribute("employe") EmployeForm employeForm, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		
		Grade grade = gradeRepository.findOne(employeForm.getGrade());
		Entreprise entreprise = entrepriseRepository.findOne(employeForm.getEntreprise());
		ProfilRemuneration profile = profileRemunerationRepository.findOne(employeForm.getProfilRemuneration());
		
		RemunerationEmploye employe = new RemunerationEmploye();
		
		employe.setMatricule(employeForm.getMatricule());
		employe.setGrade(grade);
		employe.setEntreprise(entreprise);
		employe.setProfilRemuneration(profile);
		employe.setDateCreation(ZonedDateTime.now());
		
		remunerationEmployeRepository.save(employe);
		
		// clientService.make(client);
		
		
		
		//remunerationEmployeRepository.save(employe2);
		
		return "redirect:/mvc/employes/lister";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {

		ModelAndView mv = new ModelAndView();

		List<RemunerationEmploye> employes = remunerationEmployeRepository.findAll();

		mv.setViewName("employes/listerEmployes");

		mv.addObject("employes", employes);

		return mv;

	}
}
