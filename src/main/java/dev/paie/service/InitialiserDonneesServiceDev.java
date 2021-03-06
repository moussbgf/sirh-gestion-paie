package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	// @Autowired
	// private ApplicationContext context;
	//
	// @Autowired
	// private GradeService gradeService;
	//
	// @Override
	// public void initialiser() {
	//
	// // List<Cotisation> listCotisation = new ArrayList<>();
	// //
	// listCotisation.addAll(context.getBeansOfType(Cotisation.class).values());
	//
	// List<Grade> listGrades = new ArrayList<>();
	// listGrades.addAll(context.getBeansOfType(Grade.class).values());
	//
	// // List<Entreprise> listEntreprise = new ArrayList<>();
	// //
	// listEntreprise.addAll(context.getBeansOfType(Entreprise.class).values());
	//
	// // List<ProfilRemuneration> listProfilRemu = new ArrayList<>();
	// //
	// listProfilRemu.addAll(context.getBeansOfType(ProfilRemuneration.class).values());
	//
	// listGrades.stream().forEach(g -> gradeService.sauvegarder(g));
	//
	// }

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void initialiser() {
		
		Utilisateur user1 = new Utilisateur("user1", this.passwordEncoder.encode("password1") , true, ROLES.ROLE_ADMINISTRATEUR);
		Utilisateur user2 = new Utilisateur("user2",  this.passwordEncoder.encode("password2"), true, ROLES.ROLE_UTILISATEUR);
		Utilisateur user3 = new Utilisateur("user3",  this.passwordEncoder.encode("password3"), false, ROLES.ROLE_UTILISATEUR);
		
		context.getBeansOfType(Cotisation.class).forEach((nomBean, bean) -> em.persist(bean));
		context.getBeansOfType(Entreprise.class).forEach((nomBean, bean) -> em.persist(bean));
		context.getBeansOfType(Grade.class).forEach((nomBean, bean) -> em.persist(bean));
		context.getBeansOfType(ProfilRemuneration.class).forEach((nomBean, bean) -> em.persist(bean));
		context.getBeansOfType(Periode.class).forEach((nomBean, bean) -> em.persist(bean));
		
		em.persist(user1);
		em.persist(user2);
		em.persist(user3);
		
		for (int i = 1; i < 13; i++) {
            LocalDate localdate = LocalDate.of(LocalDate.now().getYear(), i, 1);
            em.persist(new Periode( localdate, localdate.with(TemporalAdjusters.lastDayOfMonth())));
        }
		

	}

}
