package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.bean.TypeSalarie; 
import com.zsmart.cnss.bean.Affilie; 
import com.zsmart.cnss.bean.ImmatriculationDemande; 
public interface SalarieService {

public Salarie save(Salarie salarie); 
public Salarie  saveWithImmatriculationChangements (Salarie salarie);public List<Salarie>  findAll();
public Salarie findById(Long id);
public int delete(Salarie salarie);
public void  deleteById(Long id);
public void clone(Salarie salarie,Salarie salarieClone);
public Salarie clone(Salarie salarie);
public List<Salarie> clone(List<Salarie>salaries);
 public List<Salarie>  findByCriteria(String nom,String prenom,String sexe,String nationalite,String cin,String adresse,String codePostal,String ville,String email,String telNum,String numImmatriculation,Long idMin,Long idMax,Date dateNaissanceMin,Date dateNaissanceMax);

}
