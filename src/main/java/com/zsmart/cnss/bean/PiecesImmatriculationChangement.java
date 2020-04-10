package com.zsmart.cnss.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PiecesImmatriculationChangement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private PiecesObjetChangement piecesObjetChangement;
	private Integer nombreFourni;
	@ManyToOne
	private ImmatriculationChangement immatriculationChangement;
	public PiecesImmatriculationChangement() {
		super();
	}
	public PiecesImmatriculationChangement(Long id, PiecesObjetChangement piecesObjetChangement, Integer nombreFourni,
			ImmatriculationChangement immatriculationChangement) {
		super();
		this.id = id;
		this.piecesObjetChangement = piecesObjetChangement;
		this.nombreFourni = nombreFourni;
		this.immatriculationChangement = immatriculationChangement;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PiecesObjetChangement getPiecesObjetChangement() {
		return piecesObjetChangement;
	}
	public void setPiecesObjetChangement(PiecesObjetChangement piecesObjetChangement) {
		this.piecesObjetChangement = piecesObjetChangement;
	}
	public Integer getNombreFourni() {
		return nombreFourni;
	}
	public void setNombreFourni(Integer nombreFourni) {
		this.nombreFourni = nombreFourni;
	}
	public ImmatriculationChangement getImmatriculationChangement() {
		return immatriculationChangement;
	}
	public void setImmatriculationChangement(ImmatriculationChangement immatriculationChangement) {
		this.immatriculationChangement = immatriculationChangement;
	}
	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
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
		PiecesImmatriculationChangement other = (PiecesImmatriculationChangement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PiecesImmatriculationChangement [id=" + id + ", nombreFourni=" + nombreFourni + "]";
	}
	
	
}
