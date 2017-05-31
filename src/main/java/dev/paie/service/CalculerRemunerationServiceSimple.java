package dev.paie.service;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

//@ContextConfiguration(classes = { ServicesConfig.class } )

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {
	
	@Autowired private PaieUtils p;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		ResultatCalculRemuneration resultatCalculRemuneration = new ResultatCalculRemuneration();
		
		String salaireDeBase;
		String salaireBrut;
		
		BigDecimal nbHeuresBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase();
		BigDecimal tauxBase = bulletin.getRemunerationEmploye().getGrade().getTauxBase();
		
		BigDecimal salaireDeBaseDec = nbHeuresBase.multiply(tauxBase);
		
		salaireDeBase = p.formaterBigDecimal(salaireDeBaseDec);
		
		resultatCalculRemuneration.setSalaireDeBase(salaireDeBase); 
		
		BigDecimal salaireBrutDec = salaireDeBaseDec.add(bulletin.getPrimeExceptionnelle()) ;
		
		salaireBrut = p.formaterBigDecimal(salaireBrutDec);
		
		resultatCalculRemuneration.setSalaireBrut(salaireBrut);
		
		
		
		// TOTAL_RETENUE_SALARIALE = SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		
		
		
		return resultatCalculRemuneration;
	}

}
