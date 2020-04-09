package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.AffiliationChangement;
import com.zsmart.cnss.bean.TypeDemande;

public interface AffiliationChangementService {

    public AffiliationChangement save(AffiliationChangement affiliationchangement);

    public AffiliationChangement saveWithObjetChangementAffiliations(AffiliationChangement affiliationchangement);

    public AffiliationChangement saveWithPiecesDemandeChangements(AffiliationChangement affiliationchangement);

    public List<AffiliationChangement> findAll();

    public AffiliationChangement findById(Long id);

    public int delete(AffiliationChangement affiliationchangement);

    public void deleteById(Long id);

    public void clone(AffiliationChangement affiliationchangement, AffiliationChangement affiliationchangementClone);

    public AffiliationChangement clone(AffiliationChangement affiliationchangement);

    public List<AffiliationChangement> clone(List<AffiliationChangement> affiliationchangements);

    public List<AffiliationChangement> findByCriteria(String numAffiliation, String description, Long idMin, Long idMax, Date dateChangementAffiliationMin, Date dateChangementAffiliationMax);

}
