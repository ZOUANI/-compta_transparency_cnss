package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.SalarieImmatriculationService;
import com.zsmart.cnss.dao.SalarieImmatriculationDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.SalarieImmatriculation;
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
import com.zsmart.cnss.bean.ImmatriculationDemande;
import com.zsmart.cnss.service.facade.ImmatriculationDemandeService;

@Service

public class SalarieImmatriculationServiceImpl implements SalarieImmatriculationService {

    @Autowired

    private SalarieImmatriculationDao salarieimmatriculationDao;

    @Autowired

    private EntityManager entityManager;

    @Autowired

    private SalarieService salarieService;

    @Autowired

    private ImmatriculationDemandeService immatriculationdemandeService;

    @Override
    public SalarieImmatriculation save(SalarieImmatriculation salarieimmatriculation) {

        if (salarieimmatriculation == null) {
            return null;
        } else {
            salarieimmatriculationDao.save(salarieimmatriculation);
            return salarieimmatriculation;
        }
    }

    @Override
    public List< SalarieImmatriculation> findAll() {
        return salarieimmatriculationDao.findAll();
    }

    @Override
    public SalarieImmatriculation findById(Long id) {
        return salarieimmatriculationDao.getOne(id);
    }

    @Override
    public int delete(SalarieImmatriculation salarieimmatriculation) {
        if (salarieimmatriculation == null) {
            return -1;
        } else {
            salarieimmatriculationDao.delete(salarieimmatriculation);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        salarieimmatriculationDao.deleteById(id);
    }

    public void clone(SalarieImmatriculation salarieimmatriculation, SalarieImmatriculation salarieimmatriculationClone) {
        if (salarieimmatriculation != null && salarieimmatriculationClone != null) {
            salarieimmatriculationClone.setId(salarieimmatriculation.getId());
            salarieimmatriculationClone.setSalarie(salarieService.clone(salarieimmatriculation.getSalarie()));
            salarieimmatriculationClone.setImmatriculationDemande(immatriculationdemandeService.clone(salarieimmatriculation.getImmatriculationDemande()));
        }
    }

    public SalarieImmatriculation clone(SalarieImmatriculation salarieimmatriculation) {
        if (salarieimmatriculation == null) {
            return null;
        } else {
            SalarieImmatriculation salarieimmatriculationClone = new SalarieImmatriculation();
            clone(salarieimmatriculation, salarieimmatriculationClone);
            return salarieimmatriculationClone;
        }
    }

    public List<SalarieImmatriculation> clone(List<SalarieImmatriculation> salarieimmatriculations) {
        if (salarieimmatriculations == null) {
            return null;
        } else {
            List<SalarieImmatriculation> salarieimmatriculationsClone = new ArrayList();
            salarieimmatriculations.forEach((salarieimmatriculation) -> {
                salarieimmatriculationsClone.add(clone(salarieimmatriculation));
            });
            return salarieimmatriculationsClone;
        }
    }

    @Override
    public List< SalarieImmatriculation> findByCriteria(Long idMin, Long idMax) {
        return entityManager.createQuery(constructQuery(idMin, idMax)).getResultList();
    }

    private String constructQuery(Long idMin, Long idMax) {
        String query = "SELECT s FROM SalarieImmatriculation s where 1=1 ";
        query += SearchUtil.addConstraintMinMax("s", "id", idMin, idMax);

        return query;
    }
}
