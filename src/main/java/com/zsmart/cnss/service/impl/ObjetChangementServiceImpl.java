package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.ObjetChangementService;
import com.zsmart.cnss.dao.ObjetChangementDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.ObjetChangement;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ObjetChangementServiceImpl implements ObjetChangementService {

    @Autowired

    private ObjetChangementDao objetchangementDao;

    @Autowired

    private EntityManager entityManager;

    @Override
    public ObjetChangement save(ObjetChangement objetchangement) {

        if (objetchangement == null) {
            return null;
        } else {
            objetchangementDao.save(objetchangement);
            return objetchangement;
        }
    }

    @Override
    public List< ObjetChangement> findAll() {
        return objetchangementDao.findAll();
    }

    @Override
    public ObjetChangement findById(Long id) {
        return objetchangementDao.getOne(id);
    }

    @Override
    public int delete(ObjetChangement objetchangement) {
        if (objetchangement == null) {
            return -1;
        } else {
            objetchangementDao.delete(objetchangement);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        objetchangementDao.deleteById(id);
    }

    public void clone(ObjetChangement objetchangement, ObjetChangement objetchangementClone) {
        if (objetchangement != null && objetchangementClone != null) {
            objetchangementClone.setId(objetchangement.getId());
            objetchangementClone.setLibelle(objetchangement.getLibelle());
        }
    }

    public ObjetChangement clone(ObjetChangement objetchangement) {
        if (objetchangement == null) {
            return null;
        } else {
            ObjetChangement objetchangementClone = new ObjetChangement();
            clone(objetchangement, objetchangementClone);
            return objetchangementClone;
        }
    }

    public List<ObjetChangement> clone(List<ObjetChangement> objetchangements) {
        if (objetchangements == null) {
            return null;
        } else {
            List<ObjetChangement> objetchangementsClone = new ArrayList();
            objetchangements.forEach((objetchangement) -> {
                objetchangementsClone.add(clone(objetchangement));
            });
            return objetchangementsClone;
        }
    }

    @Override
    public List< ObjetChangement> findByCriteria(String libelle, Long idMin, Long idMax) {
        return entityManager.createQuery(constructQuery(libelle, idMin, idMax)).getResultList();
    }

    private String constructQuery(String libelle, Long idMin, Long idMax) {
        String query = "SELECT o FROM ObjetChangement o where 1=1 ";
        query += SearchUtil.addConstraint("o", "libelle", "=", libelle);
        query += SearchUtil.addConstraintMinMax("o", "id", idMin, idMax);

        return query;
    }
}
