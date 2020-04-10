
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.TypeSalarieService ; 
import com.zsmart.cnss.dao.TypeSalarieDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.TypeSalarie;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class TypeSalarieServiceImpl implements TypeSalarieService  {


 @Autowired 

 private TypeSalarieDao typesalarieDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public TypeSalarie  save (TypeSalarie typesalarie){

if(typesalarie== null){ 
 return null; 
}else {
 typesalarieDao.save(typesalarie);
return typesalarie;
}
}

 @Override 
public List< TypeSalarie>  findAll(){
 return typesalarieDao.findAll();
}

 @Override 
public TypeSalarie findById(Long id){
 return typesalarieDao.getOne(id);
}

 @Override 
public int delete(TypeSalarie typesalarie){
if(typesalarie== null){ 
  return -1; 
}else {
 typesalarieDao.delete(typesalarie);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       typesalarieDao.deleteById(id);
}
public void clone(TypeSalarie typesalarie,TypeSalarie typesalarieClone){
if(typesalarie!= null && typesalarieClone != null){
typesalarieClone.setId(typesalarie.getId());
typesalarieClone.setLibelle(typesalarie.getLibelle());
}
}
public TypeSalarie clone(TypeSalarie typesalarie){
if(typesalarie== null){       return null ;
}else{TypeSalarie typesalarieClone= new TypeSalarie();
 clone(typesalarie,typesalarieClone);
return typesalarieClone;
}
}
public List<TypeSalarie> clone(List<TypeSalarie>typesalaries){
if(typesalaries== null){
       return null ;
}else{List<TypeSalarie> typesalariesClone = new ArrayList();
	 	 	 typesalaries.forEach((typesalarie)->{typesalariesClone.add(clone(typesalarie));
});return typesalariesClone;
}
}
 @Override 
 public List< TypeSalarie>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT t FROM TypeSalarie t where 1=1 ";
query += SearchUtil.addConstraint( "t", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("t", "id", idMin, idMax);

  return query; 
}
}
