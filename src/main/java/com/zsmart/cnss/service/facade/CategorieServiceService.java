package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.CategorieService;
public interface CategorieServiceService {

public CategorieService save(CategorieService categorieservice); 
public List<CategorieService>  findAll();
public CategorieService findById(Long id);
public int delete(CategorieService categorieservice);
public void  deleteById(Long id);
public void clone(CategorieService categorieservice,CategorieService categorieserviceClone);
public CategorieService clone(CategorieService categorieservice);
public List<CategorieService> clone(List<CategorieService>categorieservices);
 public List<CategorieService>  findByCriteria(String libelle,Long idMin,Long idMax);

}
