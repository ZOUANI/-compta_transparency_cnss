package com.zsmart.cnss.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class ImmatriculationDemande implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numImmatriculation;
	@ManyToOne
	private Affilie affilie;
	@OneToMany(mappedBy = "immatriculationDemande")
	private List<SalarieImmatriculation> salarieImmatriculations;
	@ManyToOne
	private ImmatriculationDemandeEtat immatriculationDemandeEtat;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dateDemandeImmatriculation;
	public ImmatriculationDemande() {
		super();
	}
	public ImmatriculationDemande(Long id, String numImmatriculation, Affilie affilie,
			List<SalarieImmatriculation> salarieImmatriculations, ImmatriculationDemandeEtat immatriculationDemandeEtat,
			Date dateDemandeImmatriculation) {
		super();
		this.id = id;
		this.numImmatriculation = numImmatriculation;
		this.affilie = affilie;
		this.salarieImmatriculations = salarieImmatriculations;
		this.immatriculationDemandeEtat = immatriculationDemandeEtat;
		this.dateDemandeImmatriculation = dateDemandeImmatriculation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumImmatriculation() {
		return numImmatriculation;
	}
	public void setNumImmatriculation(String numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}
	public Affilie getAffilie() {
		return affilie;
	}
	public void setAffilie(Affilie affilie) {
		this.affilie = affilie;
	}
	public List<SalarieImmatriculation> getSalarieImmatriculations() {
		return salarieImmatriculations;
	}
	public void setSalarieImmatriculations(List<SalarieImmatriculation> salarieImmatriculations) {
		this.salarieImmatriculations = salarieImmatriculations;
	}
	public ImmatriculationDemandeEtat getImmatriculationDemandeEtat() {
		return immatriculationDemandeEtat;
	}
	public void setImmatriculationDemandeEtat(ImmatriculationDemandeEtat immatriculationDemandeEtat) {
		this.immatriculationDemandeEtat = immatriculationDemandeEtat;
	}
	public Date getDateDemandeImmatriculation() {
		return dateDemandeImmatriculation;
	}
	public void setDateDemandeImmatriculation(Date dateDemandeImmatriculation) {
		this.dateDemandeImmatriculation = dateDemandeImmatriculation;
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
		ImmatriculationDemande other = (ImmatriculationDemande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ImmatriculationDemande [id=" + id + ", numImmatriculation=" + numImmatriculation + "]";
	}
	
	

}
