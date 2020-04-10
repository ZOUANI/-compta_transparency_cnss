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
import com.zsmart.cnss.service.facade.ObjetChangementAffiliationService;
import com.zsmart.cnss.bean.ObjetChangementAffiliation;
import com.zsmart.cnss.ws.rest.vo.ObjetChangementAffiliationVo;
import com.zsmart.cnss.ws.rest.converter.ObjetChangementAffiliationConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/ObjetChangementAffiliation")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ObjetChangementAffiliationRest {

 @Autowired 
 private ObjetChangementAffiliationService objetChangementAffiliationService;

 @Autowired 
private ObjetChangementAffiliationConverter objetChangementAffiliationConverter ;

@PostMapping("/")
public ObjetChangementAffiliationVo save(@RequestBody ObjetChangementAffiliationVo objetChangementAffiliationVo){
ObjetChangementAffiliation objetChangementAffiliation= objetChangementAffiliationConverter.toItem(objetChangementAffiliationVo);
return objetChangementAffiliationConverter.toVo(objetChangementAffiliationService.save(objetChangementAffiliation));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
objetChangementAffiliationService.deleteById(id);
}
@GetMapping("/")
public List<ObjetChangementAffiliationVo> findAll(){
return objetChangementAffiliationConverter.toVo(objetChangementAffiliationService.findAll());
}

 public ObjetChangementAffiliationConverter getObjetChangementAffiliationConverter(){
return objetChangementAffiliationConverter;
}
 
 public void setObjetChangementAffiliationConverter(ObjetChangementAffiliationConverter objetChangementAffiliationConverter){
this.objetChangementAffiliationConverter=objetChangementAffiliationConverter;
}

 public ObjetChangementAffiliationService getObjetChangementAffiliationService(){
return objetChangementAffiliationService;
}
 
 public void setObjetChangementAffiliationService(ObjetChangementAffiliationService objetChangementAffiliationService){
this.objetChangementAffiliationService=objetChangementAffiliationService;
}

}