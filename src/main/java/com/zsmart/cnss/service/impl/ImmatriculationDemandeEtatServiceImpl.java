package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.ImmatriculationDemandeEtatService;
import com.zsmart.cnss.dao.ImmatriculationDemandeEtatDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.ImmatriculationDemandeEtat;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ImmatriculationDemandeEtatServiceImpl implements ImmatriculationDemandeEtatService {

    @Autowired

    private ImmatriculationDemandeEtatDao immatriculationdemandeetatDao;

    @Autowired

    private EntityManager entityManager;

    @Override
    public ImmatriculationDemandeEtat save(ImmatriculationDemandeEtat immatriculationdemandeetat) {

        if (immatriculationdemandeetat == null) {
            return null;
        } else {
            immatriculationdemandeetatDao.save(immatriculationdemandeetat);
            return immatriculationdemandeetat;
        }
    }

    @Override
    public List< ImmatriculationDemandeEtat> findAll() {
        return immatriculationdemandeetatDao.findAll();
    }

    @Override
    public ImmatriculationDemandeEtat findById(Long id) {
        return immatriculationdemandeetatDao.getOne(id);
    }

    @Override
    public ImmatriculationDemandeEtat findByReference(String reference) {
        return immatriculationdemandeetatDao.findByReference(reference);
    }

    @Override
    public int delete(ImmatriculationDemandeEtat immatriculationdemandeetat) {
        if (immatriculationdemandeetat == null) {
            return -1;
        } else {
            immatriculationdemandeetatDao.delete(immatriculationdemandeetat);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        immatriculationdemandeetatDao.deleteById(id);
    }

    @Override
    public void deleteByReference(String reference) {
        immatriculationdemandeetatDao.deleteByReference(reference);
    }

    public void clone(ImmatriculationDemandeEtat immatriculationdemandeetat, ImmatriculationDemandeEtat immatriculationdemandeetatClone) {
        if (immatriculationdemandeetat != null && immatriculationdemandeetatClone != null) {
            immatriculationdemandeetatClone.setId(immatriculationdemandeetat.getId());
            immatriculationdemandeetatClone.setLibelle(immatriculationdemandeetat.getLibelle());
            immatriculationdemandeetatClone.setReference(immatriculationdemandeetat.getReference());
        }
    }

    public ImmatriculationDemandeEtat clone(ImmatriculationDemandeEtat immatriculationdemandeetat) {
        if (immatriculationdemandeetat == null) {
            return null;
        } else {
            ImmatriculationDemandeEtat immatriculationdemandeetatClone = new ImmatriculationDemandeEtat();
            clone(immatriculationdemandeetat, immatriculationdemandeetatClone);
            return immatriculationdemandeetatClone;
        }
    }

    public List<ImmatriculationDemandeEtat> clone(List<ImmatriculationDemandeEtat> immatriculationdemandeetats) {
        if (immatriculationdemandeetats == null) {
            return null;
        } else {
            List<ImmatriculationDemandeEtat> immatriculationdemandeetatsClone = new ArrayList();
            immatriculationdemandeetats.forEach((immatriculationdemandeetat) -> {
                immatriculationdemandeetatsClone.add(clone(immatriculationdemandeetat));
            });
            return immatriculationdemandeetatsClone;
        }
    }

    @Override
    public List< ImmatriculationDemandeEtat> findByCriteria(String libelle, String reference, Long idMin, Long idMax) {
        return entityManager.createQuery(constructQuery(libelle, reference, idMin, idMax)).getResultList();
    }

    private String constructQuery(String libelle, String reference, Long idMin, Long idMax) {
        String query = "SELECT i FROM ImmatriculationDemandeEtat i where 1=1 ";
        query += SearchUtil.addConstraint("i", "libelle", "=", libelle);
        query += SearchUtil.addConstraint("i", "reference", "=", reference);
        query += SearchUtil.addConstraintMinMax("i", "id", idMin, idMax);

        return query;
    }
}
