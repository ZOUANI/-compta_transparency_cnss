package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.FormeJuridque;
public interface FormeJuridqueService {

public FormeJuridque save(FormeJuridque formejuridque); 
public List<FormeJuridque>  findAll();
public FormeJuridque findById(Long id);
public int delete(FormeJuridque formejuridque);
public void  deleteById(Long id);
public void clone(FormeJuridque formejuridque,FormeJuridque formejuridqueClone);
public FormeJuridque clone(FormeJuridque formejuridque);
public List<FormeJuridque> clone(List<FormeJuridque>formejuridques);
 public List<FormeJuridque>  findByCriteria(String libelle,Long idMin,Long idMax);

}
