
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.ImmatriculationDemandeService ; 
import com.zsmart.cnss.dao.ImmatriculationDemandeDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.ImmatriculationDemande;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.Affilie; 
import com.zsmart.cnss.service.facade.AffilieService ; 
import com.zsmart.cnss.bean.ImmatriculationDemandeEtat; 
import com.zsmart.cnss.service.facade.ImmatriculationDemandeEtatService ; 
import com.zsmart.cnss.service.facade.SalarieImmatriculationService ; 
import com.zsmart.cnss.bean.SalarieImmatriculation ; 

 @Service  

 public class ImmatriculationDemandeServiceImpl implements ImmatriculationDemandeService  {


 @Autowired 

 private ImmatriculationDemandeDao immatriculationdemandeDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private SalarieImmatriculationService salarieimmatriculationService; 

 @Autowired 

 private AffilieService affilieService; 

 @Autowired 

 private ImmatriculationDemandeEtatService immatriculationdemandeetatService; 

 @Override 
public ImmatriculationDemande  save (ImmatriculationDemande immatriculationdemande){

if(immatriculationdemande== null){ 
 return null; 
}else {
 immatriculationdemandeDao.save(immatriculationdemande);
return immatriculationdemande;
}
}

 @Override 
public ImmatriculationDemande  saveWithSalarieImmatriculations (ImmatriculationDemande immatriculationdemande){

if(immatriculationdemande== null){ 
        return null; 
}else {
   if(immatriculationdemande.getSalarieImmatriculations().isEmpty()){
            return null;
        }else{
immatriculationdemandeDao.save(immatriculationdemande);
            for (SalarieImmatriculation salarieimmatriculation : immatriculationdemande.getSalarieImmatriculations()) {
salarieimmatriculation.setImmatriculationDemande(immatriculationdemande);
 salarieimmatriculationService.save(  salarieimmatriculation);          
            }
return immatriculationdemande;
}
}
            }

 @Override 
public List< ImmatriculationDemande>  findAll(){
 return immatriculationdemandeDao.findAll();
}

 @Override 
public ImmatriculationDemande findById(Long id){
 return immatriculationdemandeDao.getOne(id);
}

 @Override 
public int delete(ImmatriculationDemande immatriculationdemande){
if(immatriculationdemande== null){ 
  return -1; 
}else {
 immatriculationdemandeDao.delete(immatriculationdemande);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       immatriculationdemandeDao.deleteById(id);
}
public void clone(ImmatriculationDemande immatriculationdemande,ImmatriculationDemande immatriculationdemandeClone){
if(immatriculationdemande!= null && immatriculationdemandeClone != null){
immatriculationdemandeClone.setId(immatriculationdemande.getId());
immatriculationdemandeClone.setNumImmatriculation(immatriculationdemande.getNumImmatriculation());
immatriculationdemandeClone.setDateDemandeImmatriculation(immatriculationdemande.getDateDemandeImmatriculation());
immatriculationdemandeClone.setAffilie(affilieService.clone(immatriculationdemande.getAffilie()));
immatriculationdemandeClone.setImmatriculationDemandeEtat(immatriculationdemandeetatService.clone(immatriculationdemande.getImmatriculationDemandeEtat()));
immatriculationdemandeClone.setSalarieImmatriculations(salarieimmatriculationService.clone(immatriculationdemande.getSalarieImmatriculations()));
}
}
public ImmatriculationDemande clone(ImmatriculationDemande immatriculationdemande){
if(immatriculationdemande== null){       return null ;
}else{ImmatriculationDemande immatriculationdemandeClone= new ImmatriculationDemande();
 clone(immatriculationdemande,immatriculationdemandeClone);
return immatriculationdemandeClone;
}
}
public List<ImmatriculationDemande> clone(List<ImmatriculationDemande>immatriculationdemandes){
if(immatriculationdemandes== null){
       return null ;
}else{List<ImmatriculationDemande> immatriculationdemandesClone = new ArrayList();
	 	 	 immatriculationdemandes.forEach((immatriculationdemande)->{immatriculationdemandesClone.add(clone(immatriculationdemande));
});return immatriculationdemandesClone;
}
}
 @Override 
 public List< ImmatriculationDemande>  findByCriteria(String numImmatriculation,Long idMin,Long idMax,Date dateDemandeImmatriculationMin,Date dateDemandeImmatriculationMax){
 return entityManager.createQuery(constructQuery(numImmatriculation,idMin,idMax,dateDemandeImmatriculationMin,dateDemandeImmatriculationMax)).getResultList(); 
 }
private String constructQuery(String numImmatriculation,Long idMin,Long idMax,Date dateDemandeImmatriculationMin,Date dateDemandeImmatriculationMax){
String query = "SELECT i FROM ImmatriculationDemande i where 1=1 ";
query += SearchUtil.addConstraint( "i", "numImmatriculation","=",numImmatriculation);
query += SearchUtil.addConstraintMinMax("i", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMaxDate("i"," dateDemandeImmatriculation", dateDemandeImmatriculationMin, dateDemandeImmatriculationMax);

  return query; 
}
}
