package com.zsmart.cnss.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ObjetChangementImmatriculation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ObjetChangement objetChangement;
    @ManyToOne
    private ImmatriculationChangement immatriculationChangement;

    public ObjetChangementImmatriculation() {
        super();
    }

    public ObjetChangementImmatriculation(Long id, ObjetChangement objetChangement,
            ImmatriculationChangement immatriculationChangement) {
        super();
        this.id = id;
        this.objetChangement = objetChangement;
        this.immatriculationChangement = immatriculationChangement;
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

    public ImmatriculationChangement getImmatriculationChangement() {
        return immatriculationChangement;
    }

    public void setImmatriculationChangement(ImmatriculationChangement immatriculationChangement) {
        this.immatriculationChangement = immatriculationChangement;
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
        ObjetChangementImmatriculation other = (ObjetChangementImmatriculation) obj;
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
        return "ObjetChangementImmatriculation [id=" + id + "]";
    }

}
