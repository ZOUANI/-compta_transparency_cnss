package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.ImmatriculationChangementEtat;
public interface ImmatriculationChangementEtatService {

public ImmatriculationChangementEtat save(ImmatriculationChangementEtat immatriculationchangementetat); 
public List<ImmatriculationChangementEtat>  findAll();
public ImmatriculationChangementEtat findById(Long id);
public ImmatriculationChangementEtat  findByReference(String  reference);
public int delete(ImmatriculationChangementEtat immatriculationchangementetat);
public void  deleteById(Long id);
public void  deleteByReference(String  reference);
public void clone(ImmatriculationChangementEtat immatriculationchangementetat,ImmatriculationChangementEtat immatriculationchangementetatClone);
public ImmatriculationChangementEtat clone(ImmatriculationChangementEtat immatriculationchangementetat);
public List<ImmatriculationChangementEtat> clone(List<ImmatriculationChangementEtat>immatriculationchangementetats);
 public List<ImmatriculationChangementEtat>  findByCriteria(String libelle,String reference,Long idMin,Long idMax);

}
