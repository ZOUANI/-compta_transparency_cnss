package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.PieceService;
import com.zsmart.cnss.dao.PieceDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class PieceServiceImpl implements PieceService {

    @Autowired

    private PieceDao pieceDao;

    @Autowired

    private EntityManager entityManager;

    @Override
    public Piece save(Piece piece) {

        if (piece == null) {
            return null;
        } else {
            pieceDao.save(piece);
            return piece;
        }
    }

    @Override
    public List< Piece> findAll() {
        return pieceDao.findAll();
    }

    @Override
    public Piece findById(Long id) {
        return pieceDao.getOne(id);
    }

    @Override
    public Piece findByReference(String reference) {
        return pieceDao.findByReference(reference);
    }

    @Override
    public int delete(Piece piece) {
        if (piece == null) {
            return -1;
        } else {
            pieceDao.delete(piece);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        pieceDao.deleteById(id);
    }

    @Override
    public void deleteByReference(String reference) {
        pieceDao.deleteByReference(reference);
    }

    public void clone(Piece piece, Piece pieceClone) {
        if (piece != null && pieceClone != null) {
            pieceClone.setId(piece.getId());
            pieceClone.setLibelle(piece.getLibelle());
            pieceClone.setReference(piece.getReference());
        }
    }

    public Piece clone(Piece piece) {
        if (piece == null) {
            return null;
        } else {
            Piece pieceClone = new Piece();
            clone(piece, pieceClone);
            return pieceClone;
        }
    }

    public List<Piece> clone(List<Piece> pieces) {
        if (pieces == null) {
            return null;
        } else {
            List<Piece> piecesClone = new ArrayList();
            pieces.forEach((piece) -> {
                piecesClone.add(clone(piece));
            });
            return piecesClone;
        }
    }

    @Override
    public List< Piece> findByCriteria(String libelle, String reference, Long idMin, Long idMax) {
        return entityManager.createQuery(constructQuery(libelle, reference, idMin, idMax)).getResultList();
    }

    private String constructQuery(String libelle, String reference, Long idMin, Long idMax) {
        String query = "SELECT p FROM Piece p where 1=1 ";
        query += SearchUtil.addConstraint("p", "libelle", "=", libelle);
        query += SearchUtil.addConstraint("p", "reference", "=", reference);
        query += SearchUtil.addConstraintMinMax("p", "id", idMin, idMax);

        return query;
    }
}
