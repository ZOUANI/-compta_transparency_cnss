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
import com.zsmart.cnss.service.facade.DeclarationSalarieItemService;
import com.zsmart.cnss.bean.DeclarationSalarieItem;
import com.zsmart.cnss.ws.rest.vo.DeclarationSalarieItemVo;
import com.zsmart.cnss.ws.rest.converter.DeclarationSalarieItemConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/DeclarationSalarieItem")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DeclarationSalarieItemRest {

 @Autowired 
 private DeclarationSalarieItemService declarationSalarieItemService;

 @Autowired 
private DeclarationSalarieItemConverter declarationSalarieItemConverter ;

@PostMapping("/")
public DeclarationSalarieItemVo save(@RequestBody DeclarationSalarieItemVo declarationSalarieItemVo){
DeclarationSalarieItem declarationSalarieItem= declarationSalarieItemConverter.toItem(declarationSalarieItemVo);
return declarationSalarieItemConverter.toVo(declarationSalarieItemService.save(declarationSalarieItem));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
declarationSalarieItemService.deleteById(id);
}
@GetMapping("/")
public List<DeclarationSalarieItemVo> findAll(){
return declarationSalarieItemConverter.toVo(declarationSalarieItemService.findAll());
}

 public DeclarationSalarieItemConverter getDeclarationSalarieItemConverter(){
return declarationSalarieItemConverter;
}
 
 public void setDeclarationSalarieItemConverter(DeclarationSalarieItemConverter declarationSalarieItemConverter){
this.declarationSalarieItemConverter=declarationSalarieItemConverter;
}

 public DeclarationSalarieItemService getDeclarationSalarieItemService(){
return declarationSalarieItemService;
}
 
 public void setDeclarationSalarieItemService(DeclarationSalarieItemService declarationSalarieItemService){
this.declarationSalarieItemService=declarationSalarieItemService;
}

}