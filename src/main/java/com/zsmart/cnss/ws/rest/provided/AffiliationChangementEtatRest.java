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
import com.zsmart.cnss.service.facade.AffiliationChangementEtatService;
import com.zsmart.cnss.bean.AffiliationChangementEtat;
import com.zsmart.cnss.ws.rest.vo.AffiliationChangementEtatVo;
import com.zsmart.cnss.ws.rest.converter.AffiliationChangementEtatConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/AffiliationChangementEtat")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AffiliationChangementEtatRest {

 @Autowired 
 private AffiliationChangementEtatService affiliationChangementEtatService;

 @Autowired 
private AffiliationChangementEtatConverter affiliationChangementEtatConverter ;

@PostMapping("/")
public AffiliationChangementEtatVo save(@RequestBody AffiliationChangementEtatVo affiliationChangementEtatVo){
AffiliationChangementEtat affiliationChangementEtat= affiliationChangementEtatConverter.toItem(affiliationChangementEtatVo);
return affiliationChangementEtatConverter.toVo(affiliationChangementEtatService.save(affiliationChangementEtat));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
affiliationChangementEtatService.deleteById(id);
}
@DeleteMapping("/{reference}")
public void  deleteByReference(@PathVariable String  reference){
affiliationChangementEtatService.deleteByReference(reference);
}
@GetMapping("/")
public List<AffiliationChangementEtatVo> findAll(){
return affiliationChangementEtatConverter.toVo(affiliationChangementEtatService.findAll());
}

 public AffiliationChangementEtatConverter getAffiliationChangementEtatConverter(){
return affiliationChangementEtatConverter;
}
 
 public void setAffiliationChangementEtatConverter(AffiliationChangementEtatConverter affiliationChangementEtatConverter){
this.affiliationChangementEtatConverter=affiliationChangementEtatConverter;
}

 public AffiliationChangementEtatService getAffiliationChangementEtatService(){
return affiliationChangementEtatService;
}
 
 public void setAffiliationChangementEtatService(AffiliationChangementEtatService affiliationChangementEtatService){
this.affiliationChangementEtatService=affiliationChangementEtatService;
}

}