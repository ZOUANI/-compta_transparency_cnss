package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.ObjetChangement; 
import com.zsmart.cnss.ws.rest.vo.ObjetChangementVo; 

 @Component 
public class ObjetChangementConverter extends AbstractConverter<ObjetChangement,ObjetChangementVo>{ 


 @Override 
 public ObjetChangement toItem(ObjetChangementVo vo) {
 if (vo == null) {
    return null;
      } else {
ObjetChangement item = new ObjetChangement();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public ObjetChangementVo toVo(ObjetChangement item) {
 if (item == null) {
    return null;
      } else {
ObjetChangementVo vo = new ObjetChangementVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 
}
 } 
