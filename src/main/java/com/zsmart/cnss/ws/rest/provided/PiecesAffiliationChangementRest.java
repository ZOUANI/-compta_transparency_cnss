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
import com.zsmart.cnss.service.facade.PiecesAffiliationChangementService;
import com.zsmart.cnss.bean.PiecesAffiliationChangement;
import com.zsmart.cnss.ws.rest.vo.PiecesAffiliationChangementVo;
import com.zsmart.cnss.ws.rest.converter.PiecesAffiliationChangementConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/PiecesAffiliationChangement")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PiecesAffiliationChangementRest {

 @Autowired 
 private PiecesAffiliationChangementService piecesAffiliationChangementService;

 @Autowired 
private PiecesAffiliationChangementConverter piecesAffiliationChangementConverter ;

@PostMapping("/")
public PiecesAffiliationChangementVo save(@RequestBody PiecesAffiliationChangementVo piecesAffiliationChangementVo){
PiecesAffiliationChangement piecesAffiliationChangement= piecesAffiliationChangementConverter.toItem(piecesAffiliationChangementVo);
return piecesAffiliationChangementConverter.toVo(piecesAffiliationChangementService.save(piecesAffiliationChangement));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
piecesAffiliationChangementService.deleteById(id);
}
@GetMapping("/")
public List<PiecesAffiliationChangementVo> findAll(){
return piecesAffiliationChangementConverter.toVo(piecesAffiliationChangementService.findAll());
}

 public PiecesAffiliationChangementConverter getPiecesAffiliationChangementConverter(){
return piecesAffiliationChangementConverter;
}
 
 public void setPiecesAffiliationChangementConverter(PiecesAffiliationChangementConverter piecesAffiliationChangementConverter){
this.piecesAffiliationChangementConverter=piecesAffiliationChangementConverter;
}

 public PiecesAffiliationChangementService getPiecesAffiliationChangementService(){
return piecesAffiliationChangementService;
}
 
 public void setPiecesAffiliationChangementService(PiecesAffiliationChangementService piecesAffiliationChangementService){
this.piecesAffiliationChangementService=piecesAffiliationChangementService;
}

}