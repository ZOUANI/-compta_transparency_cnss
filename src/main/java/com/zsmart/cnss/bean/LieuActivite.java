package com.zsmart.cnss.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LieuActivite implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String adresse;
	private String commune;
	private Ville  ville;
	private String codePostal;
	@ManyToOne
    private AffiliationDemande affliationDemande;
	public LieuActivite() {
		super();
	}
	public LieuActivite(Long id, String adresse, String commune, Ville ville, String codePostal,
			AffiliationDemande affliationDemande) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.commune = commune;
		this.ville = ville;
		this.codePostal = codePostal;
		this.affliationDemande = affliationDemande;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
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
	public AffiliationDemande getAffliationDemande() {
		return affliationDemande;
	}
	public void setAffliationDemande(AffiliationDemande affliationDemande) {
		this.affliationDemande = affliationDemande;
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
		LieuActivite other = (LieuActivite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LieuActivite [id=" + id + ", adresse=" + adresse + ", commune=" + commune + ", codePostal=" + codePostal
				+ "]";
	}
	
	
	

}
