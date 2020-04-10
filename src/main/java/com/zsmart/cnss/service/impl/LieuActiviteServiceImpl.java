
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.LieuActiviteService ; 
import com.zsmart.cnss.dao.LieuActiviteDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.LieuActivite;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.Ville; 
import com.zsmart.cnss.service.facade.VilleService ; 
import com.zsmart.cnss.bean.AffiliationDemande; 
import com.zsmart.cnss.service.facade.AffiliationDemandeService ; 

 @Service  

 public class LieuActiviteServiceImpl implements LieuActiviteService  {


 @Autowired 

 private LieuActiviteDao lieuactiviteDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private VilleService villeService; 

 @Autowired 

 private AffiliationDemandeService affiliationdemandeService; 

 @Override 
public LieuActivite  save (LieuActivite lieuactivite){

if(lieuactivite== null){ 
 return null; 
}else {
 lieuactiviteDao.save(lieuactivite);
return lieuactivite;
}
}

 @Override 
public List< LieuActivite>  findAll(){
 return lieuactiviteDao.findAll();
}

 @Override 
public LieuActivite findById(Long id){
 return lieuactiviteDao.getOne(id);
}

 @Override 
public int delete(LieuActivite lieuactivite){
if(lieuactivite== null){ 
  return -1; 
}else {
 lieuactiviteDao.delete(lieuactivite);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       lieuactiviteDao.deleteById(id);
}
public void clone(LieuActivite lieuactivite,LieuActivite lieuactiviteClone){
if(lieuactivite!= null && lieuactiviteClone != null){
lieuactiviteClone.setId(lieuactivite.getId());
lieuactiviteClone.setAdresse(lieuactivite.getAdresse());
lieuactiviteClone.setCommune(lieuactivite.getCommune());
lieuactiviteClone.setCodePostal(lieuactivite.getCodePostal());
lieuactiviteClone.setVille(villeService.clone(lieuactivite.getVille()));
lieuactiviteClone.setAffliationDemande(affiliationdemandeService.clone(lieuactivite.getAffliationDemande()));
}
}
public LieuActivite clone(LieuActivite lieuactivite){
if(lieuactivite== null){       return null ;
}else{LieuActivite lieuactiviteClone= new LieuActivite();
 clone(lieuactivite,lieuactiviteClone);
return lieuactiviteClone;
}
}
public List<LieuActivite> clone(List<LieuActivite>lieuactivites){
if(lieuactivites== null){
       return null ;
}else{List<LieuActivite> lieuactivitesClone = new ArrayList();
	 	 	 lieuactivites.forEach((lieuactivite)->{lieuactivitesClone.add(clone(lieuactivite));
});return lieuactivitesClone;
}
}
 @Override 
 public List< LieuActivite>  findByCriteria(String adresse,String commune,String codePostal,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(adresse,commune,codePostal,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String adresse,String commune,String codePostal,Long idMin,Long idMax){
String query = "SELECT l FROM LieuActivite l where 1=1 ";
query += SearchUtil.addConstraint( "l", "adresse","=",adresse);
query += SearchUtil.addConstraint( "l", "commune","=",commune);
query += SearchUtil.addConstraint( "l", "codePostal","=",codePostal);
query += SearchUtil.addConstraintMinMax("l", "id", idMin, idMax);

  return query; 
}
}
