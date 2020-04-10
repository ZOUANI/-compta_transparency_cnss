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
import com.zsmart.cnss.service.facade.TypeChangementService;
import com.zsmart.cnss.bean.TypeChangement;
import com.zsmart.cnss.ws.rest.vo.TypeChangementVo;
import com.zsmart.cnss.ws.rest.converter.TypeChangementConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/TypeChangement")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TypeChangementRest {

 @Autowired 
 private TypeChangementService typeChangementService;

 @Autowired 
private TypeChangementConverter typeChangementConverter ;

@PostMapping("/")
public TypeChangementVo save(@RequestBody TypeChangementVo typeChangementVo){
TypeChangement typeChangement= typeChangementConverter.toItem(typeChangementVo);
return typeChangementConverter.toVo(typeChangementService.save(typeChangement));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
typeChangementService.deleteById(id);
}
@GetMapping("/")
public List<TypeChangementVo> findAll(){
return typeChangementConverter.toVo(typeChangementService.findAll());
}

 public TypeChangementConverter getTypeChangementConverter(){
return typeChangementConverter;
}
 
 public void setTypeChangementConverter(TypeChangementConverter typeChangementConverter){
this.typeChangementConverter=typeChangementConverter;
}

 public TypeChangementService getTypeChangementService(){
return typeChangementService;
}
 
 public void setTypeChangementService(TypeChangementService typeChangementService){
this.typeChangementService=typeChangementService;
}

}