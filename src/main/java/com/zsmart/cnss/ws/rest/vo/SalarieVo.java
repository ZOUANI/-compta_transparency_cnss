package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class SalarieVo{

private String id ;
private String nom ;
private String prenom ;
private String dateNaissance;
private String dateNaissanceMin ;
private String dateNaissanceMax ;
private String sexe ;
private String nationalite ;
private String cin ;
private String adresse ;
private String codePostal ;
private String ville ;
private String email ;
private String telNum ;
private String numImmatriculation ;
private TypeSalarieVo typeSalarieVo ;
private AffilieVo dernierAffilieVo ;
private ImmatriculationDemandeVo immatriculationDemandeVo ;
private List<ImmatriculationChangementVo>immatriculationChangementsVo;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getNom(){
    return nom;
}

public void setNom(String  nom){
     this.nom = nom;
}

public String  getPrenom(){
    return prenom;
}

public void setPrenom(String  prenom){
     this.prenom = prenom;
}

public String  getDateNaissance(){
    return dateNaissance;
}

public void setDateNaissance(String  dateNaissance){
     this.dateNaissance = dateNaissance;
}

public String  getDateNaissanceMin(){
    return dateNaissanceMin;
}

public void setDateNaissanceMin(String  dateNaissanceMin){
     this.dateNaissanceMin = dateNaissanceMin;
}

public String  getDateNaissanceMax(){
    return dateNaissanceMax;
}

public void setDateNaissanceMax(String  dateNaissanceMax){
     this.dateNaissanceMax = dateNaissanceMax;
}

public String  getSexe(){
    return sexe;
}

public void setSexe(String  sexe){
     this.sexe = sexe;
}

public String  getNationalite(){
    return nationalite;
}

public void setNationalite(String  nationalite){
     this.nationalite = nationalite;
}

public String  getCin(){
    return cin;
}

public void setCin(String  cin){
     this.cin = cin;
}

public String  getAdresse(){
    return adresse;
}

public void setAdresse(String  adresse){
     this.adresse = adresse;
}

public String  getCodePostal(){
    return codePostal;
}

public void setCodePostal(String  codePostal){
     this.codePostal = codePostal;
}

public String  getVille(){
    return ville;
}

public void setVille(String  ville){
     this.ville = ville;
}

public String  getEmail(){
    return email;
}

public void setEmail(String  email){
     this.email = email;
}

public String  getTelNum(){
    return telNum;
}

public void setTelNum(String  telNum){
     this.telNum = telNum;
}

public String  getNumImmatriculation(){
    return numImmatriculation;
}

public void setNumImmatriculation(String  numImmatriculation){
     this.numImmatriculation = numImmatriculation;
}

public TypeSalarieVo  getTypeSalarieVo (){
    return typeSalarieVo ;
}

public void setTypeSalarieVo (TypeSalarieVo  typeSalarieVo ){
     this.typeSalarieVo  = typeSalarieVo ;
}

public AffilieVo  getDernierAffilieVo (){
    return dernierAffilieVo ;
}

public void setDernierAffilieVo (AffilieVo  dernierAffilieVo ){
     this.dernierAffilieVo  = dernierAffilieVo ;
}

public ImmatriculationDemandeVo  getImmatriculationDemandeVo (){
    return immatriculationDemandeVo ;
}

public void setImmatriculationDemandeVo (ImmatriculationDemandeVo  immatriculationDemandeVo ){
     this.immatriculationDemandeVo  = immatriculationDemandeVo ;
}

public List<ImmatriculationChangementVo> getImmatriculationChangementsVo(){
    return immatriculationChangementsVo;
}

public void setImmatriculationChangementsVo(List<ImmatriculationChangementVo> immatriculationChangementsVo){
     this.immatriculationChangementsVo = immatriculationChangementsVo;
}




}