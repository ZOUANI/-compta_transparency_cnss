package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.TypeChangement;

public interface TypeChangementService {

    public TypeChangement save(TypeChangement typechangement);

    public List<TypeChangement> findAll();

    public TypeChangement findById(Long id);

    public int delete(TypeChangement typechangement);

    public void deleteById(Long id);

    public void clone(TypeChangement typechangement, TypeChangement typechangementClone);

    public TypeChangement clone(TypeChangement typechangement);

    public List<TypeChangement> clone(List<TypeChangement> typechangements);

    public List<TypeChangement> findByCriteria(String libelle, Long idMin, Long idMax);

}
