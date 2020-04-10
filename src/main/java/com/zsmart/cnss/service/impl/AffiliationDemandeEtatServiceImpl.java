
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.AffiliationDemandeEtatService ; 
import com.zsmart.cnss.dao.AffiliationDemandeEtatDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.AffiliationDemandeEtat;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class AffiliationDemandeEtatServiceImpl implements AffiliationDemandeEtatService  {


 @Autowired 

 private AffiliationDemandeEtatDao affiliationdemandeetatDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public AffiliationDemandeEtat  save (AffiliationDemandeEtat affiliationdemandeetat){

if(affiliationdemandeetat== null){ 
 return null; 
}else {
 affiliationdemandeetatDao.save(affiliationdemandeetat);
return affiliationdemandeetat;
}
}

 @Override 
public List< AffiliationDemandeEtat>  findAll(){
 return affiliationdemandeetatDao.findAll();
}

 @Override 
public AffiliationDemandeEtat findById(Long id){
 return affiliationdemandeetatDao.getOne(id);
}

 @Override 
public AffiliationDemandeEtat  findByReference(String  reference){
 return affiliationdemandeetatDao.findByReference(reference);
}

 @Override 
public int delete(AffiliationDemandeEtat affiliationdemandeetat){
if(affiliationdemandeetat== null){ 
  return -1; 
}else {
 affiliationdemandeetatDao.delete(affiliationdemandeetat);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       affiliationdemandeetatDao.deleteById(id);
}

 @Override 
public void  deleteByReference(String  reference){
  affiliationdemandeetatDao.deleteByReference(reference);
}
public void clone(AffiliationDemandeEtat affiliationdemandeetat,AffiliationDemandeEtat affiliationdemandeetatClone){
if(affiliationdemandeetat!= null && affiliationdemandeetatClone != null){
affiliationdemandeetatClone.setId(affiliationdemandeetat.getId());
affiliationdemandeetatClone.setLibelle(affiliationdemandeetat.getLibelle());
affiliationdemandeetatClone.setReference(affiliationdemandeetat.getReference());
}
}
public AffiliationDemandeEtat clone(AffiliationDemandeEtat affiliationdemandeetat){
if(affiliationdemandeetat== null){       return null ;
}else{AffiliationDemandeEtat affiliationdemandeetatClone= new AffiliationDemandeEtat();
 clone(affiliationdemandeetat,affiliationdemandeetatClone);
return affiliationdemandeetatClone;
}
}
public List<AffiliationDemandeEtat> clone(List<AffiliationDemandeEtat>affiliationdemandeetats){
if(affiliationdemandeetats== null){
       return null ;
}else{List<AffiliationDemandeEtat> affiliationdemandeetatsClone = new ArrayList();
	 	 	 affiliationdemandeetats.forEach((affiliationdemandeetat)->{affiliationdemandeetatsClone.add(clone(affiliationdemandeetat));
});return affiliationdemandeetatsClone;
}
}
 @Override 
 public List< AffiliationDemandeEtat>  findByCriteria(String libelle,String reference,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,reference,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,String reference,Long idMin,Long idMax){
String query = "SELECT a FROM AffiliationDemandeEtat a where 1=1 ";
query += SearchUtil.addConstraint( "a", "libelle","=",libelle);
query += SearchUtil.addConstraint( "a", "reference","=",reference);
query += SearchUtil.addConstraintMinMax("a", "id", idMin, idMax);

  return query; 
}
}
