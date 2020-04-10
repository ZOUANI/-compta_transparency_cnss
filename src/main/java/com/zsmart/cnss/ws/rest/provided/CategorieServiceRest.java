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
import com.zsmart.cnss.service.facade.CategorieServiceService;
import com.zsmart.cnss.bean.CategorieService;
import com.zsmart.cnss.ws.rest.vo.CategorieServiceVo;
import com.zsmart.cnss.ws.rest.converter.CategorieServiceConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/CategorieService")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CategorieServiceRest {

 @Autowired 
 private CategorieServiceService categorieServiceService;

 @Autowired 
private CategorieServiceConverter categorieServiceConverter ;

@PostMapping("/")
public CategorieServiceVo save(@RequestBody CategorieServiceVo categorieServiceVo){
CategorieService categorieService= categorieServiceConverter.toItem(categorieServiceVo);
return categorieServiceConverter.toVo(categorieServiceService.save(categorieService));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
categorieServiceService.deleteById(id);
}
@GetMapping("/")
public List<CategorieServiceVo> findAll(){
return categorieServiceConverter.toVo(categorieServiceService.findAll());
}

 public CategorieServiceConverter getCategorieServiceConverter(){
return categorieServiceConverter;
}
 
 public void setCategorieServiceConverter(CategorieServiceConverter categorieServiceConverter){
this.categorieServiceConverter=categorieServiceConverter;
}

 public CategorieServiceService getCategorieServiceService(){
return categorieServiceService;
}
 
 public void setCategorieServiceService(CategorieServiceService categorieServiceService){
this.categorieServiceService=categorieServiceService;
}

}