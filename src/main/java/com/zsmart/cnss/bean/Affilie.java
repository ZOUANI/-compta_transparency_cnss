package com.zsmart.cnss.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Affilie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String raisonSocial;
	@OneToMany(mappedBy = "affilie")
	private List<DeclarationSalarie> declarationSalaries;
	@ManyToOne
	private FormeJuridque formeJuridique;
	private String numTaxePro;
	private String numRegistreComerciale;
	private String idFiscal;
	private String iceSociete;
	private String numAffiliationSocieteMere;
	private String numSalariesEmployes;
	private String datePremierSalarie;
	private String adresseSiegeSocial;
	private String typeSiegeSocial;
	private String commune;
	private String quartie;
	private Ville  ville;
	private String codePostal;
	private String numTel;
	private String email;
	@Column(precision = 3, scale = 4)
	private BigDecimal totalSalaire;
	public Affilie() {
		super();
	}
	public Affilie(Long id, String raisonSocial, FormeJuridque formeJuridique, String numTaxePro,
			String numRegistreComerciale, String idFiscal, String iceSociete, String numAffiliationSocieteMere,
			String numSalariesEmployes, String datePremierSalarie, String adresseSiegeSocial, String typeSiegeSocial,
			String commune, String quartie, Ville ville, String codePostal, String numTel, String email) {
		super();
		this.id = id;
		this.raisonSocial = raisonSocial;
		this.formeJuridique = formeJuridique;
		this.numTaxePro = numTaxePro;
		this.numRegistreComerciale = numRegistreComerciale;
		this.idFiscal = idFiscal;
		this.iceSociete = iceSociete;
		this.numAffiliationSocieteMere = numAffiliationSocieteMere;
		this.numSalariesEmployes = numSalariesEmployes;
		this.datePremierSalarie = datePremierSalarie;
		this.adresseSiegeSocial = adresseSiegeSocial;
		this.typeSiegeSocial = typeSiegeSocial;
		this.commune = commune;
		this.quartie = quartie;
		this.ville = ville;
		this.codePostal = codePostal;
		this.numTel = numTel;
		this.email = email;
	}
	
	public BigDecimal getTotalSalaire() {
		return totalSalaire;
	}
	public void setTotalSalaire(BigDecimal totalSalaire) {
		this.totalSalaire = totalSalaire;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public FormeJuridque getFormeJuridique() {
		return formeJuridique;
	}
	public void setFormeJuridique(FormeJuridque formeJuridique) {
		this.formeJuridique = formeJuridique;
	}
	public String getNumTaxePro() {
		return numTaxePro;
	}
	public void setNumTaxePro(String numTaxePro) {
		this.numTaxePro = numTaxePro;
	}
	public String getNumRegistreComerciale() {
		return numRegistreComerciale;
	}
	public void setNumRegistreComerciale(String numRegistreComerciale) {
		this.numRegistreComerciale = numRegistreComerciale;
	}
	public String getIdFiscal() {
		return idFiscal;
	}
	public void setIdFiscal(String idFiscal) {
		this.idFiscal = idFiscal;
	}
	public String getIceSociete() {
		return iceSociete;
	}
	public void setIceSociete(String iceSociete) {
		this.iceSociete = iceSociete;
	}
	public String getNumAffiliationSocieteMere() {
		return numAffiliationSocieteMere;
	}
	public void setNumAffiliationSocieteMere(String numAffiliationSocieteMere) {
		this.numAffiliationSocieteMere = numAffiliationSocieteMere;
	}
	public String getNumSalariesEmployes() {
		return numSalariesEmployes;
	}
	public void setNumSalariesEmployes(String numSalariesEmployes) {
		this.numSalariesEmployes = numSalariesEmployes;
	}
	public String getDatePremierSalarie() {
		return datePremierSalarie;
	}
	public void setDatePremierSalarie(String datePremierSalarie) {
		this.datePremierSalarie = datePremierSalarie;
	}
	public String getAdresseSiegeSocial() {
		return adresseSiegeSocial;
	}
	public void setAdresseSiegeSocial(String adresseSiegeSocial) {
		this.adresseSiegeSocial = adresseSiegeSocial;
	}
	public String getTypeSiegeSocial() {
		return typeSiegeSocial;
	}
	public void setTypeSiegeSocial(String typeSiegeSocial) {
		this.typeSiegeSocial = typeSiegeSocial;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getQuartie() {
		return quartie;
	}
	public void setQuartie(String quartie) {
		this.quartie = quartie;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<DeclarationSalarie> getDeclarationSalaries() {
		return declarationSalaries;
	}
	public void setDeclarationSalaries(List<DeclarationSalarie> declarationSalaries) {
		this.declarationSalaries = declarationSalaries;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affilie other = (Affilie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Affilie [id=" + id + ", raisonSocial=" + raisonSocial + ", numTaxePro=" + numTaxePro
				+ ", numRegistreComerciale=" + numRegistreComerciale + ", idFiscal=" + idFiscal + ", iceSociete="
				+ iceSociete + ", numAffiliationSocieteMere=" + numAffiliationSocieteMere + ", numSalariesEmployes="
				+ numSalariesEmployes + ", datePremierSalarie=" + datePremierSalarie + ", adresseSiegeSocial="
				+ adresseSiegeSocial + ", typeSiegeSocial=" + typeSiegeSocial + ", commune=" + commune + ", quartie="
				+ quartie +  ", codePostal=" + codePostal + ", numTel=" + numTel + ", email="
				+ email + "]";
	}

	
}
