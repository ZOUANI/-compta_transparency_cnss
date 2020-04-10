package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.DeclarationSalarie;
import com.zsmart.cnss.bean.TypeDeclarationSalarie; 
import com.zsmart.cnss.bean.Affilie; 
public interface DeclarationSalarieService {

public DeclarationSalarie save(DeclarationSalarie declarationsalarie); 
public DeclarationSalarie  saveWithDeclarationSalarieItems (DeclarationSalarie declarationsalarie);public List<DeclarationSalarie>  findAll();
public DeclarationSalarie findById(Long id);
public int delete(DeclarationSalarie declarationsalarie);
public void  deleteById(Long id);
public void clone(DeclarationSalarie declarationsalarie,DeclarationSalarie declarationsalarieClone);
public DeclarationSalarie clone(DeclarationSalarie declarationsalarie);
public List<DeclarationSalarie> clone(List<DeclarationSalarie>declarationsalaries);
 public List<DeclarationSalarie>  findByCriteria(Long idMin,Long idMax,int periodeMin,int periodeMax,int anneeMin,int anneeMax,int nombreJoursTravailleMin,int nombreJoursTravailleMax,Date dateDeclarationMin,Date dateDeclarationMax);

}
