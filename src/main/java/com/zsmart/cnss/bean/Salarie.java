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
public class Salarie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String nom;
	private String prenom;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dateNaissance;
	private String sexe;
	private String nationalite;
	private String cin; // si la nationalité sélectionnée est la marocaine le CIN doit être obligatoire,
						// dans les autres cas, il faut renseigner soit le numéro du passeport soit le
						// numéro de la carte de séjour.
	private String adresse;
	private String codePostal;
	private String ville;
	private String email;
	private String telNum;
	private String numImmatriculation;
	@ManyToOne
	private TypeSalarie typeSalarie; // (SO : Sortant, CO : Congé sans solde MS : Maintenu sans salaire AT :
											// Accident de travail MP : Maladie Professionnelle ML : Maladie, MT :
											// Maternité, DE : Décédé)
	@ManyToOne
	private Affilie dernierAffilie;
	@ManyToOne
	private ImmatriculationDemande immatriculationDemande;
	@OneToMany(mappedBy = "salarie")
	private List<ImmatriculationChangement> immatriculationChangements;

	public Salarie() {
		super();
	}


	public Salarie(Long id, String nom, String prenom, Date dateNaissance, String sexe, String nationalite, String cin,
			String adresse, String codePostal, String ville, String email, String telNum, String numImmatriculation,
			TypeSalarie typeSalarie, Affilie dernierAffilie, ImmatriculationDemande immatriculationDemande,
			List<ImmatriculationChangement> immatriculationChangements) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.nationalite = nationalite;
		this.cin = cin;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.email = email;
		this.telNum = telNum;
		this.numImmatriculation = numImmatriculation;
		this.typeSalarie = typeSalarie;
		this.dernierAffilie = dernierAffilie;
		this.immatriculationDemande = immatriculationDemande;
		this.immatriculationChangements = immatriculationChangements;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getNumImmatriculation() {
		return numImmatriculation;
	}

	public void setNumImmatriculation(String numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}

	public Affilie getDernierAffilie() {
		return dernierAffilie;
	}

	public void setDernierAffilie(Affilie dernierAffilie) {
		this.dernierAffilie = dernierAffilie;
	}

	public ImmatriculationDemande getImmatriculationDemande() {
		return immatriculationDemande;
	}

	public void setImmatriculationDemande(ImmatriculationDemande immatriculationDemande) {
		this.immatriculationDemande = immatriculationDemande;
	}

	public List<ImmatriculationChangement> getImmatriculationChangements() {
		return immatriculationChangements;
	}

	public void setImmatriculationChangements(List<ImmatriculationChangement> immatriculationChangements) {
		this.immatriculationChangements = immatriculationChangements;
	}
	

	public TypeSalarie getTypeSalarie() {
		return typeSalarie;
	}


	public void setTypeSalarie(TypeSalarie typeSalarie) {
		this.typeSalarie = typeSalarie;
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
		Salarie other = (Salarie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salarie [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", sexe=" + sexe + ", nationalite=" + nationalite + ", cin=" + cin + ", adresse=" + adresse
				+ ", codePostal=" + codePostal + ", email=" + email + ", telNum=" + telNum + ", numImmatriculation="
				+ numImmatriculation + ", dernierAffilie=" + dernierAffilie + "]";
	}

}
