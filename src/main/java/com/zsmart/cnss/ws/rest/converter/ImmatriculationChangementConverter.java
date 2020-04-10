package com.zsmart.cnss.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.ImmatriculationChangement; 
import com.zsmart.cnss.ws.rest.vo.ImmatriculationChangementVo; 

 @Component 
public class ImmatriculationChangementConverter extends AbstractConverter<ImmatriculationChangement,ImmatriculationChangementVo>{ 

private boolean typeChangement; 

 @Autowired
 private TypeChangementConverter typeChangementConverter ; 
private boolean salarie; 

 @Autowired
 private SalarieConverter salarieConverter ; 
private boolean immatriculationChangementEtat; 

 @Autowired
 private ImmatriculationChangementEtatConverter immatriculationChangementEtatConverter ; 
private boolean objetChangementImmatriculations; 

 @Autowired
 private ObjetChangementImmatriculationConverter objetChangementImmatriculationConverter ; 
private boolean piecesImmatriculationChangements; 

 @Autowired
 private PiecesImmatriculationChangementConverter piecesImmatriculationChangementConverter ; 

 @Override 
 public ImmatriculationChangement toItem(ImmatriculationChangementVo vo) {
 if (vo == null) {
    return null;
      } else {
ImmatriculationChangement item = new ImmatriculationChangement();

 if(typeChangement&& vo.getTypeChangementVo() != null) {
 item.setTypeChangement(typeChangementConverter.toItem(vo.getTypeChangementVo()));
} 
 
 if(salarie&& vo.getSalarieVo() != null) {
 item.setSalarie(salarieConverter.toItem(vo.getSalarieVo()));
} 
 
 if(immatriculationChangementEtat&& vo.getImmatriculationChangementEtatVo() != null) {
 item.setImmatriculationChangementEtat(immatriculationChangementEtatConverter.toItem(vo.getImmatriculationChangementEtatVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getNumAffiliation())) {
 item.setNumAffiliation(vo.getNumAffiliation());
} 

 if (StringUtil.isNotEmpty(vo.getDescription())) {
 item.setDescription(vo.getDescription());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getDateChangementImmatriculation() != null) {
 item.setDateChangementImmatriculation(DateUtil.parse(vo.getDateChangementImmatriculation()));
} 

 if (ListUtil.isNotEmpty(vo.getObjetChangementImmatriculationsVo ()) && objetChangementImmatriculations) {
 item.setObjetChangementImmatriculations(objetChangementImmatriculationConverter.toItem(vo.getObjetChangementImmatriculationsVo())); 
} 

 if (ListUtil.isNotEmpty(vo.getPiecesImmatriculationChangementsVo ()) && piecesImmatriculationChangements) {
 item.setPiecesImmatriculationChangements(piecesImmatriculationChangementConverter.toItem(vo.getPiecesImmatriculationChangementsVo())); 
} 

return item;
 }
 }

  @Override 
 public ImmatriculationChangementVo toVo(ImmatriculationChangement item) {
 if (item == null) {
    return null;
      } else {
ImmatriculationChangementVo vo = new ImmatriculationChangementVo();

 if(typeChangement&& item.getTypeChangement() != null) {
 vo.setTypeChangementVo(typeChangementConverter.toVo(item.getTypeChangement()));
} 
 
 if(salarie&& item.getSalarie() != null) {
 vo.setSalarieVo(salarieConverter.toVo(item.getSalarie()));
} 
 
 if(immatriculationChangementEtat&& item.getImmatriculationChangementEtat() != null) {
 vo.setImmatriculationChangementEtatVo(immatriculationChangementEtatConverter.toVo(item.getImmatriculationChangementEtat()));
} 
 
 if (StringUtil.isNotEmpty(item.getNumAffiliation())) {
 vo.setNumAffiliation(item.getNumAffiliation());
} 

 if (StringUtil.isNotEmpty(item.getDescription())) {
 vo.setDescription(item.getDescription());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getDateChangementImmatriculation() != null) {
 vo.setDateChangementImmatriculation(DateUtil.formateDate(item.getDateChangementImmatriculation()));
} 

 if(ListUtil.isNotEmpty(item.getObjetChangementImmatriculations()) && objetChangementImmatriculations) {
 vo.setObjetChangementImmatriculationsVo(objetChangementImmatriculationConverter.toVo(item.getObjetChangementImmatriculations()));
} 

 if(ListUtil.isNotEmpty(item.getPiecesImmatriculationChangements()) && piecesImmatriculationChangements) {
 vo.setPiecesImmatriculationChangementsVo(piecesImmatriculationChangementConverter.toVo(item.getPiecesImmatriculationChangements()));
} 

return vo;
 }
 }
public void init() { 

typeChangement = true; 

salarie = true; 

immatriculationChangementEtat = true; 

objetChangementImmatriculations = true; 

piecesImmatriculationChangements = true; 
}
 } 
