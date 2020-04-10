
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.ObjetChangementAffiliationService ; 
import com.zsmart.cnss.dao.ObjetChangementAffiliationDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.ObjetChangementAffiliation;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.ObjetChangement; 
import com.zsmart.cnss.service.facade.ObjetChangementService ; 
import com.zsmart.cnss.bean.AffiliationChangement; 
import com.zsmart.cnss.service.facade.AffiliationChangementService ; 

 @Service  

 public class ObjetChangementAffiliationServiceImpl implements ObjetChangementAffiliationService  {


 @Autowired 

 private ObjetChangementAffiliationDao objetchangementaffiliationDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private ObjetChangementService objetchangementService; 

 @Autowired 

 private AffiliationChangementService affiliationchangementService; 

 @Override 
public ObjetChangementAffiliation  save (ObjetChangementAffiliation objetchangementaffiliation){

if(objetchangementaffiliation== null){ 
 return null; 
}else {
 objetchangementaffiliationDao.save(objetchangementaffiliation);
return objetchangementaffiliation;
}
}

 @Override 
public List< ObjetChangementAffiliation>  findAll(){
 return objetchangementaffiliationDao.findAll();
}

 @Override 
public ObjetChangementAffiliation findById(Long id){
 return objetchangementaffiliationDao.getOne(id);
}

 @Override 
public int delete(ObjetChangementAffiliation objetchangementaffiliation){
if(objetchangementaffiliation== null){ 
  return -1; 
}else {
 objetchangementaffiliationDao.delete(objetchangementaffiliation);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       objetchangementaffiliationDao.deleteById(id);
}
public void clone(ObjetChangementAffiliation objetchangementaffiliation,ObjetChangementAffiliation objetchangementaffiliationClone){
if(objetchangementaffiliation!= null && objetchangementaffiliationClone != null){
objetchangementaffiliationClone.setId(objetchangementaffiliation.getId());
objetchangementaffiliationClone.setObjetChangement(objetchangementService.clone(objetchangementaffiliation.getObjetChangement()));
objetchangementaffiliationClone.setAffiliationChangement(affiliationchangementService.clone(objetchangementaffiliation.getAffiliationChangement()));
}
}
public ObjetChangementAffiliation clone(ObjetChangementAffiliation objetchangementaffiliation){
if(objetchangementaffiliation== null){       return null ;
}else{ObjetChangementAffiliation objetchangementaffiliationClone= new ObjetChangementAffiliation();
 clone(objetchangementaffiliation,objetchangementaffiliationClone);
return objetchangementaffiliationClone;
}
}
public List<ObjetChangementAffiliation> clone(List<ObjetChangementAffiliation>objetchangementaffiliations){
if(objetchangementaffiliations== null){
       return null ;
}else{List<ObjetChangementAffiliation> objetchangementaffiliationsClone = new ArrayList();
	 	 	 objetchangementaffiliations.forEach((objetchangementaffiliation)->{objetchangementaffiliationsClone.add(clone(objetchangementaffiliation));
});return objetchangementaffiliationsClone;
}
}
 @Override 
 public List< ObjetChangementAffiliation>  findByCriteria(Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(idMin,idMax)).getResultList(); 
 }
private String constructQuery(Long idMin,Long idMax){
String query = "SELECT o FROM ObjetChangementAffiliation o where 1=1 ";
query += SearchUtil.addConstraintMinMax("o", "id", idMin, idMax);

  return query; 
}
}
