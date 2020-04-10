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
import com.zsmart.cnss.service.facade.TypeDeclarationSalarieService;
import com.zsmart.cnss.bean.TypeDeclarationSalarie;
import com.zsmart.cnss.ws.rest.vo.TypeDeclarationSalarieVo;
import com.zsmart.cnss.ws.rest.converter.TypeDeclarationSalarieConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/TypeDeclarationSalarie")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TypeDeclarationSalarieRest {

 @Autowired 
 private TypeDeclarationSalarieService typeDeclarationSalarieService;

 @Autowired 
private TypeDeclarationSalarieConverter typeDeclarationSalarieConverter ;

@PostMapping("/")
public TypeDeclarationSalarieVo save(@RequestBody TypeDeclarationSalarieVo typeDeclarationSalarieVo){
TypeDeclarationSalarie typeDeclarationSalarie= typeDeclarationSalarieConverter.toItem(typeDeclarationSalarieVo);
return typeDeclarationSalarieConverter.toVo(typeDeclarationSalarieService.save(typeDeclarationSalarie));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
typeDeclarationSalarieService.deleteById(id);
}
@GetMapping("/")
public List<TypeDeclarationSalarieVo> findAll(){
return typeDeclarationSalarieConverter.toVo(typeDeclarationSalarieService.findAll());
}

 public TypeDeclarationSalarieConverter getTypeDeclarationSalarieConverter(){
return typeDeclarationSalarieConverter;
}
 
 public void setTypeDeclarationSalarieConverter(TypeDeclarationSalarieConverter typeDeclarationSalarieConverter){
this.typeDeclarationSalarieConverter=typeDeclarationSalarieConverter;
}

 public TypeDeclarationSalarieService getTypeDeclarationSalarieService(){
return typeDeclarationSalarieService;
}
 
 public void setTypeDeclarationSalarieService(TypeDeclarationSalarieService typeDeclarationSalarieService){
this.typeDeclarationSalarieService=typeDeclarationSalarieService;
}

}