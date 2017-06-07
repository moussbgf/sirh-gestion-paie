package dev.paie.service;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

//@ContextConfiguration(classes = { ServicesConfig.class } )

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils p;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration result = new ResultatCalculRemuneration();

		// SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
		BigDecimal salaireDeBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		result.setSalaireDeBase(p.formaterBigDecimal(salaireDeBase));

		// SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
		BigDecimal salaireBrut = salaireDeBase.add(bulletin.getPrimeExceptionnelle());
		result.setSalaireBrut(p.formaterBigDecimal(salaireBrut));

		// TOTAL_RETENUE_SALARIALE =
		// SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		BigDecimal totalRetenueSalarial = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(c -> c.getTauxSalarial() != null)
				.map(c -> c.getTauxSalarial().multiply(new BigDecimal(result.getSalaireBrut())))
				.collect(Collectors.reducing((v1, v2) -> v1.add(v2))).orElse(new BigDecimal("0"));

		System.out.println(p.formaterBigDecimal(totalRetenueSalarial));
		result.setTotalRetenueSalarial(p.formaterBigDecimal(totalRetenueSalarial));

		// TOTAL_COTISATIONS_PATRONALES =
		// SOMME(COTISATION_NON_IMPOSABLE.TAUX_PATRONAL*SALAIRE_BRUT)
		BigDecimal totalRetenuePatronale = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(c -> c.getTauxPatronal() != null)
				.map(c -> c.getTauxPatronal().multiply(new BigDecimal(result.getSalaireBrut())))
				.collect(Collectors.reducing((v1, v2) -> v1.add(v2))).orElse(new BigDecimal(0));
		result.setTotalCotisationsPatronales(p.formaterBigDecimal(totalRetenuePatronale));

		// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE
		BigDecimal netImposable = new BigDecimal(result.getSalaireBrut())
				.subtract(new BigDecimal(result.getTotalRetenueSalarial()));
		result.setNetImposable(p.formaterBigDecimal(netImposable));

		// NET_A_PAYER = NET_IMPOSABLE -
		// SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		BigDecimal somme = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
				.filter(c -> c.getTauxSalarial() != null)
				.map(c -> c.getTauxSalarial().multiply(new BigDecimal(result.getSalaireBrut())))
				.collect(Collectors.reducing((v1, v2) -> v1.add(v2))).orElse(new BigDecimal("0"));
		result.setNetAPayer(p.formaterBigDecimal(new BigDecimal(result.getNetImposable()).subtract(somme)));

		return result;

	}
}
