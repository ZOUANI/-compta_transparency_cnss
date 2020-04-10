package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.ImmatriculationDemandeEtat;
public interface ImmatriculationDemandeEtatService {

public ImmatriculationDemandeEtat save(ImmatriculationDemandeEtat immatriculationdemandeetat); 
public List<ImmatriculationDemandeEtat>  findAll();
public ImmatriculationDemandeEtat findById(Long id);
public ImmatriculationDemandeEtat  findByReference(String  reference);
public int delete(ImmatriculationDemandeEtat immatriculationdemandeetat);
public void  deleteById(Long id);
public void  deleteByReference(String  reference);
public void clone(ImmatriculationDemandeEtat immatriculationdemandeetat,ImmatriculationDemandeEtat immatriculationdemandeetatClone);
public ImmatriculationDemandeEtat clone(ImmatriculationDemandeEtat immatriculationdemandeetat);
public List<ImmatriculationDemandeEtat> clone(List<ImmatriculationDemandeEtat>immatriculationdemandeetats);
 public List<ImmatriculationDemandeEtat>  findByCriteria(String libelle,String reference,Long idMin,Long idMax);

}
