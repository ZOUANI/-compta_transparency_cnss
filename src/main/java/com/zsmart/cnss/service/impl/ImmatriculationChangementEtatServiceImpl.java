
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.ImmatriculationChangementEtatService ; 
import com.zsmart.cnss.dao.ImmatriculationChangementEtatDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.ImmatriculationChangementEtat;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class ImmatriculationChangementEtatServiceImpl implements ImmatriculationChangementEtatService  {


 @Autowired 

 private ImmatriculationChangementEtatDao immatriculationchangementetatDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public ImmatriculationChangementEtat  save (ImmatriculationChangementEtat immatriculationchangementetat){

if(immatriculationchangementetat== null){ 
 return null; 
}else {
 immatriculationchangementetatDao.save(immatriculationchangementetat);
return immatriculationchangementetat;
}
}

 @Override 
public List< ImmatriculationChangementEtat>  findAll(){
 return immatriculationchangementetatDao.findAll();
}

 @Override 
public ImmatriculationChangementEtat findById(Long id){
 return immatriculationchangementetatDao.getOne(id);
}

 @Override 
public ImmatriculationChangementEtat  findByReference(String  reference){
 return immatriculationchangementetatDao.findByReference(reference);
}

 @Override 
public int delete(ImmatriculationChangementEtat immatriculationchangementetat){
if(immatriculationchangementetat== null){ 
  return -1; 
}else {
 immatriculationchangementetatDao.delete(immatriculationchangementetat);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       immatriculationchangementetatDao.deleteById(id);
}

 @Override 
public void  deleteByReference(String  reference){
  immatriculationchangementetatDao.deleteByReference(reference);
}
public void clone(ImmatriculationChangementEtat immatriculationchangementetat,ImmatriculationChangementEtat immatriculationchangementetatClone){
if(immatriculationchangementetat!= null && immatriculationchangementetatClone != null){
immatriculationchangementetatClone.setId(immatriculationchangementetat.getId());
immatriculationchangementetatClone.setLibelle(immatriculationchangementetat.getLibelle());
immatriculationchangementetatClone.setReference(immatriculationchangementetat.getReference());
}
}
public ImmatriculationChangementEtat clone(ImmatriculationChangementEtat immatriculationchangementetat){
if(immatriculationchangementetat== null){       return null ;
}else{ImmatriculationChangementEtat immatriculationchangementetatClone= new ImmatriculationChangementEtat();
 clone(immatriculationchangementetat,immatriculationchangementetatClone);
return immatriculationchangementetatClone;
}
}
public List<ImmatriculationChangementEtat> clone(List<ImmatriculationChangementEtat>immatriculationchangementetats){
if(immatriculationchangementetats== null){
       return null ;
}else{List<ImmatriculationChangementEtat> immatriculationchangementetatsClone = new ArrayList();
	 	 	 immatriculationchangementetats.forEach((immatriculationchangementetat)->{immatriculationchangementetatsClone.add(clone(immatriculationchangementetat));
});return immatriculationchangementetatsClone;
}
}
 @Override 
 public List< ImmatriculationChangementEtat>  findByCriteria(String libelle,String reference,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,reference,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,String reference,Long idMin,Long idMax){
String query = "SELECT i FROM ImmatriculationChangementEtat i where 1=1 ";
query += SearchUtil.addConstraint( "i", "libelle","=",libelle);
query += SearchUtil.addConstraint( "i", "reference","=",reference);
query += SearchUtil.addConstraintMinMax("i", "id", idMin, idMax);

  return query; 
}
}
