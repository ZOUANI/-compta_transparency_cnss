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
import com.zsmart.cnss.service.facade.PieceService;
import com.zsmart.cnss.bean.Piece;
import com.zsmart.cnss.ws.rest.vo.PieceVo;
import com.zsmart.cnss.ws.rest.converter.PieceConverter;
import com.zsmart.cnss.service.util.* ;
@RestController
@RequestMapping("/cnss/Piece")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PieceRest {

 @Autowired 
 private PieceService pieceService;

 @Autowired 
private PieceConverter pieceConverter ;

@PostMapping("/")
public PieceVo save(@RequestBody PieceVo pieceVo){
Piece piece= pieceConverter.toItem(pieceVo);
return pieceConverter.toVo(pieceService.save(piece));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
pieceService.deleteById(id);
}
@DeleteMapping("/{reference}")
public void  deleteByReference(@PathVariable String  reference){
pieceService.deleteByReference(reference);
}
@GetMapping("/")
public List<PieceVo> findAll(){
return pieceConverter.toVo(pieceService.findAll());
}

 public PieceConverter getPieceConverter(){
return pieceConverter;
}
 
 public void setPieceConverter(PieceConverter pieceConverter){
this.pieceConverter=pieceConverter;
}

 public PieceService getPieceService(){
return pieceService;
}
 
 public void setPieceService(PieceService pieceService){
this.pieceService=pieceService;
}

}