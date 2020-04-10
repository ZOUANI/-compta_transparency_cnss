package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.TypeDeclarationSalarie; 
import com.zsmart.cnss.ws.rest.vo.TypeDeclarationSalarieVo; 

 @Component 
public class TypeDeclarationSalarieConverter extends AbstractConverter<TypeDeclarationSalarie,TypeDeclarationSalarieVo>{ 


 @Override 
 public TypeDeclarationSalarie toItem(TypeDeclarationSalarieVo vo) {
 if (vo == null) {
    return null;
      } else {
TypeDeclarationSalarie item = new TypeDeclarationSalarie();

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
 public TypeDeclarationSalarieVo toVo(TypeDeclarationSalarie item) {
 if (item == null) {
    return null;
      } else {
TypeDeclarationSalarieVo vo = new TypeDeclarationSalarieVo();

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
