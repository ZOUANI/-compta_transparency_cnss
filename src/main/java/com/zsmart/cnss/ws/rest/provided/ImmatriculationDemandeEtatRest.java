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
import com.zsmart.cnss.service.facade.ImmatriculationDemandeEtatService;
import com.zsmart.cnss.bean.ImmatriculationDemandeEtat;
import com.zsmart.cnss.ws.rest.vo.ImmatriculationDemandeEtatVo;
import com.zsmart.cnss.ws.rest.converter.ImmatriculationDemandeEtatConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/ImmatriculationDemandeEtat")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ImmatriculationDemandeEtatRest {

 @Autowired 
 private ImmatriculationDemandeEtatService immatriculationDemandeEtatService;

 @Autowired 
private ImmatriculationDemandeEtatConverter immatriculationDemandeEtatConverter ;

@PostMapping("/")
public ImmatriculationDemandeEtatVo save(@RequestBody ImmatriculationDemandeEtatVo immatriculationDemandeEtatVo){
ImmatriculationDemandeEtat immatriculationDemandeEtat= immatriculationDemandeEtatConverter.toItem(immatriculationDemandeEtatVo);
return immatriculationDemandeEtatConverter.toVo(immatriculationDemandeEtatService.save(immatriculationDemandeEtat));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
immatriculationDemandeEtatService.deleteById(id);
}
@DeleteMapping("/{reference}")
public void  deleteByReference(@PathVariable String  reference){
immatriculationDemandeEtatService.deleteByReference(reference);
}
@GetMapping("/")
public List<ImmatriculationDemandeEtatVo> findAll(){
return immatriculationDemandeEtatConverter.toVo(immatriculationDemandeEtatService.findAll());
}

 public ImmatriculationDemandeEtatConverter getImmatriculationDemandeEtatConverter(){
return immatriculationDemandeEtatConverter;
}
 
 public void setImmatriculationDemandeEtatConverter(ImmatriculationDemandeEtatConverter immatriculationDemandeEtatConverter){
this.immatriculationDemandeEtatConverter=immatriculationDemandeEtatConverter;
}

 public ImmatriculationDemandeEtatService getImmatriculationDemandeEtatService(){
return immatriculationDemandeEtatService;
}
 
 public void setImmatriculationDemandeEtatService(ImmatriculationDemandeEtatService immatriculationDemandeEtatService){
this.immatriculationDemandeEtatService=immatriculationDemandeEtatService;
}

}