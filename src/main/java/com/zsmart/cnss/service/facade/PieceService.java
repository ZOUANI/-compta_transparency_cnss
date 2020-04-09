package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.Piece;

public interface PieceService {

    public Piece save(Piece piece);

    public List<Piece> findAll();

    public Piece findById(Long id);

    public Piece findByReference(String reference);

    public int delete(Piece piece);

    public void deleteById(Long id);

    public void deleteByReference(String reference);

    public void clone(Piece piece, Piece pieceClone);

    public Piece clone(Piece piece);

    public List<Piece> clone(List<Piece> pieces);

    public List<Piece> findByCriteria(String libelle, String reference, Long idMin, Long idMax);

}
