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
import com.zsmart.cnss.service.facade.DeclarationSalarieService;
import com.zsmart.cnss.bean.DeclarationSalarie;
import com.zsmart.cnss.ws.rest.vo.DeclarationSalarieVo;
import com.zsmart.cnss.ws.rest.converter.DeclarationSalarieConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/DeclarationSalarie")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DeclarationSalarieRest {

 @Autowired 
 private DeclarationSalarieService declarationSalarieService;

 @Autowired 
private DeclarationSalarieConverter declarationSalarieConverter ;

@PostMapping("/")
public DeclarationSalarieVo save(@RequestBody DeclarationSalarieVo declarationSalarieVo){
DeclarationSalarie declarationSalarie= declarationSalarieConverter.toItem(declarationSalarieVo);
return declarationSalarieConverter.toVo(declarationSalarieService.save(declarationSalarie));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
declarationSalarieService.deleteById(id);
}
@GetMapping("/")
public List<DeclarationSalarieVo> findAll(){
return declarationSalarieConverter.toVo(declarationSalarieService.findAll());
}

 public DeclarationSalarieConverter getDeclarationSalarieConverter(){
return declarationSalarieConverter;
}
 
 public void setDeclarationSalarieConverter(DeclarationSalarieConverter declarationSalarieConverter){
this.declarationSalarieConverter=declarationSalarieConverter;
}

 public DeclarationSalarieService getDeclarationSalarieService(){
return declarationSalarieService;
}
 
 public void setDeclarationSalarieService(DeclarationSalarieService declarationSalarieService){
this.declarationSalarieService=declarationSalarieService;
}

}