package com.zsmart.cnss.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SalarieImmatriculation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Salarie salarie;
    @ManyToOne
    private ImmatriculationDemande immatriculationDemande;

    public SalarieImmatriculation() {
        super();
    }

    public SalarieImmatriculation(Long id, Salarie salarie, ImmatriculationDemande immatriculationDemande) {
        super();
        this.id = id;
        this.salarie = salarie;
        this.immatriculationDemande = immatriculationDemande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        this.salarie = salarie;
    }

    public ImmatriculationDemande getImmatriculationDemande() {
        return immatriculationDemande;
    }

    public void setImmatriculationDemande(ImmatriculationDemande immatriculationDemande) {
        this.immatriculationDemande = immatriculationDemande;
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
        SalarieImmatriculation other = (SalarieImmatriculation) obj;
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
        return "SalarieImmatriculation [id=" + id + "]";
    }

}
