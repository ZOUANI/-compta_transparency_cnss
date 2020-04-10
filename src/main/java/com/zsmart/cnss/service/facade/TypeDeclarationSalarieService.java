package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.TypeDeclarationSalarie;
public interface TypeDeclarationSalarieService {

public TypeDeclarationSalarie save(TypeDeclarationSalarie typedeclarationsalarie); 
public List<TypeDeclarationSalarie>  findAll();
public TypeDeclarationSalarie findById(Long id);
public int delete(TypeDeclarationSalarie typedeclarationsalarie);
public void  deleteById(Long id);
public void clone(TypeDeclarationSalarie typedeclarationsalarie,TypeDeclarationSalarie typedeclarationsalarieClone);
public TypeDeclarationSalarie clone(TypeDeclarationSalarie typedeclarationsalarie);
public List<TypeDeclarationSalarie> clone(List<TypeDeclarationSalarie>typedeclarationsalaries);
 public List<TypeDeclarationSalarie>  findByCriteria(String libelle,Long idMin,Long idMax);

}
