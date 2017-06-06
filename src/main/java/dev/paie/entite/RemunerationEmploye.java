package dev.paie.entite;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class RemunerationEmploye {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String matricule;
	@OneToOne
	private Entreprise entreprise;
	@OneToOne
	private ProfilRemuneration profilRemuneration;
	@OneToOne
	private Grade grade;
	
	private ZonedDateTime dateCreation;
	
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public ZonedDateTime getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(ZonedDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public String dateForm() {
        return dateCreation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }
	
	@Override
	public String toString() {
		return " " + matricule + " ";
	}

}
