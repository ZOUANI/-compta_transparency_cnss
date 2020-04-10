
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.AffiliationChangementService ; 
import com.zsmart.cnss.dao.AffiliationChangementDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.AffiliationChangement;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.TypeDemande; 
import com.zsmart.cnss.service.facade.TypeDemandeService ; 
import com.zsmart.cnss.service.facade.ObjetChangementAffiliationService ; 
import com.zsmart.cnss.bean.ObjetChangementAffiliation ; 
import com.zsmart.cnss.service.facade.PiecesAffiliationChangementService ; 
import com.zsmart.cnss.bean.PiecesAffiliationChangement ; 

 @Service  

 public class AffiliationChangementServiceImpl implements AffiliationChangementService  {


 @Autowired 

 private AffiliationChangementDao affiliationchangementDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private ObjetChangementAffiliationService objetchangementaffiliationService; 

 @Autowired 

 private PiecesAffiliationChangementService piecesaffiliationchangementService; 

 @Autowired 

 private TypeDemandeService typedemandeService; 

 @Override 
public AffiliationChangement  save (AffiliationChangement affiliationchangement){

if(affiliationchangement== null){ 
 return null; 
}else {
 affiliationchangementDao.save(affiliationchangement);
return affiliationchangement;
}
}

 @Override 
public AffiliationChangement  saveWithObjetChangementAffiliations (AffiliationChangement affiliationchangement){

if(affiliationchangement== null){ 
        return null; 
}else {
   if(affiliationchangement.getObjetChangementAffiliations().isEmpty()){
            return null;
        }else{
affiliationchangementDao.save(affiliationchangement);
            for (ObjetChangementAffiliation objetchangementaffiliation : affiliationchangement.getObjetChangementAffiliations()) {
objetchangementaffiliation.setAffiliationChangement(affiliationchangement);
 objetchangementaffiliationService.save(  objetchangementaffiliation);          
            }
return affiliationchangement;
}
}
            }

 @Override 
public AffiliationChangement  saveWithPiecesDemandeChangements (AffiliationChangement affiliationchangement){

if(affiliationchangement== null){ 
        return null; 
}else {
   if(affiliationchangement.getPiecesDemandeChangements().isEmpty()){
            return null;
        }else{
affiliationchangementDao.save(affiliationchangement);
            for (PiecesAffiliationChangement piecesaffiliationchangement : affiliationchangement.getPiecesDemandeChangements()) {
piecesaffiliationchangement.setAffiliationChangement(affiliationchangement);
 piecesaffiliationchangementService.save(  piecesaffiliationchangement);          
            }
return affiliationchangement;
}
}
            }

 @Override 
public List< AffiliationChangement>  findAll(){
 return affiliationchangementDao.findAll();
}

 @Override 
public AffiliationChangement findById(Long id){
 return affiliationchangementDao.getOne(id);
}

 @Override 
public int delete(AffiliationChangement affiliationchangement){
if(affiliationchangement== null){ 
  return -1; 
}else {
 affiliationchangementDao.delete(affiliationchangement);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       affiliationchangementDao.deleteById(id);
}
public void clone(AffiliationChangement affiliationchangement,AffiliationChangement affiliationchangementClone){
if(affiliationchangement!= null && affiliationchangementClone != null){
affiliationchangementClone.setId(affiliationchangement.getId());
affiliationchangementClone.setNumAffiliation(affiliationchangement.getNumAffiliation());
affiliationchangementClone.setDescription(affiliationchangement.getDescription());
affiliationchangementClone.setDateChangementAffiliation(affiliationchangement.getDateChangementAffiliation());
affiliationchangementClone.setTypeDemande(typedemandeService.clone(affiliationchangement.getTypeDemande()));
affiliationchangementClone.setObjetChangementAffiliations(objetchangementaffiliationService.clone(affiliationchangement.getObjetChangementAffiliations()));
affiliationchangementClone.setPiecesDemandeChangements(piecesaffiliationchangementService.clone(affiliationchangement.getPiecesDemandeChangements()));
}
}
public AffiliationChangement clone(AffiliationChangement affiliationchangement){
if(affiliationchangement== null){       return null ;
}else{AffiliationChangement affiliationchangementClone= new AffiliationChangement();
 clone(affiliationchangement,affiliationchangementClone);
return affiliationchangementClone;
}
}
public List<AffiliationChangement> clone(List<AffiliationChangement>affiliationchangements){
if(affiliationchangements== null){
       return null ;
}else{List<AffiliationChangement> affiliationchangementsClone = new ArrayList();
	 	 	 affiliationchangements.forEach((affiliationchangement)->{affiliationchangementsClone.add(clone(affiliationchangement));
});return affiliationchangementsClone;
}
}
 @Override 
 public List< AffiliationChangement>  findByCriteria(String numAffiliation,String description,Long idMin,Long idMax,Date dateChangementAffiliationMin,Date dateChangementAffiliationMax){
 return entityManager.createQuery(constructQuery(numAffiliation,description,idMin,idMax,dateChangementAffiliationMin,dateChangementAffiliationMax)).getResultList(); 
 }
private String constructQuery(String numAffiliation,String description,Long idMin,Long idMax,Date dateChangementAffiliationMin,Date dateChangementAffiliationMax){
String query = "SELECT a FROM AffiliationChangement a where 1=1 ";
query += SearchUtil.addConstraint( "a", "numAffiliation","=",numAffiliation);
query += SearchUtil.addConstraint( "a", "description","=",description);
query += SearchUtil.addConstraintMinMax("a", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMaxDate("a"," dateChangementAffiliation", dateChangementAffiliationMin, dateChangementAffiliationMax);

  return query; 
}
}
