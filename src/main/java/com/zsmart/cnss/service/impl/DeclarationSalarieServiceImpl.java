
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.DeclarationSalarieService ; 
import com.zsmart.cnss.dao.DeclarationSalarieDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.DeclarationSalarie;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.TypeDeclarationSalarie; 
import com.zsmart.cnss.service.facade.TypeDeclarationSalarieService ; 
import com.zsmart.cnss.bean.Affilie; 
import com.zsmart.cnss.service.facade.AffilieService ; 
import com.zsmart.cnss.service.facade.DeclarationSalarieItemService ; 
import com.zsmart.cnss.bean.DeclarationSalarieItem ; 

 @Service  

 public class DeclarationSalarieServiceImpl implements DeclarationSalarieService  {


 @Autowired 

 private DeclarationSalarieDao declarationsalarieDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private DeclarationSalarieItemService declarationsalarieitemService; 

 @Autowired 

 private TypeDeclarationSalarieService typedeclarationsalarieService; 

 @Autowired 

 private AffilieService affilieService; 

 @Override 
public DeclarationSalarie  save (DeclarationSalarie declarationsalarie){

if(declarationsalarie== null){ 
 return null; 
}else {
 declarationsalarieDao.save(declarationsalarie);
return declarationsalarie;
}
}

 @Override 
public DeclarationSalarie  saveWithDeclarationSalarieItems (DeclarationSalarie declarationsalarie){

if(declarationsalarie== null){ 
        return null; 
}else {
   if(declarationsalarie.getDeclarationSalarieItems().isEmpty()){
            return null;
        }else{
declarationsalarieDao.save(declarationsalarie);
            for (DeclarationSalarieItem declarationsalarieitem : declarationsalarie.getDeclarationSalarieItems()) {
declarationsalarieitem.setDeclarationSalarie(declarationsalarie);
 declarationsalarieitemService.save(  declarationsalarieitem);          
            }
return declarationsalarie;
}
}
            }

 @Override 
public List< DeclarationSalarie>  findAll(){
 return declarationsalarieDao.findAll();
}

 @Override 
public DeclarationSalarie findById(Long id){
 return declarationsalarieDao.getOne(id);
}

 @Override 
public int delete(DeclarationSalarie declarationsalarie){
if(declarationsalarie== null){ 
  return -1; 
}else {
 declarationsalarieDao.delete(declarationsalarie);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       declarationsalarieDao.deleteById(id);
}
public void clone(DeclarationSalarie declarationsalarie,DeclarationSalarie declarationsalarieClone){
if(declarationsalarie!= null && declarationsalarieClone != null){
declarationsalarieClone.setId(declarationsalarie.getId());
declarationsalarieClone.setPeriode(declarationsalarie.getPeriode());
declarationsalarieClone.setAnnee(declarationsalarie.getAnnee());
declarationsalarieClone.setNombreJoursTravaille(declarationsalarie.getNombreJoursTravaille());
declarationsalarieClone.setDateDeclaration(declarationsalarie.getDateDeclaration());
declarationsalarieClone.setTypeDeclarationSalarie(typedeclarationsalarieService.clone(declarationsalarie.getTypeDeclarationSalarie()));
declarationsalarieClone.setAffilie(affilieService.clone(declarationsalarie.getAffilie()));
declarationsalarieClone.setDeclarationSalarieItems(declarationsalarieitemService.clone(declarationsalarie.getDeclarationSalarieItems()));
}
}
public DeclarationSalarie clone(DeclarationSalarie declarationsalarie){
if(declarationsalarie== null){       return null ;
}else{DeclarationSalarie declarationsalarieClone= new DeclarationSalarie();
 clone(declarationsalarie,declarationsalarieClone);
return declarationsalarieClone;
}
}
public List<DeclarationSalarie> clone(List<DeclarationSalarie>declarationsalaries){
if(declarationsalaries== null){
       return null ;
}else{List<DeclarationSalarie> declarationsalariesClone = new ArrayList();
	 	 	 declarationsalaries.forEach((declarationsalarie)->{declarationsalariesClone.add(clone(declarationsalarie));
});return declarationsalariesClone;
}
}
 @Override 
 public List< DeclarationSalarie>  findByCriteria(Long idMin,Long idMax,int periodeMin,int periodeMax,int anneeMin,int anneeMax,int nombreJoursTravailleMin,int nombreJoursTravailleMax,Date dateDeclarationMin,Date dateDeclarationMax){
 return entityManager.createQuery(constructQuery(idMin,idMax,periodeMin,periodeMax,anneeMin,anneeMax,nombreJoursTravailleMin,nombreJoursTravailleMax,dateDeclarationMin,dateDeclarationMax)).getResultList(); 
 }
private String constructQuery(Long idMin,Long idMax,int periodeMin,int periodeMax,int anneeMin,int anneeMax,int nombreJoursTravailleMin,int nombreJoursTravailleMax,Date dateDeclarationMin,Date dateDeclarationMax){
String query = "SELECT d FROM DeclarationSalarie d where 1=1 ";
query += SearchUtil.addConstraintMinMax("d", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("d", "periode", periodeMin, periodeMax);
query += SearchUtil.addConstraintMinMax("d", "annee", anneeMin, anneeMax);
query += SearchUtil.addConstraintMinMax("d", "nombreJoursTravaille", nombreJoursTravailleMin, nombreJoursTravailleMax);
query += SearchUtil.addConstraintMinMaxDate("d"," dateDeclaration", dateDeclarationMin, dateDeclarationMax);

  return query; 
}
}
