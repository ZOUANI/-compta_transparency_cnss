package com.zsmart.cnss.ws.rest.provided ;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.zsmart.cnss.service.facade.AffiliationDemandeService;
import com.zsmart.cnss.bean.AffiliationDemande;
import com.zsmart.cnss.ws.rest.vo.AffiliationDemandeVo;
import com.zsmart.cnss.ws.rest.converter.AffiliationDemandeConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/AffiliationDemande")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AffiliationDemandeRest {

 @Autowired 
 private AffiliationDemandeService affiliationDemandeService;

 @Autowired 
private AffiliationDemandeConverter affiliationDemandeConverter ;

@PostMapping("/")
public AffiliationDemandeVo save(@RequestBody AffiliationDemandeVo affiliationDemandeVo){
AffiliationDemande affiliationDemande= affiliationDemandeConverter.toItem(affiliationDemandeVo);
return affiliationDemandeConverter.toVo(affiliationDemandeService.save(affiliationDemande));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
affiliationDemandeService.deleteById(id);
}
@DeleteMapping("/{reference}")
public void  deleteByReference(@PathVariable String  reference){
affiliationDemandeService.deleteByReference(reference);
}
@GetMapping("/")
public List<AffiliationDemandeVo> findAll(){
return affiliationDemandeConverter.toVo(affiliationDemandeService.findAll());
}

 public AffiliationDemandeConverter getAffiliationDemandeConverter(){
return affiliationDemandeConverter;
}
 
 public void setAffiliationDemandeConverter(AffiliationDemandeConverter affiliationDemandeConverter){
this.affiliationDemandeConverter=affiliationDemandeConverter;
}

 public AffiliationDemandeService getAffiliationDemandeService(){
return affiliationDemandeService;
}
 
 public void setAffiliationDemandeService(AffiliationDemandeService affiliationDemandeService){
this.affiliationDemandeService=affiliationDemandeService;
}

}