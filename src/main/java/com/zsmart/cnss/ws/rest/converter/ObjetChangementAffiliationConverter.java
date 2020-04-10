package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.ObjetChangementAffiliation; 
import com.zsmart.cnss.ws.rest.vo.ObjetChangementAffiliationVo; 

 @Component 
public class ObjetChangementAffiliationConverter extends AbstractConverter<ObjetChangementAffiliation,ObjetChangementAffiliationVo>{ 

private boolean objetChangement; 

 @Autowired
 private ObjetChangementConverter objetChangementConverter ; 
private boolean affiliationChangement; 

 @Autowired
 private AffiliationChangementConverter affiliationChangementConverter ; 

 @Override 
 public ObjetChangementAffiliation toItem(ObjetChangementAffiliationVo vo) {
 if (vo == null) {
    return null;
      } else {
ObjetChangementAffiliation item = new ObjetChangementAffiliation();

 if(objetChangement&& vo.getObjetChangementVo() != null) {
 item.setObjetChangement(objetChangementConverter.toItem(vo.getObjetChangementVo()));
} 
 
 if(affiliationChangement&& vo.getAffiliationChangementVo() != null) {
 item.setAffiliationChangement(affiliationChangementConverter.toItem(vo.getAffiliationChangementVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public ObjetChangementAffiliationVo toVo(ObjetChangementAffiliation item) {
 if (item == null) {
    return null;
      } else {
ObjetChangementAffiliationVo vo = new ObjetChangementAffiliationVo();

 if(objetChangement&& item.getObjetChangement() != null) {
 vo.setObjetChangementVo(objetChangementConverter.toVo(item.getObjetChangement()));
} 
 
 if(affiliationChangement&& item.getAffiliationChangement() != null) {
 vo.setAffiliationChangementVo(affiliationChangementConverter.toVo(item.getAffiliationChangement()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 

objetChangement = true; 

affiliationChangement = true; 
}
 } 
