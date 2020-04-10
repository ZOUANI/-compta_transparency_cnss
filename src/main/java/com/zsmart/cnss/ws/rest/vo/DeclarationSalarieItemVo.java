package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class DeclarationSalarieItemVo{

private String id ;
private String salaireBrut;
private String salaireBrutMin ;
private String salaireBrutMax ;
private String dateDeclarationSalarie;
private String dateDeclarationSalarieMin ;
private String dateDeclarationSalarieMax ;
private SalarieVo salarieVo ;
private DeclarationSalarieVo declarationSalarieVo ;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getSalaireBrut(){
    return salaireBrut;
}

public void setSalaireBrut(String  salaireBrut){
     this.salaireBrut = salaireBrut;
}

public String  getSalaireBrutMin(){
    return salaireBrutMin;
}

public void setSalaireBrutMin(String  salaireBrutMin){
     this.salaireBrutMin = salaireBrutMin;
}

public String  getSalaireBrutMax(){
    return salaireBrutMax;
}

public void setSalaireBrutMax(String  salaireBrutMax){
     this.salaireBrutMax = salaireBrutMax;
}

public String  getDateDeclarationSalarie(){
    return dateDeclarationSalarie;
}

public void setDateDeclarationSalarie(String  dateDeclarationSalarie){
     this.dateDeclarationSalarie = dateDeclarationSalarie;
}

public String  getDateDeclarationSalarieMin(){
    return dateDeclarationSalarieMin;
}

public void setDateDeclarationSalarieMin(String  dateDeclarationSalarieMin){
     this.dateDeclarationSalarieMin = dateDeclarationSalarieMin;
}

public String  getDateDeclarationSalarieMax(){
    return dateDeclarationSalarieMax;
}

public void setDateDeclarationSalarieMax(String  dateDeclarationSalarieMax){
     this.dateDeclarationSalarieMax = dateDeclarationSalarieMax;
}

public SalarieVo  getSalarieVo (){
    return salarieVo ;
}

public void setSalarieVo (SalarieVo  salarieVo ){
     this.salarieVo  = salarieVo ;
}

public DeclarationSalarieVo  getDeclarationSalarieVo (){
    return declarationSalarieVo ;
}

public void setDeclarationSalarieVo (DeclarationSalarieVo  declarationSalarieVo ){
     this.declarationSalarieVo  = declarationSalarieVo ;
}




}