package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.AffiliationDemande;
import com.zsmart.cnss.bean.Affilie;

public interface AffiliationDemandeService {

    public AffiliationDemande save(AffiliationDemande affiliationdemande);

    public AffiliationDemande saveWithLieuActivites(AffiliationDemande affiliationdemande);

    public AffiliationDemande saveWithSalarieAffiliations(AffiliationDemande affiliationdemande);

    public List<AffiliationDemande> findAll();

    public AffiliationDemande findById(Long id);

    public AffiliationDemande findByReference(String reference);

    public int delete(AffiliationDemande affiliationdemande);

    public void deleteById(Long id);

    public void deleteByReference(String reference);

    public void clone(AffiliationDemande affiliationdemande, AffiliationDemande affiliationdemandeClone);

    public AffiliationDemande clone(AffiliationDemande affiliationdemande);

    public List<AffiliationDemande> clone(List<AffiliationDemande> affiliationdemandes);

    public List<AffiliationDemande> findByCriteria(String reference, Long idMin, Long idMax, Date dateDemandeAffiliationMin, Date dateDemandeAffiliationMax);

}
