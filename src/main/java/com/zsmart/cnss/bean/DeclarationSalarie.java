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
import javax.persistence.Temporal;

@Entity
public class DeclarationSalarie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private TypeDeclarationSalarie typeDeclarationSalarie; // régime général ou régime agricole
	private Integer periode;
	private Integer annee;
	private Integer nombreJoursTravaille;
	@ManyToOne
	private Affilie affilie;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dateDeclaration;
	@OneToMany(mappedBy = "declarationSalarie")
	private List<DeclarationSalarieItem> declarationSalarieItems;
	
	public DeclarationSalarie() {
		super();
	}
	public DeclarationSalarie(Long id, TypeDeclarationSalarie typeDeclarationSalarie, int periode, int annee,
			int nombreJoursTravaille, Affilie affilie, Date dateDeclaration,
			List<DeclarationSalarieItem> declarationSalarieItems) {
		super();
		this.id = id;
		this.typeDeclarationSalarie = typeDeclarationSalarie;
		this.periode = periode;
		this.annee = annee;
		this.nombreJoursTravaille = nombreJoursTravaille;
		this.affilie = affilie;
		this.dateDeclaration = dateDeclaration;
		this.declarationSalarieItems = declarationSalarieItems;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TypeDeclarationSalarie getTypeDeclarationSalarie() {
		return typeDeclarationSalarie;
	}
	public void setTypeDeclarationSalarie(TypeDeclarationSalarie typeDeclarationSalarie) {
		this.typeDeclarationSalarie = typeDeclarationSalarie;
	}
	
	
	public Integer getPeriode() {
		return periode;
	}
	public void setPeriode(Integer periode) {
		this.periode = periode;
	}
	public Integer getAnnee() {
		return annee;
	}
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	public Integer getNombreJoursTravaille() {
		return nombreJoursTravaille;
	}
	public void setNombreJoursTravaille(Integer nombreJoursTravaille) {
		this.nombreJoursTravaille = nombreJoursTravaille;
	}
	public Affilie getAffilie() {
		return affilie;
	}
	public void setAffilie(Affilie affilie) {
		this.affilie = affilie;
	}
	public Date getDateDeclaration() {
		return dateDeclaration;
	}
	public void setDateDeclaration(Date dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}
	public List<DeclarationSalarieItem> getDeclarationSalarieItems() {
		return declarationSalarieItems;
	}
	public void setDeclarationSalarieItems(List<DeclarationSalarieItem> declarationSalarieItems) {
		this.declarationSalarieItems = declarationSalarieItems;
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
		DeclarationSalarie other = (DeclarationSalarie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DeclarationSalarie [id=" + id + ", periode=" + periode + ", annee=" + annee + ", nombreJoursTravaille="
				+ nombreJoursTravaille + ", dateDeclaration=" + dateDeclaration + "]";
	}
	
	
	

}
