package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.FormeJuridque; 
import com.zsmart.cnss.ws.rest.vo.FormeJuridqueVo; 

 @Component 
public class FormeJuridqueConverter extends AbstractConverter<FormeJuridque,FormeJuridqueVo>{ 


 @Override 
 public FormeJuridque toItem(FormeJuridqueVo vo) {
 if (vo == null) {
    return null;
      } else {
FormeJuridque item = new FormeJuridque();

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
 public FormeJuridqueVo toVo(FormeJuridque item) {
 if (item == null) {
    return null;
      } else {
FormeJuridqueVo vo = new FormeJuridqueVo();

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
