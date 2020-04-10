
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.TypeDeclarationSalarieService ; 
import com.zsmart.cnss.dao.TypeDeclarationSalarieDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.TypeDeclarationSalarie;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class TypeDeclarationSalarieServiceImpl implements TypeDeclarationSalarieService  {


 @Autowired 

 private TypeDeclarationSalarieDao typedeclarationsalarieDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public TypeDeclarationSalarie  save (TypeDeclarationSalarie typedeclarationsalarie){

if(typedeclarationsalarie== null){ 
 return null; 
}else {
 typedeclarationsalarieDao.save(typedeclarationsalarie);
return typedeclarationsalarie;
}
}

 @Override 
public List< TypeDeclarationSalarie>  findAll(){
 return typedeclarationsalarieDao.findAll();
}

 @Override 
public TypeDeclarationSalarie findById(Long id){
 return typedeclarationsalarieDao.getOne(id);
}

 @Override 
public int delete(TypeDeclarationSalarie typedeclarationsalarie){
if(typedeclarationsalarie== null){ 
  return -1; 
}else {
 typedeclarationsalarieDao.delete(typedeclarationsalarie);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       typedeclarationsalarieDao.deleteById(id);
}
public void clone(TypeDeclarationSalarie typedeclarationsalarie,TypeDeclarationSalarie typedeclarationsalarieClone){
if(typedeclarationsalarie!= null && typedeclarationsalarieClone != null){
typedeclarationsalarieClone.setId(typedeclarationsalarie.getId());
typedeclarationsalarieClone.setLibelle(typedeclarationsalarie.getLibelle());
}
}
public TypeDeclarationSalarie clone(TypeDeclarationSalarie typedeclarationsalarie){
if(typedeclarationsalarie== null){       return null ;
}else{TypeDeclarationSalarie typedeclarationsalarieClone= new TypeDeclarationSalarie();
 clone(typedeclarationsalarie,typedeclarationsalarieClone);
return typedeclarationsalarieClone;
}
}
public List<TypeDeclarationSalarie> clone(List<TypeDeclarationSalarie>typedeclarationsalaries){
if(typedeclarationsalaries== null){
       return null ;
}else{List<TypeDeclarationSalarie> typedeclarationsalariesClone = new ArrayList();
	 	 	 typedeclarationsalaries.forEach((typedeclarationsalarie)->{typedeclarationsalariesClone.add(clone(typedeclarationsalarie));
});return typedeclarationsalariesClone;
}
}
 @Override 
 public List< TypeDeclarationSalarie>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT t FROM TypeDeclarationSalarie t where 1=1 ";
query += SearchUtil.addConstraint( "t", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("t", "id", idMin, idMax);

  return query; 
}
}
