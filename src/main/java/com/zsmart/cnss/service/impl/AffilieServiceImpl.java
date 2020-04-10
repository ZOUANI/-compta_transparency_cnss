
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.AffilieService ; 
import com.zsmart.cnss.dao.AffilieDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.Affilie;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.FormeJuridque; 
import com.zsmart.cnss.service.facade.FormeJuridqueService ; 
import com.zsmart.cnss.bean.Ville; 
import com.zsmart.cnss.service.facade.VilleService ; 
import com.zsmart.cnss.service.facade.DeclarationSalarieService ; 
import com.zsmart.cnss.bean.DeclarationSalarie ; 

 @Service  

 public class AffilieServiceImpl implements AffilieService  {


 @Autowired 

 private AffilieDao affilieDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private DeclarationSalarieService declarationsalarieService; 

 @Autowired 

 private FormeJuridqueService formejuridqueService; 

 @Autowired 

 private VilleService villeService; 

 @Override 
public Affilie  save (Affilie affilie){

if(affilie== null){ 
 return null; 
}else {
 affilieDao.save(affilie);
return affilie;
}
}

 @Override 
public Affilie  saveWithDeclarationSalaries (Affilie affilie){

if(affilie== null){ 
        return null; 
}else {
   if(affilie.getDeclarationSalaries().isEmpty()){
            return null;
        }else{
affilieDao.save(affilie);
            for (DeclarationSalarie declarationsalarie : affilie.getDeclarationSalaries()) {
declarationsalarie.setAffilie(affilie);
 declarationsalarieService.save(  declarationsalarie);          
            }
return affilie;
}
}
            }

 @Override 
public List< Affilie>  findAll(){
 return affilieDao.findAll();
}

 @Override 
public Affilie findById(Long id){
 return affilieDao.getOne(id);
}

 @Override 
public int delete(Affilie affilie){
if(affilie== null){ 
  return -1; 
}else {
 affilieDao.delete(affilie);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       affilieDao.deleteById(id);
}
public void clone(Affilie affilie,Affilie affilieClone){
if(affilie!= null && affilieClone != null){
affilieClone.setId(affilie.getId());
affilieClone.setRaisonSocial(affilie.getRaisonSocial());
affilieClone.setNumTaxePro(affilie.getNumTaxePro());
affilieClone.setNumRegistreComerciale(affilie.getNumRegistreComerciale());
affilieClone.setIdFiscal(affilie.getIdFiscal());
affilieClone.setIceSociete(affilie.getIceSociete());
affilieClone.setNumAffiliationSocieteMere(affilie.getNumAffiliationSocieteMere());
affilieClone.setNumSalariesEmployes(affilie.getNumSalariesEmployes());
affilieClone.setDatePremierSalarie(affilie.getDatePremierSalarie());
affilieClone.setAdresseSiegeSocial(affilie.getAdresseSiegeSocial());
affilieClone.setTypeSiegeSocial(affilie.getTypeSiegeSocial());
affilieClone.setCommune(affilie.getCommune());
affilieClone.setQuartie(affilie.getQuartie());
affilieClone.setCodePostal(affilie.getCodePostal());
affilieClone.setNumTel(affilie.getNumTel());
affilieClone.setEmail(affilie.getEmail());
affilieClone.setTotalSalaire(affilie.getTotalSalaire());
affilieClone.setFormeJuridique(formejuridqueService.clone(affilie.getFormeJuridique()));
affilieClone.setVille(villeService.clone(affilie.getVille()));
affilieClone.setDeclarationSalaries(declarationsalarieService.clone(affilie.getDeclarationSalaries()));
}
}
public Affilie clone(Affilie affilie){
if(affilie== null){       return null ;
}else{Affilie affilieClone= new Affilie();
 clone(affilie,affilieClone);
return affilieClone;
}
}
public List<Affilie> clone(List<Affilie>affilies){
if(affilies== null){
       return null ;
}else{List<Affilie> affiliesClone = new ArrayList();
	 	 	 affilies.forEach((affilie)->{affiliesClone.add(clone(affilie));
});return affiliesClone;
}
}
 @Override 
 public List< Affilie>  findByCriteria(String raisonSocial,String numTaxePro,String numRegistreComerciale,String idFiscal,String iceSociete,String numAffiliationSocieteMere,String numSalariesEmployes,String datePremierSalarie,String adresseSiegeSocial,String typeSiegeSocial,String commune,String quartie,String codePostal,String numTel,String email,Long idMin,Long idMax,BigDecimal totalSalaireMin,BigDecimal totalSalaireMax){
 return entityManager.createQuery(constructQuery(raisonSocial,numTaxePro,numRegistreComerciale,idFiscal,iceSociete,numAffiliationSocieteMere,numSalariesEmployes,datePremierSalarie,adresseSiegeSocial,typeSiegeSocial,commune,quartie,codePostal,numTel,email,idMin,idMax,totalSalaireMin,totalSalaireMax)).getResultList(); 
 }
private String constructQuery(String raisonSocial,String numTaxePro,String numRegistreComerciale,String idFiscal,String iceSociete,String numAffiliationSocieteMere,String numSalariesEmployes,String datePremierSalarie,String adresseSiegeSocial,String typeSiegeSocial,String commune,String quartie,String codePostal,String numTel,String email,Long idMin,Long idMax,BigDecimal totalSalaireMin,BigDecimal totalSalaireMax){
String query = "SELECT a FROM Affilie a where 1=1 ";
query += SearchUtil.addConstraint( "a", "raisonSocial","=",raisonSocial);
query += SearchUtil.addConstraint( "a", "numTaxePro","=",numTaxePro);
query += SearchUtil.addConstraint( "a", "numRegistreComerciale","=",numRegistreComerciale);
query += SearchUtil.addConstraint( "a", "idFiscal","=",idFiscal);
query += SearchUtil.addConstraint( "a", "iceSociete","=",iceSociete);
query += SearchUtil.addConstraint( "a", "numAffiliationSocieteMere","=",numAffiliationSocieteMere);
query += SearchUtil.addConstraint( "a", "numSalariesEmployes","=",numSalariesEmployes);
query += SearchUtil.addConstraint( "a", "datePremierSalarie","=",datePremierSalarie);
query += SearchUtil.addConstraint( "a", "adresseSiegeSocial","=",adresseSiegeSocial);
query += SearchUtil.addConstraint( "a", "typeSiegeSocial","=",typeSiegeSocial);
query += SearchUtil.addConstraint( "a", "commune","=",commune);
query += SearchUtil.addConstraint( "a", "quartie","=",quartie);
query += SearchUtil.addConstraint( "a", "codePostal","=",codePostal);
query += SearchUtil.addConstraint( "a", "numTel","=",numTel);
query += SearchUtil.addConstraint( "a", "email","=",email);
query += SearchUtil.addConstraintMinMax("a", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("a", "totalSalaire", totalSalaireMin, totalSalaireMax);

  return query; 
}
}
