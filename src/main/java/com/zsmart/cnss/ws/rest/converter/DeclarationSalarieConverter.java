package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.DeclarationSalarie; 
import com.zsmart.cnss.ws.rest.vo.DeclarationSalarieVo; 

 @Component 
public class DeclarationSalarieConverter extends AbstractConverter<DeclarationSalarie,DeclarationSalarieVo>{ 

private boolean typeDeclarationSalarie; 

 @Autowired
 private TypeDeclarationSalarieConverter typeDeclarationSalarieConverter ; 
private boolean affilie; 

 @Autowired
 private AffilieConverter affilieConverter ; 
private boolean declarationSalarieItems; 

 @Autowired
 private DeclarationSalarieItemConverter declarationSalarieItemConverter ; 

 @Override 
 public DeclarationSalarie toItem(DeclarationSalarieVo vo) {
 if (vo == null) {
    return null;
      } else {
DeclarationSalarie item = new DeclarationSalarie();

 if(typeDeclarationSalarie&& vo.getTypeDeclarationSalarieVo() != null) {
 item.setTypeDeclarationSalarie(typeDeclarationSalarieConverter.toItem(vo.getTypeDeclarationSalarieVo()));
} 
 
 if(affilie&& vo.getAffilieVo() != null) {
 item.setAffilie(affilieConverter.toItem(vo.getAffilieVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getPeriode() != null) {
 item.setPeriode(NumberUtil.toInt(vo.getPeriode()));
} 

 if (vo.getAnnee() != null) {
 item.setAnnee(NumberUtil.toInt(vo.getAnnee()));
} 

 if (vo.getNombreJoursTravaille() != null) {
 item.setNombreJoursTravaille(NumberUtil.toInt(vo.getNombreJoursTravaille()));
} 

 if (vo.getDateDeclaration() != null) {
 item.setDateDeclaration(DateUtil.parse(vo.getDateDeclaration()));
} 

 if (ListUtil.isNotEmpty(vo.getDeclarationSalarieItemsVo ()) && declarationSalarieItems) {
 item.setDeclarationSalarieItems(declarationSalarieItemConverter.toItem(vo.getDeclarationSalarieItemsVo())); 
} 

return item;
 }
 }

  @Override 
 public DeclarationSalarieVo toVo(DeclarationSalarie item) {
 if (item == null) {
    return null;
      } else {
DeclarationSalarieVo vo = new DeclarationSalarieVo();

 if(typeDeclarationSalarie&& item.getTypeDeclarationSalarie() != null) {
 vo.setTypeDeclarationSalarieVo(typeDeclarationSalarieConverter.toVo(item.getTypeDeclarationSalarie()));
} 
 
 if(affilie&& item.getAffilie() != null) {
 vo.setAffilieVo(affilieConverter.toVo(item.getAffilie()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getPeriode() != null) {
 vo.setPeriode(NumberUtil.toString(item.getPeriode()));
} 

 if (item.getAnnee() != null) {
 vo.setAnnee(NumberUtil.toString(item.getAnnee()));
} 

 if (item.getNombreJoursTravaille() != null) {
 vo.setNombreJoursTravaille(NumberUtil.toString(item.getNombreJoursTravaille()));
} 

 if (item.getDateDeclaration() != null) {
 vo.setDateDeclaration(DateUtil.formateDate(item.getDateDeclaration()));
} 

 if(ListUtil.isNotEmpty(item.getDeclarationSalarieItems()) && declarationSalarieItems) {
 vo.setDeclarationSalarieItemsVo(declarationSalarieItemConverter.toVo(item.getDeclarationSalarieItems()));
} 

return vo;
 }
 }
public void init() { 

typeDeclarationSalarie = true; 

affilie = true; 

declarationSalarieItems = true; 
}
 } 
