package dev.paie.web.form;

import java.math.BigDecimal;

import dev.paie.entite.RemunerationEmploye;

public class BulletinForm {
	private Integer periode;
	private Integer remunerationEmploye;
	private String primeExceptionnelle;
	
	public Integer getPeriode() {
		return periode;
	}
	public void setPeriode(Integer periode) {
		this.periode = periode;
	}
	public Integer getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(Integer remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public String getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(String primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	
	
	
	
}
