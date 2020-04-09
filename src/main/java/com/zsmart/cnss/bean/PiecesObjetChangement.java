package com.zsmart.cnss.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PiecesObjetChangement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Piece piece;
    @ManyToOne
    private ObjetChangement objetChangement;
    private Integer numbrePieces;

    public PiecesObjetChangement() {
        super();
    }

    public PiecesObjetChangement(Long id, Piece piece, ObjetChangement objetChangement, int numbrePieces) {
        super();
        this.id = id;
        this.piece = piece;
        this.objetChangement = objetChangement;
        this.numbrePieces = numbrePieces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public ObjetChangement getObjetChangement() {
        return objetChangement;
    }

    public void setObjetChangement(ObjetChangement objetChangement) {
        this.objetChangement = objetChangement;
    }

    public Integer getNumbrePieces() {
        return numbrePieces;
    }

    public void setNumbrePieces(Integer numbrePieces) {
        this.numbrePieces = numbrePieces;
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
        PiecesObjetChangement other = (PiecesObjetChangement) obj;
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
        return "PiecesObjetChangement [id=" + id + ", numbrePieces=" + numbrePieces + "]";
    }

}
