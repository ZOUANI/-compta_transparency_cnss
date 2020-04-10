package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.DeclarationSalarieItem; 
import com.zsmart.cnss.ws.rest.vo.DeclarationSalarieItemVo; 

 @Component 
public class DeclarationSalarieItemConverter extends AbstractConverter<DeclarationSalarieItem,DeclarationSalarieItemVo>{ 

private boolean salarie; 

 @Autowired
 private SalarieConverter salarieConverter ; 
private boolean declarationSalarie; 

 @Autowired
 private DeclarationSalarieConverter declarationSalarieConverter ; 

 @Override 
 public DeclarationSalarieItem toItem(DeclarationSalarieItemVo vo) {
 if (vo == null) {
    return null;
      } else {
DeclarationSalarieItem item = new DeclarationSalarieItem();

 if(salarie&& vo.getSalarieVo() != null) {
 item.setSalarie(salarieConverter.toItem(vo.getSalarieVo()));
} 
 
 if(declarationSalarie&& vo.getDeclarationSalarieVo() != null) {
 item.setDeclarationSalarie(declarationSalarieConverter.toItem(vo.getDeclarationSalarieVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getSalaireBrut() != null) {
 item.setSalaireBrut(NumberUtil.toBigDecimal(vo.getSalaireBrut()));
} 

 if (vo.getDateDeclarationSalarie() != null) {
 item.setDateDeclarationSalarie(DateUtil.parse(vo.getDateDeclarationSalarie()));
} 

return item;
 }
 }

  @Override 
 public DeclarationSalarieItemVo toVo(DeclarationSalarieItem item) {
 if (item == null) {
    return null;
      } else {
DeclarationSalarieItemVo vo = new DeclarationSalarieItemVo();

 if(salarie&& item.getSalarie() != null) {
 vo.setSalarieVo(salarieConverter.toVo(item.getSalarie()));
} 
 
 if(declarationSalarie&& item.getDeclarationSalarie() != null) {
 vo.setDeclarationSalarieVo(declarationSalarieConverter.toVo(item.getDeclarationSalarie()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getSalaireBrut() != null) {
 vo.setSalaireBrut(NumberUtil.toString(item.getSalaireBrut()));
} 

 if (item.getDateDeclarationSalarie() != null) {
 vo.setDateDeclarationSalarie(DateUtil.formateDate(item.getDateDeclarationSalarie()));
} 

return vo;
 }
 }
public void init() { 

salarie = true; 

declarationSalarie = true; 
}
 } 
