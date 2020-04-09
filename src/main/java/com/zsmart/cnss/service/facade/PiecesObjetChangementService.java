package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.PiecesObjetChangement;
import com.zsmart.cnss.bean.Piece;
import com.zsmart.cnss.bean.ObjetChangement;

public interface PiecesObjetChangementService {

    public PiecesObjetChangement save(PiecesObjetChangement piecesobjetchangement);

    public List<PiecesObjetChangement> findAll();

    public PiecesObjetChangement findById(Long id);

    public int delete(PiecesObjetChangement piecesobjetchangement);

    public void deleteById(Long id);

    public void clone(PiecesObjetChangement piecesobjetchangement, PiecesObjetChangement piecesobjetchangementClone);

    public PiecesObjetChangement clone(PiecesObjetChangement piecesobjetchangement);

    public List<PiecesObjetChangement> clone(List<PiecesObjetChangement> piecesobjetchangements);

    public List<PiecesObjetChangement> findByCriteria(Long idMin, Long idMax, int numbrePiecesMin, int numbrePiecesMax);

}
