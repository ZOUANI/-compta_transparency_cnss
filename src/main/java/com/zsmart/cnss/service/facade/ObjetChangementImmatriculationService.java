package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.ObjetChangementImmatriculation;
import com.zsmart.cnss.bean.ObjetChangement;
import com.zsmart.cnss.bean.ImmatriculationChangement;

public interface ObjetChangementImmatriculationService {

    public ObjetChangementImmatriculation save(ObjetChangementImmatriculation objetchangementimmatriculation);

    public List<ObjetChangementImmatriculation> findAll();

    public ObjetChangementImmatriculation findById(Long id);

    public int delete(ObjetChangementImmatriculation objetchangementimmatriculation);

    public void deleteById(Long id);

    public void clone(ObjetChangementImmatriculation objetchangementimmatriculation, ObjetChangementImmatriculation objetchangementimmatriculationClone);

    public ObjetChangementImmatriculation clone(ObjetChangementImmatriculation objetchangementimmatriculation);

    public List<ObjetChangementImmatriculation> clone(List<ObjetChangementImmatriculation> objetchangementimmatriculations);

    public List<ObjetChangementImmatriculation> findByCriteria(Long idMin, Long idMax);

}
