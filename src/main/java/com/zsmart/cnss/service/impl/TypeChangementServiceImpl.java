
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.TypeChangementService ; 
import com.zsmart.cnss.dao.TypeChangementDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.TypeChangement;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class TypeChangementServiceImpl implements TypeChangementService  {


 @Autowired 

 private TypeChangementDao typechangementDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public TypeChangement  save (TypeChangement typechangement){

if(typechangement== null){ 
 return null; 
}else {
 typechangementDao.save(typechangement);
return typechangement;
}
}

 @Override 
public List< TypeChangement>  findAll(){
 return typechangementDao.findAll();
}

 @Override 
public TypeChangement findById(Long id){
 return typechangementDao.getOne(id);
}

 @Override 
public int delete(TypeChangement typechangement){
if(typechangement== null){ 
  return -1; 
}else {
 typechangementDao.delete(typechangement);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       typechangementDao.deleteById(id);
}
public void clone(TypeChangement typechangement,TypeChangement typechangementClone){
if(typechangement!= null && typechangementClone != null){
typechangementClone.setId(typechangement.getId());
typechangementClone.setLibelle(typechangement.getLibelle());
}
}
public TypeChangement clone(TypeChangement typechangement){
if(typechangement== null){       return null ;
}else{TypeChangement typechangementClone= new TypeChangement();
 clone(typechangement,typechangementClone);
return typechangementClone;
}
}
public List<TypeChangement> clone(List<TypeChangement>typechangements){
if(typechangements== null){
       return null ;
}else{List<TypeChangement> typechangementsClone = new ArrayList();
	 	 	 typechangements.forEach((typechangement)->{typechangementsClone.add(clone(typechangement));
});return typechangementsClone;
}
}
 @Override 
 public List< TypeChangement>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT t FROM TypeChangement t where 1=1 ";
query += SearchUtil.addConstraint( "t", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("t", "id", idMin, idMax);

  return query; 
}
}
