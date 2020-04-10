package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.PiecesImmatriculationChangement;
import com.zsmart.cnss.bean.PiecesObjetChangement; 
import com.zsmart.cnss.bean.ImmatriculationChangement; 
public interface PiecesImmatriculationChangementService {

public PiecesImmatriculationChangement save(PiecesImmatriculationChangement piecesimmatriculationchangement); 
public List<PiecesImmatriculationChangement>  findAll();
public PiecesImmatriculationChangement findById(Long id);
public int delete(PiecesImmatriculationChangement piecesimmatriculationchangement);
public void  deleteById(Long id);
public void clone(PiecesImmatriculationChangement piecesimmatriculationchangement,PiecesImmatriculationChangement piecesimmatriculationchangementClone);
public PiecesImmatriculationChangement clone(PiecesImmatriculationChangement piecesimmatriculationchangement);
public List<PiecesImmatriculationChangement> clone(List<PiecesImmatriculationChangement>piecesimmatriculationchangements);
 public List<PiecesImmatriculationChangement>  findByCriteria(Long idMin,Long idMax,int nombreFourniMin,int nombreFourniMax);

}
