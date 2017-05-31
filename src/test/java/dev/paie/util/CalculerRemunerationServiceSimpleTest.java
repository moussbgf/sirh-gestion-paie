package dev.paie.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.service.CalculerRemunerationService;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class, JeuxDeDonneesConfig.class } )

// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class CalculerRemunerationServiceSimpleTest {

	@Autowired
	private CalculerRemunerationService remunerationService;
	
	@Autowired
	private BulletinSalaire bulletinSalaire;
	
//	@Test
//	public void test_not_null() {
//		ResultatCalculRemuneration resultat = remunerationService.calculer(bulletinSalaire);
//		assertNotNull(resultat);
//	}
	
	@Test
	public void salaire_brut() {
		ResultatCalculRemuneration resultat = remunerationService.calculer(bulletinSalaire);
		assertThat(resultat.getSalaireBrut(), equalTo("2683.30"));
	}
	
	@Test
	public void test_total_remu_salairal() {
		ResultatCalculRemuneration resultat = remunerationService.calculer(bulletinSalaire);
		assertThat(resultat.getTotalRetenueSalarial(), equalTo("517.08"));
	}
	
	
	
	@Test
	public void test_calculer() {

		ResultatCalculRemuneration resultat = remunerationService.calculer(bulletinSalaire);
		
		//assertNotNull(resultat);

		assertThat(resultat.getSalaireBrut(), equalTo("2683.30"));

		assertThat(resultat.getTotalRetenueSalarial(), equalTo("517.08"));

		assertThat(resultat.getTotalCotisationsPatronales(), equalTo("1096.13"));

		assertThat(resultat.getNetImposable(), equalTo("2166.22"));

		assertThat(resultat.getNetAPayer(), equalTo("2088.41"));

	}
	
}
