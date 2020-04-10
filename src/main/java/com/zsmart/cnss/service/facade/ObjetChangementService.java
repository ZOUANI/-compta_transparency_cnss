package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.ObjetChangement;
public interface ObjetChangementService {

public ObjetChangement save(ObjetChangement objetchangement); 
public List<ObjetChangement>  findAll();
public ObjetChangement findById(Long id);
public int delete(ObjetChangement objetchangement);
public void  deleteById(Long id);
public void clone(ObjetChangement objetchangement,ObjetChangement objetchangementClone);
public ObjetChangement clone(ObjetChangement objetchangement);
public List<ObjetChangement> clone(List<ObjetChangement>objetchangements);
 public List<ObjetChangement>  findByCriteria(String libelle,Long idMin,Long idMax);

}
