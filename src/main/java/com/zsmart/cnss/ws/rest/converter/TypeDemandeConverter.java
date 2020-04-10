package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.TypeDemande; 
import com.zsmart.cnss.ws.rest.vo.TypeDemandeVo; 

 @Component 
public class TypeDemandeConverter extends AbstractConverter<TypeDemande,TypeDemandeVo>{ 


 @Override 
 public TypeDemande toItem(TypeDemandeVo vo) {
 if (vo == null) {
    return null;
      } else {
TypeDemande item = new TypeDemande();

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
 public TypeDemandeVo toVo(TypeDemande item) {
 if (item == null) {
    return null;
      } else {
TypeDemandeVo vo = new TypeDemandeVo();

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
