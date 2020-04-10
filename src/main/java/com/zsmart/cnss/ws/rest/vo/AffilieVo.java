package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class AffilieVo{

private String id ;
private String raisonSocial ;
private String numTaxePro ;
private String numRegistreComerciale ;
private String idFiscal ;
private String iceSociete ;
private String numAffiliationSocieteMere ;
private String numSalariesEmployes ;
private String datePremierSalarie ;
private String adresseSiegeSocial ;
private String typeSiegeSocial ;
private String commune ;
private String quartie ;
private String codePostal ;
private String numTel ;
private String email ;
private String totalSalaire;
private String totalSalaireMin ;
private String totalSalaireMax ;
private FormeJuridqueVo formeJuridiqueVo ;
private VilleVo villeVo ;
private List<DeclarationSalarieVo>declarationSalariesVo;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getRaisonSocial(){
    return raisonSocial;
}

public void setRaisonSocial(String  raisonSocial){
     this.raisonSocial = raisonSocial;
}

public String  getNumTaxePro(){
    return numTaxePro;
}

public void setNumTaxePro(String  numTaxePro){
     this.numTaxePro = numTaxePro;
}

public String  getNumRegistreComerciale(){
    return numRegistreComerciale;
}

public void setNumRegistreComerciale(String  numRegistreComerciale){
     this.numRegistreComerciale = numRegistreComerciale;
}

public String  getIdFiscal(){
    return idFiscal;
}

public void setIdFiscal(String  idFiscal){
     this.idFiscal = idFiscal;
}

public String  getIceSociete(){
    return iceSociete;
}

public void setIceSociete(String  iceSociete){
     this.iceSociete = iceSociete;
}

public String  getNumAffiliationSocieteMere(){
    return numAffiliationSocieteMere;
}

public void setNumAffiliationSocieteMere(String  numAffiliationSocieteMere){
     this.numAffiliationSocieteMere = numAffiliationSocieteMere;
}

public String  getNumSalariesEmployes(){
    return numSalariesEmployes;
}

public void setNumSalariesEmployes(String  numSalariesEmployes){
     this.numSalariesEmployes = numSalariesEmployes;
}

public String  getDatePremierSalarie(){
    return datePremierSalarie;
}

public void setDatePremierSalarie(String  datePremierSalarie){
     this.datePremierSalarie = datePremierSalarie;
}

public String  getAdresseSiegeSocial(){
    return adresseSiegeSocial;
}

public void setAdresseSiegeSocial(String  adresseSiegeSocial){
     this.adresseSiegeSocial = adresseSiegeSocial;
}

public String  getTypeSiegeSocial(){
    return typeSiegeSocial;
}

public void setTypeSiegeSocial(String  typeSiegeSocial){
     this.typeSiegeSocial = typeSiegeSocial;
}

public String  getCommune(){
    return commune;
}

public void setCommune(String  commune){
     this.commune = commune;
}

public String  getQuartie(){
    return quartie;
}

public void setQuartie(String  quartie){
     this.quartie = quartie;
}

public String  getCodePostal(){
    return codePostal;
}

public void setCodePostal(String  codePostal){
     this.codePostal = codePostal;
}

public String  getNumTel(){
    return numTel;
}

public void setNumTel(String  numTel){
     this.numTel = numTel;
}

public String  getEmail(){
    return email;
}

public void setEmail(String  email){
     this.email = email;
}

public String  getTotalSalaire(){
    return totalSalaire;
}

public void setTotalSalaire(String  totalSalaire){
     this.totalSalaire = totalSalaire;
}

public String  getTotalSalaireMin(){
    return totalSalaireMin;
}

public void setTotalSalaireMin(String  totalSalaireMin){
     this.totalSalaireMin = totalSalaireMin;
}

public String  getTotalSalaireMax(){
    return totalSalaireMax;
}

public void setTotalSalaireMax(String  totalSalaireMax){
     this.totalSalaireMax = totalSalaireMax;
}

public FormeJuridqueVo  getFormeJuridiqueVo (){
    return formeJuridiqueVo ;
}

public void setFormeJuridiqueVo (FormeJuridqueVo  formeJuridiqueVo ){
     this.formeJuridiqueVo  = formeJuridiqueVo ;
}

public VilleVo  getVilleVo (){
    return villeVo ;
}

public void setVilleVo (VilleVo  villeVo ){
     this.villeVo  = villeVo ;
}

public List<DeclarationSalarieVo> getDeclarationSalariesVo(){
    return declarationSalariesVo;
}

public void setDeclarationSalariesVo(List<DeclarationSalarieVo> declarationSalariesVo){
     this.declarationSalariesVo = declarationSalariesVo;
}




}