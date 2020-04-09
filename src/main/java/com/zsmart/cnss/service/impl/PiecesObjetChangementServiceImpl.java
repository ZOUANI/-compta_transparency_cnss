package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.PiecesObjetChangementService;
import com.zsmart.cnss.dao.PiecesObjetChangementDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.PiecesObjetChangement;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import org.springframework.stereotype.Service;
import java.util.List;
import com.zsmart.cnss.bean.Piece;
import com.zsmart.cnss.service.facade.PieceService;
import com.zsmart.cnss.bean.ObjetChangement;
import com.zsmart.cnss.service.facade.ObjetChangementService;

@Service

public class PiecesObjetChangementServiceImpl implements PiecesObjetChangementService {

    @Autowired

    private PiecesObjetChangementDao piecesobjetchangementDao;

    @Autowired

    private EntityManager entityManager;

    @Autowired

    private PieceService pieceService;

    @Autowired

    private ObjetChangementService objetchangementService;

    @Override
    public PiecesObjetChangement save(PiecesObjetChangement piecesobjetchangement) {

        if (piecesobjetchangement == null) {
            return null;
        } else {
            piecesobjetchangementDao.save(piecesobjetchangement);
            return piecesobjetchangement;
        }
    }

    @Override
    public List< PiecesObjetChangement> findAll() {
        return piecesobjetchangementDao.findAll();
    }

    @Override
    public PiecesObjetChangement findById(Long id) {
        return piecesobjetchangementDao.getOne(id);
    }

    @Override
    public int delete(PiecesObjetChangement piecesobjetchangement) {
        if (piecesobjetchangement == null) {
            return -1;
        } else {
            piecesobjetchangementDao.delete(piecesobjetchangement);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        piecesobjetchangementDao.deleteById(id);
    }

    public void clone(PiecesObjetChangement piecesobjetchangement, PiecesObjetChangement piecesobjetchangementClone) {
        if (piecesobjetchangement != null && piecesobjetchangementClone != null) {
            piecesobjetchangementClone.setId(piecesobjetchangement.getId());
            piecesobjetchangementClone.setNumbrePieces(piecesobjetchangement.getNumbrePieces());
            piecesobjetchangementClone.setPiece(pieceService.clone(piecesobjetchangement.getPiece()));
            piecesobjetchangementClone.setObjetChangement(objetchangementService.clone(piecesobjetchangement.getObjetChangement()));
        }
    }

    public PiecesObjetChangement clone(PiecesObjetChangement piecesobjetchangement) {
        if (piecesobjetchangement == null) {
            return null;
        } else {
            PiecesObjetChangement piecesobjetchangementClone = new PiecesObjetChangement();
            clone(piecesobjetchangement, piecesobjetchangementClone);
            return piecesobjetchangementClone;
        }
    }

    public List<PiecesObjetChangement> clone(List<PiecesObjetChangement> piecesobjetchangements) {
        if (piecesobjetchangements == null) {
            return null;
        } else {
            List<PiecesObjetChangement> piecesobjetchangementsClone = new ArrayList();
            piecesobjetchangements.forEach((piecesobjetchangement) -> {
                piecesobjetchangementsClone.add(clone(piecesobjetchangement));
            });
            return piecesobjetchangementsClone;
        }
    }

    @Override
    public List< PiecesObjetChangement> findByCriteria(Long idMin, Long idMax, int numbrePiecesMin, int numbrePiecesMax) {
        return entityManager.createQuery(constructQuery(idMin, idMax, numbrePiecesMin, numbrePiecesMax)).getResultList();
    }

    private String constructQuery(Long idMin, Long idMax, int numbrePiecesMin, int numbrePiecesMax) {
        String query = "SELECT p FROM PiecesObjetChangement p where 1=1 ";
        query += SearchUtil.addConstraintMinMax("p", "id", idMin, idMax);
        query += SearchUtil.addConstraintMinMax("p", "numbrePieces", numbrePiecesMin, numbrePiecesMax);

        return query;
    }
}
