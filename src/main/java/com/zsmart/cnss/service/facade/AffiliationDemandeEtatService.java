package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.AffiliationDemandeEtat;
public interface AffiliationDemandeEtatService {

public AffiliationDemandeEtat save(AffiliationDemandeEtat affiliationdemandeetat); 
public List<AffiliationDemandeEtat>  findAll();
public AffiliationDemandeEtat findById(Long id);
public AffiliationDemandeEtat  findByReference(String  reference);
public int delete(AffiliationDemandeEtat affiliationdemandeetat);
public void  deleteById(Long id);
public void  deleteByReference(String  reference);
public void clone(AffiliationDemandeEtat affiliationdemandeetat,AffiliationDemandeEtat affiliationdemandeetatClone);
public AffiliationDemandeEtat clone(AffiliationDemandeEtat affiliationdemandeetat);
public List<AffiliationDemandeEtat> clone(List<AffiliationDemandeEtat>affiliationdemandeetats);
 public List<AffiliationDemandeEtat>  findByCriteria(String libelle,String reference,Long idMin,Long idMax);

}
