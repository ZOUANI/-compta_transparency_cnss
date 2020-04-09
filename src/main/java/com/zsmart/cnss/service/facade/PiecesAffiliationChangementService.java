package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.PiecesAffiliationChangement;
import com.zsmart.cnss.bean.PiecesObjetChangement;
import com.zsmart.cnss.bean.AffiliationChangement;

public interface PiecesAffiliationChangementService {

    public PiecesAffiliationChangement save(PiecesAffiliationChangement piecesaffiliationchangement);

    public List<PiecesAffiliationChangement> findAll();

    public PiecesAffiliationChangement findById(Long id);

    public int delete(PiecesAffiliationChangement piecesaffiliationchangement);

    public void deleteById(Long id);

    public void clone(PiecesAffiliationChangement piecesaffiliationchangement, PiecesAffiliationChangement piecesaffiliationchangementClone);

    public PiecesAffiliationChangement clone(PiecesAffiliationChangement piecesaffiliationchangement);

    public List<PiecesAffiliationChangement> clone(List<PiecesAffiliationChangement> piecesaffiliationchangements);

    public List<PiecesAffiliationChangement> findByCriteria(Long idMin, Long idMax, int nombreFourniMin, int nombreFourniMax);

}
