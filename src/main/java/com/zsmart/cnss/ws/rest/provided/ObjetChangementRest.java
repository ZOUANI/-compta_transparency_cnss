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
import com.zsmart.cnss.service.facade.ObjetChangementService;
import com.zsmart.cnss.bean.ObjetChangement;
import com.zsmart.cnss.ws.rest.vo.ObjetChangementVo;
import com.zsmart.cnss.ws.rest.converter.ObjetChangementConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/ObjetChangement")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ObjetChangementRest {

 @Autowired 
 private ObjetChangementService objetChangementService;

 @Autowired 
private ObjetChangementConverter objetChangementConverter ;

@PostMapping("/")
public ObjetChangementVo save(@RequestBody ObjetChangementVo objetChangementVo){
ObjetChangement objetChangement= objetChangementConverter.toItem(objetChangementVo);
return objetChangementConverter.toVo(objetChangementService.save(objetChangement));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
objetChangementService.deleteById(id);
}
@GetMapping("/")
public List<ObjetChangementVo> findAll(){
return objetChangementConverter.toVo(objetChangementService.findAll());
}

 public ObjetChangementConverter getObjetChangementConverter(){
return objetChangementConverter;
}
 
 public void setObjetChangementConverter(ObjetChangementConverter objetChangementConverter){
this.objetChangementConverter=objetChangementConverter;
}

 public ObjetChangementService getObjetChangementService(){
return objetChangementService;
}
 
 public void setObjetChangementService(ObjetChangementService objetChangementService){
this.objetChangementService=objetChangementService;
}

}