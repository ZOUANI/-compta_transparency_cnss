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
import com.zsmart.cnss.service.facade.AffiliationChangementService;
import com.zsmart.cnss.bean.AffiliationChangement;
import com.zsmart.cnss.ws.rest.vo.AffiliationChangementVo;
import com.zsmart.cnss.ws.rest.converter.AffiliationChangementConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/AffiliationChangement")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AffiliationChangementRest {

 @Autowired 
 private AffiliationChangementService affiliationChangementService;

 @Autowired 
private AffiliationChangementConverter affiliationChangementConverter ;

@PostMapping("/")
public AffiliationChangementVo save(@RequestBody AffiliationChangementVo affiliationChangementVo){
AffiliationChangement affiliationChangement= affiliationChangementConverter.toItem(affiliationChangementVo);
return affiliationChangementConverter.toVo(affiliationChangementService.save(affiliationChangement));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
affiliationChangementService.deleteById(id);
}
@GetMapping("/")
public List<AffiliationChangementVo> findAll(){
return affiliationChangementConverter.toVo(affiliationChangementService.findAll());
}

 public AffiliationChangementConverter getAffiliationChangementConverter(){
return affiliationChangementConverter;
}
 
 public void setAffiliationChangementConverter(AffiliationChangementConverter affiliationChangementConverter){
this.affiliationChangementConverter=affiliationChangementConverter;
}

 public AffiliationChangementService getAffiliationChangementService(){
return affiliationChangementService;
}
 
 public void setAffiliationChangementService(AffiliationChangementService affiliationChangementService){
this.affiliationChangementService=affiliationChangementService;
}

}