package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.AffiliationChangementEtatService;
import com.zsmart.cnss.dao.AffiliationChangementEtatDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.AffiliationChangementEtat;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class AffiliationChangementEtatServiceImpl implements AffiliationChangementEtatService {

    @Autowired

    private AffiliationChangementEtatDao affiliationchangementetatDao;

    @Autowired

    private EntityManager entityManager;

    @Override
    public AffiliationChangementEtat save(AffiliationChangementEtat affiliationchangementetat) {

        if (affiliationchangementetat == null) {
            return null;
        } else {
            affiliationchangementetatDao.save(affiliationchangementetat);
            return affiliationchangementetat;
        }
    }

    @Override
    public List< AffiliationChangementEtat> findAll() {
        return affiliationchangementetatDao.findAll();
    }

    @Override
    public AffiliationChangementEtat findById(Long id) {
        return affiliationchangementetatDao.getOne(id);
    }

    @Override
    public AffiliationChangementEtat findByReference(String reference) {
        return affiliationchangementetatDao.findByReference(reference);
    }

    @Override
    public int delete(AffiliationChangementEtat affiliationchangementetat) {
        if (affiliationchangementetat == null) {
            return -1;
        } else {
            affiliationchangementetatDao.delete(affiliationchangementetat);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        affiliationchangementetatDao.deleteById(id);
    }

    @Override
    public void deleteByReference(String reference) {
        affiliationchangementetatDao.deleteByReference(reference);
    }

    public void clone(AffiliationChangementEtat affiliationchangementetat, AffiliationChangementEtat affiliationchangementetatClone) {
        if (affiliationchangementetat != null && affiliationchangementetatClone != null) {
            affiliationchangementetatClone.setId(affiliationchangementetat.getId());
            affiliationchangementetatClone.setLibelle(affiliationchangementetat.getLibelle());
            affiliationchangementetatClone.setReference(affiliationchangementetat.getReference());
        }
    }

    public AffiliationChangementEtat clone(AffiliationChangementEtat affiliationchangementetat) {
        if (affiliationchangementetat == null) {
            return null;
        } else {
            AffiliationChangementEtat affiliationchangementetatClone = new AffiliationChangementEtat();
            clone(affiliationchangementetat, affiliationchangementetatClone);
            return affiliationchangementetatClone;
        }
    }

    public List<AffiliationChangementEtat> clone(List<AffiliationChangementEtat> affiliationchangementetats) {
        if (affiliationchangementetats == null) {
            return null;
        } else {
            List<AffiliationChangementEtat> affiliationchangementetatsClone = new ArrayList();
            affiliationchangementetats.forEach((affiliationchangementetat) -> {
                affiliationchangementetatsClone.add(clone(affiliationchangementetat));
            });
            return affiliationchangementetatsClone;
        }
    }

    @Override
    public List< AffiliationChangementEtat> findByCriteria(String libelle, String reference, Long idMin, Long idMax) {
        return entityManager.createQuery(constructQuery(libelle, reference, idMin, idMax)).getResultList();
    }

    private String constructQuery(String libelle, String reference, Long idMin, Long idMax) {
        String query = "SELECT a FROM AffiliationChangementEtat a where 1=1 ";
        query += SearchUtil.addConstraint("a", "libelle", "=", libelle);
        query += SearchUtil.addConstraint("a", "reference", "=", reference);
        query += SearchUtil.addConstraintMinMax("a", "id", idMin, idMax);

        return query;
    }
}
