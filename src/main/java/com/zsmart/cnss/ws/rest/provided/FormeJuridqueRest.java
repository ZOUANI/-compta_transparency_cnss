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
import com.zsmart.cnss.service.facade.FormeJuridqueService;
import com.zsmart.cnss.bean.FormeJuridque;
import com.zsmart.cnss.ws.rest.vo.FormeJuridqueVo;
import com.zsmart.cnss.ws.rest.converter.FormeJuridqueConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/FormeJuridque")
@CrossOrigin(origins = {"http://localhost:4200"})
public class FormeJuridqueRest {

 @Autowired 
 private FormeJuridqueService formeJuridqueService;

 @Autowired 
private FormeJuridqueConverter formeJuridqueConverter ;

@PostMapping("/")
public FormeJuridqueVo save(@RequestBody FormeJuridqueVo formeJuridqueVo){
FormeJuridque formeJuridque= formeJuridqueConverter.toItem(formeJuridqueVo);
return formeJuridqueConverter.toVo(formeJuridqueService.save(formeJuridque));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
formeJuridqueService.deleteById(id);
}
@GetMapping("/")
public List<FormeJuridqueVo> findAll(){
return formeJuridqueConverter.toVo(formeJuridqueService.findAll());
}

 public FormeJuridqueConverter getFormeJuridqueConverter(){
return formeJuridqueConverter;
}
 
 public void setFormeJuridqueConverter(FormeJuridqueConverter formeJuridqueConverter){
this.formeJuridqueConverter=formeJuridqueConverter;
}

 public FormeJuridqueService getFormeJuridqueService(){
return formeJuridqueService;
}
 
 public void setFormeJuridqueService(FormeJuridqueService formeJuridqueService){
this.formeJuridqueService=formeJuridqueService;
}

}