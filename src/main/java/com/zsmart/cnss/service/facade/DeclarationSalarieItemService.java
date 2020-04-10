package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.cnss.bean.DeclarationSalarieItem;
import com.zsmart.cnss.bean.Salarie; 
import com.zsmart.cnss.bean.DeclarationSalarie; 
public interface DeclarationSalarieItemService {

public DeclarationSalarieItem save(DeclarationSalarieItem declarationsalarieitem); 
public List<DeclarationSalarieItem>  findAll();
public DeclarationSalarieItem findById(Long id);
public int delete(DeclarationSalarieItem declarationsalarieitem);
public void  deleteById(Long id);
public void clone(DeclarationSalarieItem declarationsalarieitem,DeclarationSalarieItem declarationsalarieitemClone);
public DeclarationSalarieItem clone(DeclarationSalarieItem declarationsalarieitem);
public List<DeclarationSalarieItem> clone(List<DeclarationSalarieItem>declarationsalarieitems);
 public List<DeclarationSalarieItem>  findByCriteria(Long idMin,Long idMax,BigDecimal salaireBrutMin,BigDecimal salaireBrutMax,Date dateDeclarationSalarieMin,Date dateDeclarationSalarieMax);

}
