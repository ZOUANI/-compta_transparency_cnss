package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.SalarieAffiliation;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.bean.AffiliationDemande;

public interface SalarieAffiliationService {

    public SalarieAffiliation save(SalarieAffiliation salarieaffiliation);

    public List<SalarieAffiliation> findAll();

    public SalarieAffiliation findById(Long id);

    public int delete(SalarieAffiliation salarieaffiliation);

    public void deleteById(Long id);

    public void clone(SalarieAffiliation salarieaffiliation, SalarieAffiliation salarieaffiliationClone);

    public SalarieAffiliation clone(SalarieAffiliation salarieaffiliation);

    public List<SalarieAffiliation> clone(List<SalarieAffiliation> salarieaffiliations);

    public List<SalarieAffiliation> findByCriteria(Long idMin, Long idMax);

}
