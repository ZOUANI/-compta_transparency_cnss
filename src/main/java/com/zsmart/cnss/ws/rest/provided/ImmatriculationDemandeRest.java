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
import com.zsmart.cnss.service.facade.ImmatriculationDemandeService;
import com.zsmart.cnss.bean.ImmatriculationDemande;
import com.zsmart.cnss.ws.rest.vo.ImmatriculationDemandeVo;
import com.zsmart.cnss.ws.rest.converter.ImmatriculationDemandeConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/ImmatriculationDemande")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ImmatriculationDemandeRest {

 @Autowired 
 private ImmatriculationDemandeService immatriculationDemandeService;

 @Autowired 
private ImmatriculationDemandeConverter immatriculationDemandeConverter ;

@PostMapping("/")
public ImmatriculationDemandeVo save(@RequestBody ImmatriculationDemandeVo immatriculationDemandeVo){
ImmatriculationDemande immatriculationDemande= immatriculationDemandeConverter.toItem(immatriculationDemandeVo);
return immatriculationDemandeConverter.toVo(immatriculationDemandeService.save(immatriculationDemande));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
immatriculationDemandeService.deleteById(id);
}
@GetMapping("/")
public List<ImmatriculationDemandeVo> findAll(){
return immatriculationDemandeConverter.toVo(immatriculationDemandeService.findAll());
}

 public ImmatriculationDemandeConverter getImmatriculationDemandeConverter(){
return immatriculationDemandeConverter;
}
 
 public void setImmatriculationDemandeConverter(ImmatriculationDemandeConverter immatriculationDemandeConverter){
this.immatriculationDemandeConverter=immatriculationDemandeConverter;
}

 public ImmatriculationDemandeService getImmatriculationDemandeService(){
return immatriculationDemandeService;
}
 
 public void setImmatriculationDemandeService(ImmatriculationDemandeService immatriculationDemandeService){
this.immatriculationDemandeService=immatriculationDemandeService;
}

}