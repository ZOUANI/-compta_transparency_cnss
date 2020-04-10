
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.TypeDemandeService ; 
import com.zsmart.cnss.dao.TypeDemandeDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.TypeDemande;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class TypeDemandeServiceImpl implements TypeDemandeService  {


 @Autowired 

 private TypeDemandeDao typedemandeDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public TypeDemande  save (TypeDemande typedemande){

if(typedemande== null){ 
 return null; 
}else {
 typedemandeDao.save(typedemande);
return typedemande;
}
}

 @Override 
public List< TypeDemande>  findAll(){
 return typedemandeDao.findAll();
}

 @Override 
public TypeDemande findById(Long id){
 return typedemandeDao.getOne(id);
}

 @Override 
public int delete(TypeDemande typedemande){
if(typedemande== null){ 
  return -1; 
}else {
 typedemandeDao.delete(typedemande);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       typedemandeDao.deleteById(id);
}
public void clone(TypeDemande typedemande,TypeDemande typedemandeClone){
if(typedemande!= null && typedemandeClone != null){
typedemandeClone.setId(typedemande.getId());
typedemandeClone.setLibelle(typedemande.getLibelle());
}
}
public TypeDemande clone(TypeDemande typedemande){
if(typedemande== null){       return null ;
}else{TypeDemande typedemandeClone= new TypeDemande();
 clone(typedemande,typedemandeClone);
return typedemandeClone;
}
}
public List<TypeDemande> clone(List<TypeDemande>typedemandes){
if(typedemandes== null){
       return null ;
}else{List<TypeDemande> typedemandesClone = new ArrayList();
	 	 	 typedemandes.forEach((typedemande)->{typedemandesClone.add(clone(typedemande));
});return typedemandesClone;
}
}
 @Override 
 public List< TypeDemande>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT t FROM TypeDemande t where 1=1 ";
query += SearchUtil.addConstraint( "t", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("t", "id", idMin, idMax);

  return query; 
}
}
