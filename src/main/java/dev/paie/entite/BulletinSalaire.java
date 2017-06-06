package dev.paie.entite;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BulletinSalaire {
	
	public ZonedDateTime getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(ZonedDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private RemunerationEmploye remunerationEmploye;
	@ManyToOne
	private Periode periode;
	private BigDecimal primeExceptionnelle;
	
	private ZonedDateTime dateCreation;
	
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String dateForm() {
        return dateCreation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }
	
	
	
}
