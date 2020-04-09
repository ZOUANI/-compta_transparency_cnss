package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.AffiliationChangementEtat;

public interface AffiliationChangementEtatService {

    public AffiliationChangementEtat save(AffiliationChangementEtat affiliationchangementetat);

    public List<AffiliationChangementEtat> findAll();

    public AffiliationChangementEtat findById(Long id);

    public AffiliationChangementEtat findByReference(String reference);

    public int delete(AffiliationChangementEtat affiliationchangementetat);

    public void deleteById(Long id);

    public void deleteByReference(String reference);

    public void clone(AffiliationChangementEtat affiliationchangementetat, AffiliationChangementEtat affiliationchangementetatClone);

    public AffiliationChangementEtat clone(AffiliationChangementEtat affiliationchangementetat);

    public List<AffiliationChangementEtat> clone(List<AffiliationChangementEtat> affiliationchangementetats);

    public List<AffiliationChangementEtat> findByCriteria(String libelle, String reference, Long idMin, Long idMax);

}
