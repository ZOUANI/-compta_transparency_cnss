
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.ImmatriculationChangementService ; 
import com.zsmart.cnss.dao.ImmatriculationChangementDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.ImmatriculationChangement;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.TypeChangement; 
import com.zsmart.cnss.service.facade.TypeChangementService ; 
import com.zsmart.cnss.bean.Salarie; 
import com.zsmart.cnss.service.facade.SalarieService ; 
import com.zsmart.cnss.bean.ImmatriculationChangementEtat; 
import com.zsmart.cnss.service.facade.ImmatriculationChangementEtatService ; 
import com.zsmart.cnss.service.facade.ObjetChangementImmatriculationService ; 
import com.zsmart.cnss.bean.ObjetChangementImmatriculation ; 
import com.zsmart.cnss.service.facade.PiecesImmatriculationChangementService ; 
import com.zsmart.cnss.bean.PiecesImmatriculationChangement ; 

 @Service  

 public class ImmatriculationChangementServiceImpl implements ImmatriculationChangementService  {


 @Autowired 

 private ImmatriculationChangementDao immatriculationchangementDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private ObjetChangementImmatriculationService objetchangementimmatriculationService; 

 @Autowired 

 private PiecesImmatriculationChangementService piecesimmatriculationchangementService; 

 @Autowired 

 private TypeChangementService typechangementService; 

 @Autowired 

 private SalarieService salarieService; 

 @Autowired 

 private ImmatriculationChangementEtatService immatriculationchangementetatService; 

 @Override 
public ImmatriculationChangement  save (ImmatriculationChangement immatriculationchangement){

if(immatriculationchangement== null){ 
 return null; 
}else {
 immatriculationchangementDao.save(immatriculationchangement);
return immatriculationchangement;
}
}

 @Override 
public ImmatriculationChangement  saveWithObjetChangementImmatriculations (ImmatriculationChangement immatriculationchangement){

if(immatriculationchangement== null){ 
        return null; 
}else {
   if(immatriculationchangement.getObjetChangementImmatriculations().isEmpty()){
            return null;
        }else{
immatriculationchangementDao.save(immatriculationchangement);
            for (ObjetChangementImmatriculation objetchangementimmatriculation : immatriculationchangement.getObjetChangementImmatriculations()) {
objetchangementimmatriculation.setImmatriculationChangement(immatriculationchangement);
 objetchangementimmatriculationService.save(  objetchangementimmatriculation);          
            }
return immatriculationchangement;
}
}
            }

 @Override 
public ImmatriculationChangement  saveWithPiecesImmatriculationChangements (ImmatriculationChangement immatriculationchangement){

if(immatriculationchangement== null){ 
        return null; 
}else {
   if(immatriculationchangement.getPiecesImmatriculationChangements().isEmpty()){
            return null;
        }else{
immatriculationchangementDao.save(immatriculationchangement);
            for (PiecesImmatriculationChangement piecesimmatriculationchangement : immatriculationchangement.getPiecesImmatriculationChangements()) {
piecesimmatriculationchangement.setImmatriculationChangement(immatriculationchangement);
 piecesimmatriculationchangementService.save(  piecesimmatriculationchangement);          
            }
return immatriculationchangement;
}
}
            }

 @Override 
public List< ImmatriculationChangement>  findAll(){
 return immatriculationchangementDao.findAll();
}

 @Override 
public ImmatriculationChangement findById(Long id){
 return immatriculationchangementDao.getOne(id);
}

 @Override 
public int delete(ImmatriculationChangement immatriculationchangement){
if(immatriculationchangement== null){ 
  return -1; 
}else {
 immatriculationchangementDao.delete(immatriculationchangement);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       immatriculationchangementDao.deleteById(id);
}
public void clone(ImmatriculationChangement immatriculationchangement,ImmatriculationChangement immatriculationchangementClone){
if(immatriculationchangement!= null && immatriculationchangementClone != null){
immatriculationchangementClone.setId(immatriculationchangement.getId());
immatriculationchangementClone.setNumAffiliation(immatriculationchangement.getNumAffiliation());
immatriculationchangementClone.setDescription(immatriculationchangement.getDescription());
immatriculationchangementClone.setDateChangementImmatriculation(immatriculationchangement.getDateChangementImmatriculation());
immatriculationchangementClone.setTypeChangement(typechangementService.clone(immatriculationchangement.getTypeChangement()));
immatriculationchangementClone.setSalarie(salarieService.clone(immatriculationchangement.getSalarie()));
immatriculationchangementClone.setImmatriculationChangementEtat(immatriculationchangementetatService.clone(immatriculationchangement.getImmatriculationChangementEtat()));
immatriculationchangementClone.setObjetChangementImmatriculations(objetchangementimmatriculationService.clone(immatriculationchangement.getObjetChangementImmatriculations()));
immatriculationchangementClone.setPiecesImmatriculationChangements(piecesimmatriculationchangementService.clone(immatriculationchangement.getPiecesImmatriculationChangements()));
}
}
public ImmatriculationChangement clone(ImmatriculationChangement immatriculationchangement){
if(immatriculationchangement== null){       return null ;
}else{ImmatriculationChangement immatriculationchangementClone= new ImmatriculationChangement();
 clone(immatriculationchangement,immatriculationchangementClone);
return immatriculationchangementClone;
}
}
public List<ImmatriculationChangement> clone(List<ImmatriculationChangement>immatriculationchangements){
if(immatriculationchangements== null){
       return null ;
}else{List<ImmatriculationChangement> immatriculationchangementsClone = new ArrayList();
	 	 	 immatriculationchangements.forEach((immatriculationchangement)->{immatriculationchangementsClone.add(clone(immatriculationchangement));
});return immatriculationchangementsClone;
}
}
 @Override 
 public List< ImmatriculationChangement>  findByCriteria(String numAffiliation,String description,Long idMin,Long idMax,Date dateChangementImmatriculationMin,Date dateChangementImmatriculationMax){
 return entityManager.createQuery(constructQuery(numAffiliation,description,idMin,idMax,dateChangementImmatriculationMin,dateChangementImmatriculationMax)).getResultList(); 
 }
private String constructQuery(String numAffiliation,String description,Long idMin,Long idMax,Date dateChangementImmatriculationMin,Date dateChangementImmatriculationMax){
String query = "SELECT i FROM ImmatriculationChangement i where 1=1 ";
query += SearchUtil.addConstraint( "i", "numAffiliation","=",numAffiliation);
query += SearchUtil.addConstraint( "i", "description","=",description);
query += SearchUtil.addConstraintMinMax("i", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMaxDate("i"," dateChangementImmatriculation", dateChangementImmatriculationMin, dateChangementImmatriculationMax);

  return query; 
}
}
