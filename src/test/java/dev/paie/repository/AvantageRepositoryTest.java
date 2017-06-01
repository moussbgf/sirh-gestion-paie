package dev.paie.repository;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

//TODO compléter la configuration

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		// private Integer id;
		// private String code;
		// private String nom;
		// private BigDecimal montant;


		Avantage nouveauAvantage = new Avantage();

		// TODO sauvegarder un nouvel avantage

		Integer id = 1;

		nouveauAvantage.setId(id);
		nouveauAvantage.setCode(UUID.randomUUID().toString());
		nouveauAvantage.setNom("nom ok !");
		nouveauAvantage.setMontant(new BigDecimal("151.67"));

		avantageRepository.save(nouveauAvantage);

		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne
		Avantage av = avantageRepository.findOne(id);
		
		assertTrue(av.getId() == id );
		
		// TODO modifier un avantage
		nouveauAvantage.setNom("modif ok ok !");
		avantageRepository.save(nouveauAvantage);

		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
		Avantage av2 = avantageRepository.findOne(id);
		assertTrue(av2.getNom().equals("modif ok ok !"));
		
	}

}