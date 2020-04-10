
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.SalarieService ; 
import com.zsmart.cnss.dao.SalarieDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.Salarie;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.TypeSalarie; 
import com.zsmart.cnss.service.facade.TypeSalarieService ; 
import com.zsmart.cnss.bean.Affilie; 
import com.zsmart.cnss.service.facade.AffilieService ; 
import com.zsmart.cnss.bean.ImmatriculationDemande; 
import com.zsmart.cnss.service.facade.ImmatriculationDemandeService ; 
import com.zsmart.cnss.service.facade.ImmatriculationChangementService ; 
import com.zsmart.cnss.bean.ImmatriculationChangement ; 

 @Service  

 public class SalarieServiceImpl implements SalarieService  {


 @Autowired 

 private SalarieDao salarieDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private ImmatriculationChangementService immatriculationchangementService; 

 @Autowired 

 private TypeSalarieService typesalarieService; 

 @Autowired 

 private AffilieService affilieService; 

 @Autowired 

 private ImmatriculationDemandeService immatriculationdemandeService; 

 @Override 
public Salarie  save (Salarie salarie){

if(salarie== null){ 
 return null; 
}else {
 salarieDao.save(salarie);
return salarie;
}
}

 @Override 
public Salarie  saveWithImmatriculationChangements (Salarie salarie){

if(salarie== null){ 
        return null; 
}else {
   if(salarie.getImmatriculationChangements().isEmpty()){
            return null;
        }else{
salarieDao.save(salarie);
            for (ImmatriculationChangement immatriculationchangement : salarie.getImmatriculationChangements()) {
immatriculationchangement.setSalarie(salarie);
 immatriculationchangementService.save(  immatriculationchangement);          
            }
return salarie;
}
}
            }

 @Override 
public List< Salarie>  findAll(){
 return salarieDao.findAll();
}

 @Override 
public Salarie findById(Long id){
 return salarieDao.getOne(id);
}

 @Override 
public int delete(Salarie salarie){
if(salarie== null){ 
  return -1; 
}else {
 salarieDao.delete(salarie);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       salarieDao.deleteById(id);
}
public void clone(Salarie salarie,Salarie salarieClone){
if(salarie!= null && salarieClone != null){
salarieClone.setId(salarie.getId());
salarieClone.setNom(salarie.getNom());
salarieClone.setPrenom(salarie.getPrenom());
salarieClone.setDateNaissance(salarie.getDateNaissance());
salarieClone.setSexe(salarie.getSexe());
salarieClone.setNationalite(salarie.getNationalite());
salarieClone.setCin(salarie.getCin());
salarieClone.setAdresse(salarie.getAdresse());
salarieClone.setCodePostal(salarie.getCodePostal());
salarieClone.setVille(salarie.getVille());
salarieClone.setEmail(salarie.getEmail());
salarieClone.setTelNum(salarie.getTelNum());
salarieClone.setNumImmatriculation(salarie.getNumImmatriculation());
salarieClone.setTypeSalarie(typesalarieService.clone(salarie.getTypeSalarie()));
salarieClone.setDernierAffilie(affilieService.clone(salarie.getDernierAffilie()));
salarieClone.setImmatriculationDemande(immatriculationdemandeService.clone(salarie.getImmatriculationDemande()));
salarieClone.setImmatriculationChangements(immatriculationchangementService.clone(salarie.getImmatriculationChangements()));
}
}
public Salarie clone(Salarie salarie){
if(salarie== null){       return null ;
}else{Salarie salarieClone= new Salarie();
 clone(salarie,salarieClone);
return salarieClone;
}
}
public List<Salarie> clone(List<Salarie>salaries){
if(salaries== null){
       return null ;
}else{List<Salarie> salariesClone = new ArrayList();
	 	 	 salaries.forEach((salarie)->{salariesClone.add(clone(salarie));
});return salariesClone;
}
}
 @Override 
 public List< Salarie>  findByCriteria(String nom,String prenom,String sexe,String nationalite,String cin,String adresse,String codePostal,String ville,String email,String telNum,String numImmatriculation,Long idMin,Long idMax,Date dateNaissanceMin,Date dateNaissanceMax){
 return entityManager.createQuery(constructQuery(nom,prenom,sexe,nationalite,cin,adresse,codePostal,ville,email,telNum,numImmatriculation,idMin,idMax,dateNaissanceMin,dateNaissanceMax)).getResultList(); 
 }
private String constructQuery(String nom,String prenom,String sexe,String nationalite,String cin,String adresse,String codePostal,String ville,String email,String telNum,String numImmatriculation,Long idMin,Long idMax,Date dateNaissanceMin,Date dateNaissanceMax){
String query = "SELECT s FROM Salarie s where 1=1 ";
query += SearchUtil.addConstraint( "s", "nom","=",nom);
query += SearchUtil.addConstraint( "s", "prenom","=",prenom);
query += SearchUtil.addConstraint( "s", "sexe","=",sexe);
query += SearchUtil.addConstraint( "s", "nationalite","=",nationalite);
query += SearchUtil.addConstraint( "s", "cin","=",cin);
query += SearchUtil.addConstraint( "s", "adresse","=",adresse);
query += SearchUtil.addConstraint( "s", "codePostal","=",codePostal);
query += SearchUtil.addConstraint( "s", "ville","=",ville);
query += SearchUtil.addConstraint( "s", "email","=",email);
query += SearchUtil.addConstraint( "s", "telNum","=",telNum);
query += SearchUtil.addConstraint( "s", "numImmatriculation","=",numImmatriculation);
query += SearchUtil.addConstraintMinMax("s", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMaxDate("s"," dateNaissance", dateNaissanceMin, dateNaissanceMax);

  return query; 
}
}
