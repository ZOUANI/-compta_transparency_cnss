package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.ImmatriculationDemande; 
import com.zsmart.cnss.ws.rest.vo.ImmatriculationDemandeVo; 

 @Component 
public class ImmatriculationDemandeConverter extends AbstractConverter<ImmatriculationDemande,ImmatriculationDemandeVo>{ 

private boolean affilie; 

 @Autowired
 private AffilieConverter affilieConverter ; 
private boolean immatriculationDemandeEtat; 

 @Autowired
 private ImmatriculationDemandeEtatConverter immatriculationDemandeEtatConverter ; 
private boolean salarieImmatriculations; 

 @Autowired
 private SalarieImmatriculationConverter salarieImmatriculationConverter ; 

 @Override 
 public ImmatriculationDemande toItem(ImmatriculationDemandeVo vo) {
 if (vo == null) {
    return null;
      } else {
ImmatriculationDemande item = new ImmatriculationDemande();

 if(affilie&& vo.getAffilieVo() != null) {
 item.setAffilie(affilieConverter.toItem(vo.getAffilieVo()));
} 
 
 if(immatriculationDemandeEtat&& vo.getImmatriculationDemandeEtatVo() != null) {
 item.setImmatriculationDemandeEtat(immatriculationDemandeEtatConverter.toItem(vo.getImmatriculationDemandeEtatVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getNumImmatriculation())) {
 item.setNumImmatriculation(vo.getNumImmatriculation());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getDateDemandeImmatriculation() != null) {
 item.setDateDemandeImmatriculation(DateUtil.parse(vo.getDateDemandeImmatriculation()));
} 

 if (ListUtil.isNotEmpty(vo.getSalarieImmatriculationsVo ()) && salarieImmatriculations) {
 item.setSalarieImmatriculations(salarieImmatriculationConverter.toItem(vo.getSalarieImmatriculationsVo())); 
} 

return item;
 }
 }

  @Override 
 public ImmatriculationDemandeVo toVo(ImmatriculationDemande item) {
 if (item == null) {
    return null;
      } else {
ImmatriculationDemandeVo vo = new ImmatriculationDemandeVo();

 if(affilie&& item.getAffilie() != null) {
 vo.setAffilieVo(affilieConverter.toVo(item.getAffilie()));
} 
 
 if(immatriculationDemandeEtat&& item.getImmatriculationDemandeEtat() != null) {
 vo.setImmatriculationDemandeEtatVo(immatriculationDemandeEtatConverter.toVo(item.getImmatriculationDemandeEtat()));
} 
 
 if (StringUtil.isNotEmpty(item.getNumImmatriculation())) {
 vo.setNumImmatriculation(item.getNumImmatriculation());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getDateDemandeImmatriculation() != null) {
 vo.setDateDemandeImmatriculation(DateUtil.formateDate(item.getDateDemandeImmatriculation()));
} 

 if(ListUtil.isNotEmpty(item.getSalarieImmatriculations()) && salarieImmatriculations) {
 vo.setSalarieImmatriculationsVo(salarieImmatriculationConverter.toVo(item.getSalarieImmatriculations()));
} 

return vo;
 }
 }
public void init() { 

affilie = true; 

immatriculationDemandeEtat = true; 

salarieImmatriculations = true; 
}
 } 
