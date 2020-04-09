package com.zsmart.cnss.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ObjetChangementAffiliation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ObjetChangement objetChangement;
    @ManyToOne
    private AffiliationChangement affiliationChangement;

    public ObjetChangementAffiliation() {
        super();
    }

    public ObjetChangementAffiliation(Long id, ObjetChangement objetChangement,
            AffiliationChangement affiliationChangement) {
        super();
        this.id = id;
        this.objetChangement = objetChangement;
        this.affiliationChangement = affiliationChangement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObjetChangement getObjetChangement() {
        return objetChangement;
    }

    public void setObjetChangement(ObjetChangement objetChangement) {
        this.objetChangement = objetChangement;
    }

    public AffiliationChangement getAffiliationChangement() {
        return affiliationChangement;
    }

    public void setAffiliationChangement(AffiliationChangement affiliationChangement) {
        this.affiliationChangement = affiliationChangement;
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
        ObjetChangementAffiliation other = (ObjetChangementAffiliation) obj;
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
        return "ObjetChangementAffiliation [id=" + id + "]";
    }

}
