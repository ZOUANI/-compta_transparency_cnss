package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.SalarieAffiliation; 
import com.zsmart.cnss.ws.rest.vo.SalarieAffiliationVo; 

 @Component 
public class SalarieAffiliationConverter extends AbstractConverter<SalarieAffiliation,SalarieAffiliationVo>{ 

private boolean salarie; 

 @Autowired
 private SalarieConverter salarieConverter ; 
private boolean affiliationDemande; 

 @Autowired
 private AffiliationDemandeConverter affiliationDemandeConverter ; 

 @Override 
 public SalarieAffiliation toItem(SalarieAffiliationVo vo) {
 if (vo == null) {
    return null;
      } else {
SalarieAffiliation item = new SalarieAffiliation();

 if(salarie&& vo.getSalarieVo() != null) {
 item.setSalarie(salarieConverter.toItem(vo.getSalarieVo()));
} 
 
 if(affiliationDemande&& vo.getAffiliationDemandeVo() != null) {
 item.setAffiliationDemande(affiliationDemandeConverter.toItem(vo.getAffiliationDemandeVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public SalarieAffiliationVo toVo(SalarieAffiliation item) {
 if (item == null) {
    return null;
      } else {
SalarieAffiliationVo vo = new SalarieAffiliationVo();

 if(salarie&& item.getSalarie() != null) {
 vo.setSalarieVo(salarieConverter.toVo(item.getSalarie()));
} 
 
 if(affiliationDemande&& item.getAffiliationDemande() != null) {
 vo.setAffiliationDemandeVo(affiliationDemandeConverter.toVo(item.getAffiliationDemande()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 

salarie = true; 

affiliationDemande = true; 
}
 } 
