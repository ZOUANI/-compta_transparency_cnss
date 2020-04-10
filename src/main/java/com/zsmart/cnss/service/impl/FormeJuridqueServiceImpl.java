
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.FormeJuridqueService ; 
import com.zsmart.cnss.dao.FormeJuridqueDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.FormeJuridque;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class FormeJuridqueServiceImpl implements FormeJuridqueService  {


 @Autowired 

 private FormeJuridqueDao formejuridqueDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public FormeJuridque  save (FormeJuridque formejuridque){

if(formejuridque== null){ 
 return null; 
}else {
 formejuridqueDao.save(formejuridque);
return formejuridque;
}
}

 @Override 
public List< FormeJuridque>  findAll(){
 return formejuridqueDao.findAll();
}

 @Override 
public FormeJuridque findById(Long id){
 return formejuridqueDao.getOne(id);
}

 @Override 
public int delete(FormeJuridque formejuridque){
if(formejuridque== null){ 
  return -1; 
}else {
 formejuridqueDao.delete(formejuridque);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       formejuridqueDao.deleteById(id);
}
public void clone(FormeJuridque formejuridque,FormeJuridque formejuridqueClone){
if(formejuridque!= null && formejuridqueClone != null){
formejuridqueClone.setId(formejuridque.getId());
formejuridqueClone.setLibelle(formejuridque.getLibelle());
}
}
public FormeJuridque clone(FormeJuridque formejuridque){
if(formejuridque== null){       return null ;
}else{FormeJuridque formejuridqueClone= new FormeJuridque();
 clone(formejuridque,formejuridqueClone);
return formejuridqueClone;
}
}
public List<FormeJuridque> clone(List<FormeJuridque>formejuridques){
if(formejuridques== null){
       return null ;
}else{List<FormeJuridque> formejuridquesClone = new ArrayList();
	 	 	 formejuridques.forEach((formejuridque)->{formejuridquesClone.add(clone(formejuridque));
});return formejuridquesClone;
}
}
 @Override 
 public List< FormeJuridque>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT f FROM FormeJuridque f where 1=1 ";
query += SearchUtil.addConstraint( "f", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("f", "id", idMin, idMax);

  return query; 
}
}
