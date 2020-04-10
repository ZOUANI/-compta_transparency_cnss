package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.PiecesAffiliationChangement; 
import com.zsmart.cnss.ws.rest.vo.PiecesAffiliationChangementVo; 

 @Component 
public class PiecesAffiliationChangementConverter extends AbstractConverter<PiecesAffiliationChangement,PiecesAffiliationChangementVo>{ 

private boolean piecesObjetChangement; 

 @Autowired
 private PiecesObjetChangementConverter piecesObjetChangementConverter ; 
private boolean affiliationChangement; 

 @Autowired
 private AffiliationChangementConverter affiliationChangementConverter ; 

 @Override 
 public PiecesAffiliationChangement toItem(PiecesAffiliationChangementVo vo) {
 if (vo == null) {
    return null;
      } else {
PiecesAffiliationChangement item = new PiecesAffiliationChangement();

 if(piecesObjetChangement&& vo.getPiecesObjetChangementVo() != null) {
 item.setPiecesObjetChangement(piecesObjetChangementConverter.toItem(vo.getPiecesObjetChangementVo()));
} 
 
 if(affiliationChangement&& vo.getAffiliationChangementVo() != null) {
 item.setAffiliationChangement(affiliationChangementConverter.toItem(vo.getAffiliationChangementVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getNombreFourni() != null) {
 item.setNombreFourni(NumberUtil.toInt(vo.getNombreFourni()));
} 

return item;
 }
 }

  @Override 
 public PiecesAffiliationChangementVo toVo(PiecesAffiliationChangement item) {
 if (item == null) {
    return null;
      } else {
PiecesAffiliationChangementVo vo = new PiecesAffiliationChangementVo();

 if(piecesObjetChangement&& item.getPiecesObjetChangement() != null) {
 vo.setPiecesObjetChangementVo(piecesObjetChangementConverter.toVo(item.getPiecesObjetChangement()));
} 
 
 if(affiliationChangement&& item.getAffiliationChangement() != null) {
 vo.setAffiliationChangementVo(affiliationChangementConverter.toVo(item.getAffiliationChangement()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getNombreFourni() != null) {
 vo.setNombreFourni(NumberUtil.toString(item.getNombreFourni()));
} 

return vo;
 }
 }
public void init() { 

piecesObjetChangement = true; 

affiliationChangement = true; 
}
 } 
