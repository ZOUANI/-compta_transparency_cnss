package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.LieuActivite; 
import com.zsmart.cnss.ws.rest.vo.LieuActiviteVo; 

 @Component 
public class LieuActiviteConverter extends AbstractConverter<LieuActivite,LieuActiviteVo>{ 

private boolean ville; 

 @Autowired
 private VilleConverter villeConverter ; 
private boolean affliationDemande; 

 @Autowired
 private AffiliationDemandeConverter affiliationDemandeConverter ; 

 @Override 
 public LieuActivite toItem(LieuActiviteVo vo) {
 if (vo == null) {
    return null;
      } else {
LieuActivite item = new LieuActivite();

 if(ville&& vo.getVilleVo() != null) {
 item.setVille(villeConverter.toItem(vo.getVilleVo()));
} 
 
 if(affliationDemande&& vo.getAffliationDemandeVo() != null) {
 item.setAffliationDemande(affiliationDemandeConverter.toItem(vo.getAffliationDemandeVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getAdresse())) {
 item.setAdresse(vo.getAdresse());
} 

 if (StringUtil.isNotEmpty(vo.getCommune())) {
 item.setCommune(vo.getCommune());
} 

 if (StringUtil.isNotEmpty(vo.getCodePostal())) {
 item.setCodePostal(vo.getCodePostal());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public LieuActiviteVo toVo(LieuActivite item) {
 if (item == null) {
    return null;
      } else {
LieuActiviteVo vo = new LieuActiviteVo();

 if(ville&& item.getVille() != null) {
 vo.setVilleVo(villeConverter.toVo(item.getVille()));
} 
 
 if(affliationDemande&& item.getAffliationDemande() != null) {
 vo.setAffliationDemandeVo(affiliationDemandeConverter.toVo(item.getAffliationDemande()));
} 
 
 if (StringUtil.isNotEmpty(item.getAdresse())) {
 vo.setAdresse(item.getAdresse());
} 

 if (StringUtil.isNotEmpty(item.getCommune())) {
 vo.setCommune(item.getCommune());
} 

 if (StringUtil.isNotEmpty(item.getCodePostal())) {
 vo.setCodePostal(item.getCodePostal());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 

ville = true; 

affliationDemande = true; 
}
 } 
