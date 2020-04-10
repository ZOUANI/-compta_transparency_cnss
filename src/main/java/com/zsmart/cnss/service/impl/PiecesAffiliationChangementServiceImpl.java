
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.PiecesAffiliationChangementService ; 
import com.zsmart.cnss.dao.PiecesAffiliationChangementDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.PiecesAffiliationChangement;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.PiecesObjetChangement; 
import com.zsmart.cnss.service.facade.PiecesObjetChangementService ; 
import com.zsmart.cnss.bean.AffiliationChangement; 
import com.zsmart.cnss.service.facade.AffiliationChangementService ; 

 @Service  

 public class PiecesAffiliationChangementServiceImpl implements PiecesAffiliationChangementService  {


 @Autowired 

 private PiecesAffiliationChangementDao piecesaffiliationchangementDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private PiecesObjetChangementService piecesobjetchangementService; 

 @Autowired 

 private AffiliationChangementService affiliationchangementService; 

 @Override 
public PiecesAffiliationChangement  save (PiecesAffiliationChangement piecesaffiliationchangement){

if(piecesaffiliationchangement== null){ 
 return null; 
}else {
 piecesaffiliationchangementDao.save(piecesaffiliationchangement);
return piecesaffiliationchangement;
}
}

 @Override 
public List< PiecesAffiliationChangement>  findAll(){
 return piecesaffiliationchangementDao.findAll();
}

 @Override 
public PiecesAffiliationChangement findById(Long id){
 return piecesaffiliationchangementDao.getOne(id);
}

 @Override 
public int delete(PiecesAffiliationChangement piecesaffiliationchangement){
if(piecesaffiliationchangement== null){ 
  return -1; 
}else {
 piecesaffiliationchangementDao.delete(piecesaffiliationchangement);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       piecesaffiliationchangementDao.deleteById(id);
}
public void clone(PiecesAffiliationChangement piecesaffiliationchangement,PiecesAffiliationChangement piecesaffiliationchangementClone){
if(piecesaffiliationchangement!= null && piecesaffiliationchangementClone != null){
piecesaffiliationchangementClone.setId(piecesaffiliationchangement.getId());
piecesaffiliationchangementClone.setNombreFourni(piecesaffiliationchangement.getNombreFourni());
piecesaffiliationchangementClone.setPiecesObjetChangement(piecesobjetchangementService.clone(piecesaffiliationchangement.getPiecesObjetChangement()));
piecesaffiliationchangementClone.setAffiliationChangement(affiliationchangementService.clone(piecesaffiliationchangement.getAffiliationChangement()));
}
}
public PiecesAffiliationChangement clone(PiecesAffiliationChangement piecesaffiliationchangement){
if(piecesaffiliationchangement== null){       return null ;
}else{PiecesAffiliationChangement piecesaffiliationchangementClone= new PiecesAffiliationChangement();
 clone(piecesaffiliationchangement,piecesaffiliationchangementClone);
return piecesaffiliationchangementClone;
}
}
public List<PiecesAffiliationChangement> clone(List<PiecesAffiliationChangement>piecesaffiliationchangements){
if(piecesaffiliationchangements== null){
       return null ;
}else{List<PiecesAffiliationChangement> piecesaffiliationchangementsClone = new ArrayList();
	 	 	 piecesaffiliationchangements.forEach((piecesaffiliationchangement)->{piecesaffiliationchangementsClone.add(clone(piecesaffiliationchangement));
});return piecesaffiliationchangementsClone;
}
}
 @Override 
 public List< PiecesAffiliationChangement>  findByCriteria(Long idMin,Long idMax,int nombreFourniMin,int nombreFourniMax){
 return entityManager.createQuery(constructQuery(idMin,idMax,nombreFourniMin,nombreFourniMax)).getResultList(); 
 }
private String constructQuery(Long idMin,Long idMax,int nombreFourniMin,int nombreFourniMax){
String query = "SELECT p FROM PiecesAffiliationChangement p where 1=1 ";
query += SearchUtil.addConstraintMinMax("p", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("p", "nombreFourni", nombreFourniMin, nombreFourniMax);

  return query; 
}
}
