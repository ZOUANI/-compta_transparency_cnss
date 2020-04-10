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
import com.zsmart.cnss.service.facade.TypeSalarieService;
import com.zsmart.cnss.bean.TypeSalarie;
import com.zsmart.cnss.ws.rest.vo.TypeSalarieVo;
import com.zsmart.cnss.ws.rest.converter.TypeSalarieConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/TypeSalarie")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TypeSalarieRest {

 @Autowired 
 private TypeSalarieService typeSalarieService;

 @Autowired 
private TypeSalarieConverter typeSalarieConverter ;

@PostMapping("/")
public TypeSalarieVo save(@RequestBody TypeSalarieVo typeSalarieVo){
TypeSalarie typeSalarie= typeSalarieConverter.toItem(typeSalarieVo);
return typeSalarieConverter.toVo(typeSalarieService.save(typeSalarie));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
typeSalarieService.deleteById(id);
}
@GetMapping("/")
public List<TypeSalarieVo> findAll(){
return typeSalarieConverter.toVo(typeSalarieService.findAll());
}

 public TypeSalarieConverter getTypeSalarieConverter(){
return typeSalarieConverter;
}
 
 public void setTypeSalarieConverter(TypeSalarieConverter typeSalarieConverter){
this.typeSalarieConverter=typeSalarieConverter;
}

 public TypeSalarieService getTypeSalarieService(){
return typeSalarieService;
}
 
 public void setTypeSalarieService(TypeSalarieService typeSalarieService){
this.typeSalarieService=typeSalarieService;
}

}