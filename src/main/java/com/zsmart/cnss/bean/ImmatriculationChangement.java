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
public class ImmatriculationChangement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private TypeChangement typeChangement;
    private String numAffiliation;
    private String description;
    @ManyToOne
    private Salarie salarie;
    @OneToMany(mappedBy = "immatriculationChangement")
    private List<ObjetChangementImmatriculation> objetChangementImmatriculations;
    @OneToMany
    private List<PiecesImmatriculationChangement> piecesImmatriculationChangements;
    @ManyToOne
    private ImmatriculationChangementEtat immatriculationChangementEtat;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateChangementImmatriculation;

    public ImmatriculationChangement() {
        super();
    }

    public ImmatriculationChangement(Long id, TypeChangement typeChangement, String numAffiliation, String description,
            Salarie salarie, List<ObjetChangementImmatriculation> objetChangementImmatriculations,
            List<PiecesImmatriculationChangement> piecesImmatriculationChangements,
            ImmatriculationChangementEtat immatriculationChangementEtat, Date dateChangementImmatriculation) {
        super();
        this.id = id;
        this.typeChangement = typeChangement;
        this.numAffiliation = numAffiliation;
        this.description = description;
        this.salarie = salarie;
        this.objetChangementImmatriculations = objetChangementImmatriculations;
        this.piecesImmatriculationChangements = piecesImmatriculationChangements;
        this.immatriculationChangementEtat = immatriculationChangementEtat;
        this.dateChangementImmatriculation = dateChangementImmatriculation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeChangement getTypeChangement() {
        return typeChangement;
    }

    public void setTypeChangement(TypeChangement typeChangement) {
        this.typeChangement = typeChangement;
    }

    public String getNumAffiliation() {
        return numAffiliation;
    }

    public void setNumAffiliation(String numAffiliation) {
        this.numAffiliation = numAffiliation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        this.salarie = salarie;
    }

    public List<ObjetChangementImmatriculation> getObjetChangementImmatriculations() {
        return objetChangementImmatriculations;
    }

    public void setObjetChangementImmatriculations(List<ObjetChangementImmatriculation> objetChangementImmatriculations) {
        this.objetChangementImmatriculations = objetChangementImmatriculations;
    }

    public List<PiecesImmatriculationChangement> getPiecesImmatriculationChangements() {
        return piecesImmatriculationChangements;
    }

    public void setPiecesImmatriculationChangements(
            List<PiecesImmatriculationChangement> piecesImmatriculationChangements) {
        this.piecesImmatriculationChangements = piecesImmatriculationChangements;
    }

    public ImmatriculationChangementEtat getImmatriculationChangementEtat() {
        return immatriculationChangementEtat;
    }

    public void setImmatriculationChangementEtat(ImmatriculationChangementEtat immatriculationChangementEtat) {
        this.immatriculationChangementEtat = immatriculationChangementEtat;
    }

    public Date getDateChangementImmatriculation() {
        return dateChangementImmatriculation;
    }

    public void setDateChangementImmatriculation(Date dateChangementImmatriculation) {
        this.dateChangementImmatriculation = dateChangementImmatriculation;
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
        ImmatriculationChangement other = (ImmatriculationChangement) obj;
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
        return "ImmatriculationChangement [id=" + id + ", numAffiliation=" + numAffiliation + ", description="
                + description + ", dateChangementImmatriculation=" + dateChangementImmatriculation + "]";
    }

}
