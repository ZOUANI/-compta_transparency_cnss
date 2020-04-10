
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.PiecesImmatriculationChangementService ; 
import com.zsmart.cnss.dao.PiecesImmatriculationChangementDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.PiecesImmatriculationChangement;
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
import com.zsmart.cnss.bean.ImmatriculationChangement; 
import com.zsmart.cnss.service.facade.ImmatriculationChangementService ; 

 @Service  

 public class PiecesImmatriculationChangementServiceImpl implements PiecesImmatriculationChangementService  {


 @Autowired 

 private PiecesImmatriculationChangementDao piecesimmatriculationchangementDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private PiecesObjetChangementService piecesobjetchangementService; 

 @Autowired 

 private ImmatriculationChangementService immatriculationchangementService; 

 @Override 
public PiecesImmatriculationChangement  save (PiecesImmatriculationChangement piecesimmatriculationchangement){

if(piecesimmatriculationchangement== null){ 
 return null; 
}else {
 piecesimmatriculationchangementDao.save(piecesimmatriculationchangement);
return piecesimmatriculationchangement;
}
}

 @Override 
public List< PiecesImmatriculationChangement>  findAll(){
 return piecesimmatriculationchangementDao.findAll();
}

 @Override 
public PiecesImmatriculationChangement findById(Long id){
 return piecesimmatriculationchangementDao.getOne(id);
}

 @Override 
public int delete(PiecesImmatriculationChangement piecesimmatriculationchangement){
if(piecesimmatriculationchangement== null){ 
  return -1; 
}else {
 piecesimmatriculationchangementDao.delete(piecesimmatriculationchangement);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       piecesimmatriculationchangementDao.deleteById(id);
}
public void clone(PiecesImmatriculationChangement piecesimmatriculationchangement,PiecesImmatriculationChangement piecesimmatriculationchangementClone){
if(piecesimmatriculationchangement!= null && piecesimmatriculationchangementClone != null){
piecesimmatriculationchangementClone.setId(piecesimmatriculationchangement.getId());
piecesimmatriculationchangementClone.setNombreFourni(piecesimmatriculationchangement.getNombreFourni());
piecesimmatriculationchangementClone.setPiecesObjetChangement(piecesobjetchangementService.clone(piecesimmatriculationchangement.getPiecesObjetChangement()));
piecesimmatriculationchangementClone.setImmatriculationChangement(immatriculationchangementService.clone(piecesimmatriculationchangement.getImmatriculationChangement()));
}
}
public PiecesImmatriculationChangement clone(PiecesImmatriculationChangement piecesimmatriculationchangement){
if(piecesimmatriculationchangement== null){       return null ;
}else{PiecesImmatriculationChangement piecesimmatriculationchangementClone= new PiecesImmatriculationChangement();
 clone(piecesimmatriculationchangement,piecesimmatriculationchangementClone);
return piecesimmatriculationchangementClone;
}
}
public List<PiecesImmatriculationChangement> clone(List<PiecesImmatriculationChangement>piecesimmatriculationchangements){
if(piecesimmatriculationchangements== null){
       return null ;
}else{List<PiecesImmatriculationChangement> piecesimmatriculationchangementsClone = new ArrayList();
	 	 	 piecesimmatriculationchangements.forEach((piecesimmatriculationchangement)->{piecesimmatriculationchangementsClone.add(clone(piecesimmatriculationchangement));
});return piecesimmatriculationchangementsClone;
}
}
 @Override 
 public List< PiecesImmatriculationChangement>  findByCriteria(Long idMin,Long idMax,int nombreFourniMin,int nombreFourniMax){
 return entityManager.createQuery(constructQuery(idMin,idMax,nombreFourniMin,nombreFourniMax)).getResultList(); 
 }
private String constructQuery(Long idMin,Long idMax,int nombreFourniMin,int nombreFourniMax){
String query = "SELECT p FROM PiecesImmatriculationChangement p where 1=1 ";
query += SearchUtil.addConstraintMinMax("p", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("p", "nombreFourni", nombreFourniMin, nombreFourniMax);

  return query; 
}
}
