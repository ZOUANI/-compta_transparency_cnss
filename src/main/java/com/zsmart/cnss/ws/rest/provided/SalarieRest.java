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
import com.zsmart.cnss.service.facade.SalarieService;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.ws.rest.vo.SalarieVo;
import com.zsmart.cnss.ws.rest.converter.SalarieConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/Salarie")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SalarieRest {

 @Autowired 
 private SalarieService salarieService;

 @Autowired 
private SalarieConverter salarieConverter ;

@PostMapping("/")
public SalarieVo save(@RequestBody SalarieVo salarieVo){
Salarie salarie= salarieConverter.toItem(salarieVo);
return salarieConverter.toVo(salarieService.save(salarie));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
salarieService.deleteById(id);
}
@GetMapping("/")
public List<SalarieVo> findAll(){
return salarieConverter.toVo(salarieService.findAll());
}

 public SalarieConverter getSalarieConverter(){
return salarieConverter;
}
 
 public void setSalarieConverter(SalarieConverter salarieConverter){
this.salarieConverter=salarieConverter;
}

 public SalarieService getSalarieService(){
return salarieService;
}
 
 public void setSalarieService(SalarieService salarieService){
this.salarieService=salarieService;
}

}