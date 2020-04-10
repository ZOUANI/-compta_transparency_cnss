package com.zsmart.cnss.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class AffiliationDemande implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String reference;
	@ManyToOne
	private Affilie affilie;
	@OneToMany(mappedBy = "affliationDemande")
	private List<LieuActivite> lieuActivites;
	@OneToMany(mappedBy ="affiliationDemande")
	private List<SalarieAffiliation> salarieAffiliations;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDemandeAffiliation;
	public AffiliationDemande() {
		super();
	}
	public AffiliationDemande(Long id, String reference, Affilie affilie, List<LieuActivite> lieuActivites,
			List<SalarieAffiliation> salarieAffiliations, Date dateDemandeAffiliation) {
		super();
		this.id = id;
		this.reference = reference;
		this.affilie = affilie;
		this.lieuActivites = lieuActivites;
		this.salarieAffiliations = salarieAffiliations;
		this.dateDemandeAffiliation = dateDemandeAffiliation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Affilie getAffilie() {
		return affilie;
	}
	public void setAffilie(Affilie affilie) {
		this.affilie = affilie;
	}
	public List<LieuActivite> getLieuActivites() {
		return lieuActivites;
	}
	public void setLieuActivites(List<LieuActivite> lieuActivites) {
		this.lieuActivites = lieuActivites;
	}
	public List<SalarieAffiliation> getSalarieAffiliations() {
		return salarieAffiliations;
	}
	public void setSalarieAffiliations(List<SalarieAffiliation> salarieAffiliations) {
		this.salarieAffiliations = salarieAffiliations;
	}
	public Date getDateDemandeAffiliation() {
		return dateDemandeAffiliation;
	}
	public void setDateDemandeAffiliation(Date dateDemandeAffiliation) {
		this.dateDemandeAffiliation = dateDemandeAffiliation;
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
		AffiliationDemande other = (AffiliationDemande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AffiliationDemande [id=" + id + ", reference=" + reference + ", dateDemandeAffiliation="
				+ dateDemandeAffiliation + "]";
	}
	
	
	
	
	

	
	
	
	
	
	
}
