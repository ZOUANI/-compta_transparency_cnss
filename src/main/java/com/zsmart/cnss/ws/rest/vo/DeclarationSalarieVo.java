package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class DeclarationSalarieVo{

private String id ;
private String periode;
private String periodeMin ;
private String periodeMax ;
private String annee;
private String anneeMin ;
private String anneeMax ;
private String nombreJoursTravaille;
private String nombreJoursTravailleMin ;
private String nombreJoursTravailleMax ;
private String dateDeclaration;
private String dateDeclarationMin ;
private String dateDeclarationMax ;
private TypeDeclarationSalarieVo typeDeclarationSalarieVo ;
private AffilieVo affilieVo ;
private List<DeclarationSalarieItemVo>declarationSalarieItemsVo;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getPeriode(){
    return periode;
}

public void setPeriode(String  periode){
     this.periode = periode;
}

public String  getPeriodeMin(){
    return periodeMin;
}

public void setPeriodeMin(String  periodeMin){
     this.periodeMin = periodeMin;
}

public String  getPeriodeMax(){
    return periodeMax;
}

public void setPeriodeMax(String  periodeMax){
     this.periodeMax = periodeMax;
}

public String  getAnnee(){
    return annee;
}

public void setAnnee(String  annee){
     this.annee = annee;
}

public String  getAnneeMin(){
    return anneeMin;
}

public void setAnneeMin(String  anneeMin){
     this.anneeMin = anneeMin;
}

public String  getAnneeMax(){
    return anneeMax;
}

public void setAnneeMax(String  anneeMax){
     this.anneeMax = anneeMax;
}

public String  getNombreJoursTravaille(){
    return nombreJoursTravaille;
}

public void setNombreJoursTravaille(String  nombreJoursTravaille){
     this.nombreJoursTravaille = nombreJoursTravaille;
}

public String  getNombreJoursTravailleMin(){
    return nombreJoursTravailleMin;
}

public void setNombreJoursTravailleMin(String  nombreJoursTravailleMin){
     this.nombreJoursTravailleMin = nombreJoursTravailleMin;
}

public String  getNombreJoursTravailleMax(){
    return nombreJoursTravailleMax;
}

public void setNombreJoursTravailleMax(String  nombreJoursTravailleMax){
     this.nombreJoursTravailleMax = nombreJoursTravailleMax;
}

public String  getDateDeclaration(){
    return dateDeclaration;
}

public void setDateDeclaration(String  dateDeclaration){
     this.dateDeclaration = dateDeclaration;
}

public String  getDateDeclarationMin(){
    return dateDeclarationMin;
}

public void setDateDeclarationMin(String  dateDeclarationMin){
     this.dateDeclarationMin = dateDeclarationMin;
}

public String  getDateDeclarationMax(){
    return dateDeclarationMax;
}

public void setDateDeclarationMax(String  dateDeclarationMax){
     this.dateDeclarationMax = dateDeclarationMax;
}

public TypeDeclarationSalarieVo  getTypeDeclarationSalarieVo (){
    return typeDeclarationSalarieVo ;
}

public void setTypeDeclarationSalarieVo (TypeDeclarationSalarieVo  typeDeclarationSalarieVo ){
     this.typeDeclarationSalarieVo  = typeDeclarationSalarieVo ;
}

public AffilieVo  getAffilieVo (){
    return affilieVo ;
}

public void setAffilieVo (AffilieVo  affilieVo ){
     this.affilieVo  = affilieVo ;
}

public List<DeclarationSalarieItemVo> getDeclarationSalarieItemsVo(){
    return declarationSalarieItemsVo;
}

public void setDeclarationSalarieItemsVo(List<DeclarationSalarieItemVo> declarationSalarieItemsVo){
     this.declarationSalarieItemsVo = declarationSalarieItemsVo;
}




}