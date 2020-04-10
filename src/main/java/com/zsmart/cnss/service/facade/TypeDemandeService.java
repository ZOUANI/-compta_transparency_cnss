package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.TypeDemande;
public interface TypeDemandeService {

public TypeDemande save(TypeDemande typedemande); 
public List<TypeDemande>  findAll();
public TypeDemande findById(Long id);
public int delete(TypeDemande typedemande);
public void  deleteById(Long id);
public void clone(TypeDemande typedemande,TypeDemande typedemandeClone);
public TypeDemande clone(TypeDemande typedemande);
public List<TypeDemande> clone(List<TypeDemande>typedemandes);
 public List<TypeDemande>  findByCriteria(String libelle,Long idMin,Long idMax);

}
