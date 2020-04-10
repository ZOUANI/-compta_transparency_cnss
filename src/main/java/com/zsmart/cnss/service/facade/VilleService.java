package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.Ville;
public interface VilleService {

public Ville save(Ville ville); 
public List<Ville>  findAll();
public Ville findById(Long id);
public int delete(Ville ville);
public void  deleteById(Long id);
public void clone(Ville ville,Ville villeClone);
public Ville clone(Ville ville);
public List<Ville> clone(List<Ville>villes);
 public List<Ville>  findByCriteria(String libelle,Long idMin,Long idMax);

}
