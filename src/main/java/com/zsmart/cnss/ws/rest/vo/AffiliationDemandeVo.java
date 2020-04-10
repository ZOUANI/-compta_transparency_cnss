package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class AffiliationDemandeVo{

private String id ;
private String reference ;
private String dateDemandeAffiliation;
private String dateDemandeAffiliationMin ;
private String dateDemandeAffiliationMax ;
private AffilieVo affilieVo ;
private List<LieuActiviteVo>lieuActivitesVo;
private List<SalarieAffiliationVo>salarieAffiliationsVo;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getReference(){
    return reference;
}

public void setReference(String  reference){
     this.reference = reference;
}

public String  getDateDemandeAffiliation(){
    return dateDemandeAffiliation;
}

public void setDateDemandeAffiliation(String  dateDemandeAffiliation){
     this.dateDemandeAffiliation = dateDemandeAffiliation;
}

public String  getDateDemandeAffiliationMin(){
    return dateDemandeAffiliationMin;
}

public void setDateDemandeAffiliationMin(String  dateDemandeAffiliationMin){
     this.dateDemandeAffiliationMin = dateDemandeAffiliationMin;
}

public String  getDateDemandeAffiliationMax(){
    return dateDemandeAffiliationMax;
}

public void setDateDemandeAffiliationMax(String  dateDemandeAffiliationMax){
     this.dateDemandeAffiliationMax = dateDemandeAffiliationMax;
}

public AffilieVo  getAffilieVo (){
    return affilieVo ;
}

public void setAffilieVo (AffilieVo  affilieVo ){
     this.affilieVo  = affilieVo ;
}

public List<LieuActiviteVo> getLieuActivitesVo(){
    return lieuActivitesVo;
}

public void setLieuActivitesVo(List<LieuActiviteVo> lieuActivitesVo){
     this.lieuActivitesVo = lieuActivitesVo;
}

public List<SalarieAffiliationVo> getSalarieAffiliationsVo(){
    return salarieAffiliationsVo;
}

public void setSalarieAffiliationsVo(List<SalarieAffiliationVo> salarieAffiliationsVo){
     this.salarieAffiliationsVo = salarieAffiliationsVo;
}




}