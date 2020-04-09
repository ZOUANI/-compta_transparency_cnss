package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.VilleService;
import com.zsmart.cnss.dao.VilleDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class VilleServiceImpl implements VilleService {

    @Autowired

    private VilleDao villeDao;

    @Autowired

    private EntityManager entityManager;

    @Override
    public Ville save(Ville ville) {

        if (ville == null) {
            return null;
        } else {
            villeDao.save(ville);
            return ville;
        }
    }

    @Override
    public List< Ville> findAll() {
        return villeDao.findAll();
    }

    @Override
    public Ville findById(Long id) {
        return villeDao.getOne(id);
    }

    @Override
    public int delete(Ville ville) {
        if (ville == null) {
            return -1;
        } else {
            villeDao.delete(ville);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        villeDao.deleteById(id);
    }

    public void clone(Ville ville, Ville villeClone) {
        if (ville != null && villeClone != null) {
            villeClone.setId(ville.getId());
            villeClone.setLibelle(ville.getLibelle());
        }
    }

    public Ville clone(Ville ville) {
        if (ville == null) {
            return null;
        } else {
            Ville villeClone = new Ville();
            clone(ville, villeClone);
            return villeClone;
        }
    }

    public List<Ville> clone(List<Ville> villes) {
        if (villes == null) {
            return null;
        } else {
            List<Ville> villesClone = new ArrayList();
            villes.forEach((ville) -> {
                villesClone.add(clone(ville));
            });
            return villesClone;
        }
    }

    @Override
    public List< Ville> findByCriteria(String libelle, Long idMin, Long idMax) {
        return entityManager.createQuery(constructQuery(libelle, idMin, idMax)).getResultList();
    }

    private String constructQuery(String libelle, Long idMin, Long idMax) {
        String query = "SELECT v FROM Ville v where 1=1 ";
        query += SearchUtil.addConstraint("v", "libelle", "=", libelle);
        query += SearchUtil.addConstraintMinMax("v", "id", idMin, idMax);

        return query;
    }
}
