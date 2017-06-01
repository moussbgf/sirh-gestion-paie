package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { ServicesConfig.class })

@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		// TODO sauvegarder une nouvelle cotisation
		Cotisation nouvelleCotisation = new Cotisation();

		Integer id = new Random().nextInt();

		// private Integer id;
		// private String code;
		// private String libelle;
		// private BigDecimal tauxSalarial;
		// private BigDecimal tauxPatronal;

		nouvelleCotisation.setId(id);
		nouvelleCotisation.setCode(UUID.randomUUID().toString());
		nouvelleCotisation.setCode("Bravo !");
		nouvelleCotisation.setTauxSalarial(new BigDecimal("151.67"));
		nouvelleCotisation.setTauxPatronal(new BigDecimal("151.67"));

		cotisationService.sauvegarder(nouvelleCotisation);

		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via lacméthode lister
		List<Cotisation> listeCotisationApresSauvegarde = cotisationService.lister();
		assertTrue(listeCotisationApresSauvegarde.stream().anyMatch(g -> g.getId().equals(id)));

		// TODO modifier une cotisation
		nouvelleCotisation.setId(2);
		cotisationService.mettreAJour(nouvelleCotisation);
		assertTrue(listeCotisationApresSauvegarde.stream().anyMatch(g -> g.getId().equals(id)));

		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		
		
	}

//	@Test
//	public void test_sauvegarder_lister_mettre_a_jour2() {
//
//		Cotisation newcotisation = new Cotisation();
//		newcotisation.setId((int) (Math.random() * 100000));
//		newcotisation.setCode("code");
//		newcotisation.setLibelle("libelle");
//		newcotisation.setTauxPatronal(new BigDecimal("15"));
//		newcotisation.setTauxSalarial(new BigDecimal("30"));
//		System.out.println(newcotisation);
//		cotisationService.sauvegarder(newcotisation);
//		System.out.println(cotisationService);
//
//		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
//		// via laméthode lister
//		boolean bool = false;
//		List<Cotisation> listcoti = cotisationService.lister();
//		for (Cotisation gr : listcoti) {
//			if (gr.getCode().equals(newcotisation.getCode())) {
//				bool = true;
//			}
//
//		}
//		assertTrue(bool);
//		// TODO modifier une cotisation
//		newcotisation.setCode("test");
//		cotisationService.mettreAJour(newcotisation);
//		// TODO vérifier que les modifications sont bien prises en compte via la
//		// méthode lister
//		List<Cotisation> listcotiapresmodif = cotisationService.lister();
//		for (Cotisation gr : listcotiapresmodif) {
//			if (gr.getCode().equals(newcotisation.getCode())) {
//				bool = true;
//			}
//
//		}
//		assertTrue(bool);
//	}
}
