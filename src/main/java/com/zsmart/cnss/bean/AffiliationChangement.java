package com.zsmart.cnss.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class AffiliationChangement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numAffiliation;
    private TypeDemande typeDemande;
    private String description;
    @OneToMany(mappedBy = "affiliationChangement")
    private List<ObjetChangementAffiliation> objetChangementAffiliations;
    @OneToMany
    private List<PiecesAffiliationChangement> piecesDemandeChangements;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateChangementAffiliation;

    public AffiliationChangement() {
        super();
    }

    public AffiliationChangement(Long id, String numAffiliation, TypeDemande typeDemande, String description,
            List<ObjetChangementAffiliation> objetChangementAffiliations,
            List<PiecesAffiliationChangement> piecesDemandeChangements, Date dateChangementAffiliation) {
        super();
        this.id = id;
        this.numAffiliation = numAffiliation;
        this.typeDemande = typeDemande;
        this.description = description;
        this.objetChangementAffiliations = objetChangementAffiliations;
        this.piecesDemandeChangements = piecesDemandeChangements;
        this.dateChangementAffiliation = dateChangementAffiliation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumAffiliation() {
        return numAffiliation;
    }

    public void setNumAffiliation(String numAffiliation) {
        this.numAffiliation = numAffiliation;
    }

    public TypeDemande getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(TypeDemande typeDemande) {
        this.typeDemande = typeDemande;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ObjetChangementAffiliation> getObjetChangementAffiliations() {
        return objetChangementAffiliations;
    }

    public void setObjetChangementAffiliations(List<ObjetChangementAffiliation> objetChangementAffiliations) {
        this.objetChangementAffiliations = objetChangementAffiliations;
    }

    public List<PiecesAffiliationChangement> getPiecesDemandeChangements() {
        return piecesDemandeChangements;
    }

    public void setPiecesDemandeChangements(List<PiecesAffiliationChangement> piecesDemandeChangements) {
        this.piecesDemandeChangements = piecesDemandeChangements;
    }

    public Date getDateChangementAffiliation() {
        return dateChangementAffiliation;
    }

    public void setDateChangementAffiliation(Date dateChangementAffiliation) {
        this.dateChangementAffiliation = dateChangementAffiliation;
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AffiliationChangement other = (AffiliationChangement) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AffiliationChangement [id=" + id + ", numAffiliation=" + numAffiliation + ", description=" + description
                + ", dateChangementAffiliation=" + dateChangementAffiliation + "]";
    }

}
