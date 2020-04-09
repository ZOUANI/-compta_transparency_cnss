package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.ObjetChangementImmatriculationService;
import com.zsmart.cnss.dao.ObjetChangementImmatriculationDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.ObjetChangementImmatriculation;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import org.springframework.stereotype.Service;
import java.util.List;
import com.zsmart.cnss.bean.ObjetChangement;
import com.zsmart.cnss.service.facade.ObjetChangementService;
import com.zsmart.cnss.bean.ImmatriculationChangement;
import com.zsmart.cnss.service.facade.ImmatriculationChangementService;

@Service

public class ObjetChangementImmatriculationServiceImpl implements ObjetChangementImmatriculationService {

    @Autowired

    private ObjetChangementImmatriculationDao objetchangementimmatriculationDao;

    @Autowired

    private EntityManager entityManager;

    @Autowired

    private ObjetChangementService objetchangementService;

    @Autowired

    private ImmatriculationChangementService immatriculationchangementService;

    @Override
    public ObjetChangementImmatriculation save(ObjetChangementImmatriculation objetchangementimmatriculation) {

        if (objetchangementimmatriculation == null) {
            return null;
        } else {
            objetchangementimmatriculationDao.save(objetchangementimmatriculation);
            return objetchangementimmatriculation;
        }
    }

    @Override
    public List< ObjetChangementImmatriculation> findAll() {
        return objetchangementimmatriculationDao.findAll();
    }

    @Override
    public ObjetChangementImmatriculation findById(Long id) {
        return objetchangementimmatriculationDao.getOne(id);
    }

    @Override
    public int delete(ObjetChangementImmatriculation objetchangementimmatriculation) {
        if (objetchangementimmatriculation == null) {
            return -1;
        } else {
            objetchangementimmatriculationDao.delete(objetchangementimmatriculation);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        objetchangementimmatriculationDao.deleteById(id);
    }

    public void clone(ObjetChangementImmatriculation objetchangementimmatriculation, ObjetChangementImmatriculation objetchangementimmatriculationClone) {
        if (objetchangementimmatriculation != null && objetchangementimmatriculationClone != null) {
            objetchangementimmatriculationClone.setId(objetchangementimmatriculation.getId());
            objetchangementimmatriculationClone.setObjetChangement(objetchangementService.clone(objetchangementimmatriculation.getObjetChangement()));
            objetchangementimmatriculationClone.setImmatriculationChangement(immatriculationchangementService.clone(objetchangementimmatriculation.getImmatriculationChangement()));
        }
    }

    public ObjetChangementImmatriculation clone(ObjetChangementImmatriculation objetchangementimmatriculation) {
        if (objetchangementimmatriculation == null) {
            return null;
        } else {
            ObjetChangementImmatriculation objetchangementimmatriculationClone = new ObjetChangementImmatriculation();
            clone(objetchangementimmatriculation, objetchangementimmatriculationClone);
            return objetchangementimmatriculationClone;
        }
    }

    public List<ObjetChangementImmatriculation> clone(List<ObjetChangementImmatriculation> objetchangementimmatriculations) {
        if (objetchangementimmatriculations == null) {
            return null;
        } else {
            List<ObjetChangementImmatriculation> objetchangementimmatriculationsClone = new ArrayList();
            objetchangementimmatriculations.forEach((objetchangementimmatriculation) -> {
                objetchangementimmatriculationsClone.add(clone(objetchangementimmatriculation));
            });
            return objetchangementimmatriculationsClone;
        }
    }

    @Override
    public List< ObjetChangementImmatriculation> findByCriteria(Long idMin, Long idMax) {
        return entityManager.createQuery(constructQuery(idMin, idMax)).getResultList();
    }

    private String constructQuery(Long idMin, Long idMax) {
        String query = "SELECT o FROM ObjetChangementImmatriculation o where 1=1 ";
        query += SearchUtil.addConstraintMinMax("o", "id", idMin, idMax);

        return query;
    }
}
