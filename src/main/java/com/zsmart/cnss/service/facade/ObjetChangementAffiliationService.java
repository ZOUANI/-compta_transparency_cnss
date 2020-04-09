package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.ObjetChangementAffiliation;
import com.zsmart.cnss.bean.ObjetChangement;
import com.zsmart.cnss.bean.AffiliationChangement;

public interface ObjetChangementAffiliationService {

    public ObjetChangementAffiliation save(ObjetChangementAffiliation objetchangementaffiliation);

    public List<ObjetChangementAffiliation> findAll();

    public ObjetChangementAffiliation findById(Long id);

    public int delete(ObjetChangementAffiliation objetchangementaffiliation);

    public void deleteById(Long id);

    public void clone(ObjetChangementAffiliation objetchangementaffiliation, ObjetChangementAffiliation objetchangementaffiliationClone);

    public ObjetChangementAffiliation clone(ObjetChangementAffiliation objetchangementaffiliation);

    public List<ObjetChangementAffiliation> clone(List<ObjetChangementAffiliation> objetchangementaffiliations);

    public List<ObjetChangementAffiliation> findByCriteria(Long idMin, Long idMax);

}
