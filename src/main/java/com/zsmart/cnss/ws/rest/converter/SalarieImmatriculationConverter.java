package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.SalarieImmatriculation; 
import com.zsmart.cnss.ws.rest.vo.SalarieImmatriculationVo; 

 @Component 
public class SalarieImmatriculationConverter extends AbstractConverter<SalarieImmatriculation,SalarieImmatriculationVo>{ 

private boolean salarie; 

 @Autowired
 private SalarieConverter salarieConverter ; 
private boolean immatriculationDemande; 

 @Autowired
 private ImmatriculationDemandeConverter immatriculationDemandeConverter ; 

 @Override 
 public SalarieImmatriculation toItem(SalarieImmatriculationVo vo) {
 if (vo == null) {
    return null;
      } else {
SalarieImmatriculation item = new SalarieImmatriculation();

 if(salarie&& vo.getSalarieVo() != null) {
 item.setSalarie(salarieConverter.toItem(vo.getSalarieVo()));
} 
 
 if(immatriculationDemande&& vo.getImmatriculationDemandeVo() != null) {
 item.setImmatriculationDemande(immatriculationDemandeConverter.toItem(vo.getImmatriculationDemandeVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public SalarieImmatriculationVo toVo(SalarieImmatriculation item) {
 if (item == null) {
    return null;
      } else {
SalarieImmatriculationVo vo = new SalarieImmatriculationVo();

 if(salarie&& item.getSalarie() != null) {
 vo.setSalarieVo(salarieConverter.toVo(item.getSalarie()));
} 
 
 if(immatriculationDemande&& item.getImmatriculationDemande() != null) {
 vo.setImmatriculationDemandeVo(immatriculationDemandeConverter.toVo(item.getImmatriculationDemande()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 

salarie = true; 

immatriculationDemande = true; 
}
 } 
