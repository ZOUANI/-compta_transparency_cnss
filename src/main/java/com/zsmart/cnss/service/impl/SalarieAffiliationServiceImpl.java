package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.SalarieAffiliationService;
import com.zsmart.cnss.dao.SalarieAffiliationDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.SalarieAffiliation;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import org.springframework.stereotype.Service;
import java.util.List;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.service.facade.SalarieService;
import com.zsmart.cnss.bean.AffiliationDemande;
import com.zsmart.cnss.service.facade.AffiliationDemandeService;

@Service

public class SalarieAffiliationServiceImpl implements SalarieAffiliationService {

    @Autowired

    private SalarieAffiliationDao salarieaffiliationDao;

    @Autowired

    private EntityManager entityManager;

    @Autowired

    private SalarieService salarieService;

    @Autowired

    private AffiliationDemandeService affiliationdemandeService;

    @Override
    public SalarieAffiliation save(SalarieAffiliation salarieaffiliation) {

        if (salarieaffiliation == null) {
            return null;
        } else {
            salarieaffiliationDao.save(salarieaffiliation);
            return salarieaffiliation;
        }
    }

    @Override
    public List< SalarieAffiliation> findAll() {
        return salarieaffiliationDao.findAll();
    }

    @Override
    public SalarieAffiliation findById(Long id) {
        return salarieaffiliationDao.getOne(id);
    }

    @Override
    public int delete(SalarieAffiliation salarieaffiliation) {
        if (salarieaffiliation == null) {
            return -1;
        } else {
            salarieaffiliationDao.delete(salarieaffiliation);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        salarieaffiliationDao.deleteById(id);
    }

    public void clone(SalarieAffiliation salarieaffiliation, SalarieAffiliation salarieaffiliationClone) {
        if (salarieaffiliation != null && salarieaffiliationClone != null) {
            salarieaffiliationClone.setId(salarieaffiliation.getId());
            salarieaffiliationClone.setSalarie(salarieService.clone(salarieaffiliation.getSalarie()));
            salarieaffiliationClone.setAffiliationDemande(affiliationdemandeService.clone(salarieaffiliation.getAffiliationDemande()));
        }
    }

    public SalarieAffiliation clone(SalarieAffiliation salarieaffiliation) {
        if (salarieaffiliation == null) {
            return null;
        } else {
            SalarieAffiliation salarieaffiliationClone = new SalarieAffiliation();
            clone(salarieaffiliation, salarieaffiliationClone);
            return salarieaffiliationClone;
        }
    }

    public List<SalarieAffiliation> clone(List<SalarieAffiliation> salarieaffiliations) {
        if (salarieaffiliations == null) {
            return null;
        } else {
            List<SalarieAffiliation> salarieaffiliationsClone = new ArrayList();
            salarieaffiliations.forEach((salarieaffiliation) -> {
                salarieaffiliationsClone.add(clone(salarieaffiliation));
            });
            return salarieaffiliationsClone;
        }
    }

    @Override
    public List< SalarieAffiliation> findByCriteria(Long idMin, Long idMax) {
        return entityManager.createQuery(constructQuery(idMin, idMax)).getResultList();
    }

    private String constructQuery(Long idMin, Long idMax) {
        String query = "SELECT s FROM SalarieAffiliation s where 1=1 ";
        query += SearchUtil.addConstraintMinMax("s", "id", idMin, idMax);

        return query;
    }
}
