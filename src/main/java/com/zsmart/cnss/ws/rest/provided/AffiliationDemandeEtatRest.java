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
import com.zsmart.cnss.service.facade.AffiliationDemandeEtatService;
import com.zsmart.cnss.bean.AffiliationDemandeEtat;
import com.zsmart.cnss.ws.rest.vo.AffiliationDemandeEtatVo;
import com.zsmart.cnss.ws.rest.converter.AffiliationDemandeEtatConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/AffiliationDemandeEtat")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AffiliationDemandeEtatRest {

 @Autowired 
 private AffiliationDemandeEtatService affiliationDemandeEtatService;

 @Autowired 
private AffiliationDemandeEtatConverter affiliationDemandeEtatConverter ;

@PostMapping("/")
public AffiliationDemandeEtatVo save(@RequestBody AffiliationDemandeEtatVo affiliationDemandeEtatVo){
AffiliationDemandeEtat affiliationDemandeEtat= affiliationDemandeEtatConverter.toItem(affiliationDemandeEtatVo);
return affiliationDemandeEtatConverter.toVo(affiliationDemandeEtatService.save(affiliationDemandeEtat));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
affiliationDemandeEtatService.deleteById(id);
}
@DeleteMapping("/{reference}")
public void  deleteByReference(@PathVariable String  reference){
affiliationDemandeEtatService.deleteByReference(reference);
}
@GetMapping("/")
public List<AffiliationDemandeEtatVo> findAll(){
return affiliationDemandeEtatConverter.toVo(affiliationDemandeEtatService.findAll());
}

 public AffiliationDemandeEtatConverter getAffiliationDemandeEtatConverter(){
return affiliationDemandeEtatConverter;
}
 
 public void setAffiliationDemandeEtatConverter(AffiliationDemandeEtatConverter affiliationDemandeEtatConverter){
this.affiliationDemandeEtatConverter=affiliationDemandeEtatConverter;
}

 public AffiliationDemandeEtatService getAffiliationDemandeEtatService(){
return affiliationDemandeEtatService;
}
 
 public void setAffiliationDemandeEtatService(AffiliationDemandeEtatService affiliationDemandeEtatService){
this.affiliationDemandeEtatService=affiliationDemandeEtatService;
}

}