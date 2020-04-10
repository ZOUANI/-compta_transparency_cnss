package com.zsmart.cnss.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class DeclarationSalarieItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Salarie salarie;
	@ManyToOne
	private DeclarationSalarie declarationSalarie;
	@Column(precision = 3, scale = 4)
	private BigDecimal salaireBrut;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dateDeclarationSalarie;
	public DeclarationSalarieItem() {
		super();
	}
	public DeclarationSalarieItem(Long id, Salarie salarie, DeclarationSalarie declarationSalarie,
			BigDecimal salaireBrut, Date dateDeclarationSalarie) {
		super();
		this.id = id;
		this.salarie = salarie;
		this.declarationSalarie = declarationSalarie;
		this.salaireBrut = salaireBrut;
		this.dateDeclarationSalarie = dateDeclarationSalarie;
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
	public DeclarationSalarie getDeclarationSalarie() {
		return declarationSalarie;
	}
	public void setDeclarationSalarie(DeclarationSalarie declarationSalarie) {
		this.declarationSalarie = declarationSalarie;
	}
	public BigDecimal getSalaireBrut() {
		return salaireBrut;
	}
	public void setSalaireBrut(BigDecimal salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	public Date getDateDeclarationSalarie() {
		return dateDeclarationSalarie;
	}
	public void setDateDeclarationSalarie(Date dateDeclarationSalarie) {
		this.dateDeclarationSalarie = dateDeclarationSalarie;
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
		DeclarationSalarieItem other = (DeclarationSalarieItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DeclarationSalarieItem [id=" + id + ", salarie=" + salarie + ", declarationSalarie="
				+ declarationSalarie + ", salaireBrut=" + salaireBrut + ", dateDeclarationSalarie="
				+ dateDeclarationSalarie + "]";
	}
	

}
