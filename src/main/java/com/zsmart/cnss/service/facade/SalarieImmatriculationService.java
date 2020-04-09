package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.SalarieImmatriculation;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.bean.ImmatriculationDemande;

public interface SalarieImmatriculationService {

    public SalarieImmatriculation save(SalarieImmatriculation salarieimmatriculation);

    public List<SalarieImmatriculation> findAll();

    public SalarieImmatriculation findById(Long id);

    public int delete(SalarieImmatriculation salarieimmatriculation);

    public void deleteById(Long id);

    public void clone(SalarieImmatriculation salarieimmatriculation, SalarieImmatriculation salarieimmatriculationClone);

    public SalarieImmatriculation clone(SalarieImmatriculation salarieimmatriculation);

    public List<SalarieImmatriculation> clone(List<SalarieImmatriculation> salarieimmatriculations);

    public List<SalarieImmatriculation> findByCriteria(Long idMin, Long idMax);

}
