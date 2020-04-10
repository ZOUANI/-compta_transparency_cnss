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
import com.zsmart.cnss.service.facade.ImmatriculationChangementEtatService;
import com.zsmart.cnss.bean.ImmatriculationChangementEtat;
import com.zsmart.cnss.ws.rest.vo.ImmatriculationChangementEtatVo;
import com.zsmart.cnss.ws.rest.converter.ImmatriculationChangementEtatConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/ImmatriculationChangementEtat")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ImmatriculationChangementEtatRest {

 @Autowired 
 private ImmatriculationChangementEtatService immatriculationChangementEtatService;

 @Autowired 
private ImmatriculationChangementEtatConverter immatriculationChangementEtatConverter ;

@PostMapping("/")
public ImmatriculationChangementEtatVo save(@RequestBody ImmatriculationChangementEtatVo immatriculationChangementEtatVo){
ImmatriculationChangementEtat immatriculationChangementEtat= immatriculationChangementEtatConverter.toItem(immatriculationChangementEtatVo);
return immatriculationChangementEtatConverter.toVo(immatriculationChangementEtatService.save(immatriculationChangementEtat));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
immatriculationChangementEtatService.deleteById(id);
}
@DeleteMapping("/{reference}")
public void  deleteByReference(@PathVariable String  reference){
immatriculationChangementEtatService.deleteByReference(reference);
}
@GetMapping("/")
public List<ImmatriculationChangementEtatVo> findAll(){
return immatriculationChangementEtatConverter.toVo(immatriculationChangementEtatService.findAll());
}

 public ImmatriculationChangementEtatConverter getImmatriculationChangementEtatConverter(){
return immatriculationChangementEtatConverter;
}
 
 public void setImmatriculationChangementEtatConverter(ImmatriculationChangementEtatConverter immatriculationChangementEtatConverter){
this.immatriculationChangementEtatConverter=immatriculationChangementEtatConverter;
}

 public ImmatriculationChangementEtatService getImmatriculationChangementEtatService(){
return immatriculationChangementEtatService;
}
 
 public void setImmatriculationChangementEtatService(ImmatriculationChangementEtatService immatriculationChangementEtatService){
this.immatriculationChangementEtatService=immatriculationChangementEtatService;
}

}