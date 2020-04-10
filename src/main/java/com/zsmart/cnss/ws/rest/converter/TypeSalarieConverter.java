package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.TypeSalarie; 
import com.zsmart.cnss.ws.rest.vo.TypeSalarieVo; 

 @Component 
public class TypeSalarieConverter extends AbstractConverter<TypeSalarie,TypeSalarieVo>{ 


 @Override 
 public TypeSalarie toItem(TypeSalarieVo vo) {
 if (vo == null) {
    return null;
      } else {
TypeSalarie item = new TypeSalarie();

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
 public TypeSalarieVo toVo(TypeSalarie item) {
 if (item == null) {
    return null;
      } else {
TypeSalarieVo vo = new TypeSalarieVo();

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
