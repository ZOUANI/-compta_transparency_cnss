
package com.zsmart.cnss.service.impl ;
import com.zsmart.cnss.service.facade.DeclarationSalarieItemService ; 
import com.zsmart.cnss.dao.DeclarationSalarieItemDao ;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.DeclarationSalarieItem;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.cnss.bean.Salarie; 
import com.zsmart.cnss.service.facade.SalarieService ; 
import com.zsmart.cnss.bean.DeclarationSalarie; 
import com.zsmart.cnss.service.facade.DeclarationSalarieService ; 

 @Service  

 public class DeclarationSalarieItemServiceImpl implements DeclarationSalarieItemService  {


 @Autowired 

 private DeclarationSalarieItemDao declarationsalarieitemDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private SalarieService salarieService; 

 @Autowired 

 private DeclarationSalarieService declarationsalarieService; 

 @Override 
public DeclarationSalarieItem  save (DeclarationSalarieItem declarationsalarieitem){

if(declarationsalarieitem== null){ 
 return null; 
}else {
 declarationsalarieitemDao.save(declarationsalarieitem);
return declarationsalarieitem;
}
}

 @Override 
public List< DeclarationSalarieItem>  findAll(){
 return declarationsalarieitemDao.findAll();
}

 @Override 
public DeclarationSalarieItem findById(Long id){
 return declarationsalarieitemDao.getOne(id);
}

 @Override 
public int delete(DeclarationSalarieItem declarationsalarieitem){
if(declarationsalarieitem== null){ 
  return -1; 
}else {
 declarationsalarieitemDao.delete(declarationsalarieitem);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       declarationsalarieitemDao.deleteById(id);
}
public void clone(DeclarationSalarieItem declarationsalarieitem,DeclarationSalarieItem declarationsalarieitemClone){
if(declarationsalarieitem!= null && declarationsalarieitemClone != null){
declarationsalarieitemClone.setId(declarationsalarieitem.getId());
declarationsalarieitemClone.setSalaireBrut(declarationsalarieitem.getSalaireBrut());
declarationsalarieitemClone.setDateDeclarationSalarie(declarationsalarieitem.getDateDeclarationSalarie());
declarationsalarieitemClone.setSalarie(salarieService.clone(declarationsalarieitem.getSalarie()));
declarationsalarieitemClone.setDeclarationSalarie(declarationsalarieService.clone(declarationsalarieitem.getDeclarationSalarie()));
}
}
public DeclarationSalarieItem clone(DeclarationSalarieItem declarationsalarieitem){
if(declarationsalarieitem== null){       return null ;
}else{DeclarationSalarieItem declarationsalarieitemClone= new DeclarationSalarieItem();
 clone(declarationsalarieitem,declarationsalarieitemClone);
return declarationsalarieitemClone;
}
}
public List<DeclarationSalarieItem> clone(List<DeclarationSalarieItem>declarationsalarieitems){
if(declarationsalarieitems== null){
       return null ;
}else{List<DeclarationSalarieItem> declarationsalarieitemsClone = new ArrayList();
	 	 	 declarationsalarieitems.forEach((declarationsalarieitem)->{declarationsalarieitemsClone.add(clone(declarationsalarieitem));
});return declarationsalarieitemsClone;
}
}
 @Override 
 public List< DeclarationSalarieItem>  findByCriteria(Long idMin,Long idMax,BigDecimal salaireBrutMin,BigDecimal salaireBrutMax,Date dateDeclarationSalarieMin,Date dateDeclarationSalarieMax){
 return entityManager.createQuery(constructQuery(idMin,idMax,salaireBrutMin,salaireBrutMax,dateDeclarationSalarieMin,dateDeclarationSalarieMax)).getResultList(); 
 }
private String constructQuery(Long idMin,Long idMax,BigDecimal salaireBrutMin,BigDecimal salaireBrutMax,Date dateDeclarationSalarieMin,Date dateDeclarationSalarieMax){
String query = "SELECT d FROM DeclarationSalarieItem d where 1=1 ";
query += SearchUtil.addConstraintMinMax("d", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("d", "salaireBrut", salaireBrutMin, salaireBrutMax);
query += SearchUtil.addConstraintMinMaxDate("d"," dateDeclarationSalarie", dateDeclarationSalarieMin, dateDeclarationSalarieMax);

  return query; 
}
}
