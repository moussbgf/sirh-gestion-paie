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
import dev.paie.entite.Grade;

////Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })

@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;



	@Test
	public void lister_test() {

		List<Grade> listeGradesApresSauvegarde = gradeService.lister();

		boolean nb = listeGradesApresSauvegarde.stream().filter(g -> g.getId().equals(1)).count() > 0;

		assertTrue(nb);

	}



	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//
		// // TODO sauvegarder un nouveau grade
		//
		// // TODO vérifier qu'il est possible de récupérer le nouveau grade via
		// la méthode lister
		//
		// // TODO modifier un grade
		//
		// // TODO vérifier que les modifications sont bien prises en compte via
		// la méthode lister

		// Sauvegarde
		Integer id = new Random().nextInt();
		Grade nouveauGrade = new Grade();
		nouveauGrade.setId(id);
		nouveauGrade.setCode(UUID.randomUUID().toString());
		nouveauGrade.setNbHeuresBase(new BigDecimal("151.67"));
		nouveauGrade.setTauxBase(new BigDecimal("11.0984"));

		gradeService.sauvegarder(nouveauGrade);

		// Lister

		List<Grade> listeGradesApresSauvegarde = gradeService.lister();
		assertTrue(listeGradesApresSauvegarde.stream().anyMatch(g -> g.getId().equals(id)));

		// Modification
		Grade gradeAModifie = listeGradesApresSauvegarde.get(0);
		String codeModifie = UUID.randomUUID().toString();
		gradeAModifie.setCode(codeModifie);

		gradeService.mettreAJour(gradeAModifie);

		// Lister

		List<Grade> listeGradesApresModif = gradeService.lister();
		assertTrue(listeGradesApresModif.stream().filter(g -> g.getCode().equals(codeModifie)).count() > 0);

	}

}
