package com.zsmart.cnss.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SalarieAffiliation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Salarie salarie;
    @ManyToOne
    private AffiliationDemande affiliationDemande;

    public SalarieAffiliation() {
        super();
    }

    public SalarieAffiliation(Long id, Salarie salarie, AffiliationDemande affiliationDemande) {
        super();
        this.id = id;
        this.salarie = salarie;
        this.affiliationDemande = affiliationDemande;
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

    public AffiliationDemande getAffiliationDemande() {
        return affiliationDemande;
    }

    public void setAffiliationDemande(AffiliationDemande affiliationDemande) {
        this.affiliationDemande = affiliationDemande;
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
        SalarieAffiliation other = (SalarieAffiliation) obj;
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
        return "SalarieAffiliation [id=" + id + "]";
    }

}
