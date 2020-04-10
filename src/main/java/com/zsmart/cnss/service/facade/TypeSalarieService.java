package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.TypeSalarie;
public interface TypeSalarieService {

public TypeSalarie save(TypeSalarie typesalarie); 
public List<TypeSalarie>  findAll();
public TypeSalarie findById(Long id);
public int delete(TypeSalarie typesalarie);
public void  deleteById(Long id);
public void clone(TypeSalarie typesalarie,TypeSalarie typesalarieClone);
public TypeSalarie clone(TypeSalarie typesalarie);
public List<TypeSalarie> clone(List<TypeSalarie>typesalaries);
 public List<TypeSalarie>  findByCriteria(String libelle,Long idMin,Long idMax);

}
