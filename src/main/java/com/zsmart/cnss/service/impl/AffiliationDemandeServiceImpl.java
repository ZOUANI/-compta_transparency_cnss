package com.zsmart.cnss.service.impl;

import com.zsmart.cnss.service.facade.AffiliationDemandeService;
import com.zsmart.cnss.dao.AffiliationDemandeDao;
import com.zsmart.cnss.service.util.SearchUtil;
import com.zsmart.cnss.bean.AffiliationDemande;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import org.springframework.stereotype.Service;
import java.util.List;
import com.zsmart.cnss.bean.Affilie;
import com.zsmart.cnss.service.facade.AffilieService;
import com.zsmart.cnss.service.facade.LieuActiviteService;
import com.zsmart.cnss.bean.LieuActivite;
import com.zsmart.cnss.service.facade.SalarieAffiliationService;
import com.zsmart.cnss.bean.SalarieAffiliation;

@Service

public class AffiliationDemandeServiceImpl implements AffiliationDemandeService {

    @Autowired

    private AffiliationDemandeDao affiliationdemandeDao;

    @Autowired

    private EntityManager entityManager;

    @Autowired

    private LieuActiviteService lieuactiviteService;

    @Autowired

    private SalarieAffiliationService salarieaffiliationService;

    @Autowired

    private AffilieService affilieService;

    @Override
    public AffiliationDemande save(AffiliationDemande affiliationdemande) {

        if (affiliationdemande == null) {
            return null;
        } else {
            affiliationdemandeDao.save(affiliationdemande);
            return affiliationdemande;
        }
    }

    @Override
    public AffiliationDemande saveWithLieuActivites(AffiliationDemande affiliationdemande) {

        if (affiliationdemande == null) {
            return null;
        } else {
            if (affiliationdemande.getLieuActivites().isEmpty()) {
                return null;
            } else {
                affiliationdemandeDao.save(affiliationdemande);
                for (LieuActivite lieuactivite : affiliationdemande.getLieuActivites()) {
                    lieuactivite.setAffliationDemande(affiliationdemande);
                    lieuactiviteService.save(lieuactivite);
                }
                return affiliationdemande;
            }
        }
    }

    @Override
    public AffiliationDemande saveWithSalarieAffiliations(AffiliationDemande affiliationdemande) {

        if (affiliationdemande == null) {
            return null;
        } else {
            if (affiliationdemande.getSalarieAffiliations().isEmpty()) {
                return null;
            } else {
                affiliationdemandeDao.save(affiliationdemande);
                for (SalarieAffiliation salarieaffiliation : affiliationdemande.getSalarieAffiliations()) {
                    salarieaffiliation.setAffiliationDemande(affiliationdemande);
                    salarieaffiliationService.save(salarieaffiliation);
                }
                return affiliationdemande;
            }
        }
    }

    @Override
    public List< AffiliationDemande> findAll() {
        return affiliationdemandeDao.findAll();
    }

    @Override
    public AffiliationDemande findById(Long id) {
        return affiliationdemandeDao.getOne(id);
    }

    @Override
    public AffiliationDemande findByReference(String reference) {
        return affiliationdemandeDao.findByReference(reference);
    }

    @Override
    public int delete(AffiliationDemande affiliationdemande) {
        if (affiliationdemande == null) {
            return -1;
        } else {
            affiliationdemandeDao.delete(affiliationdemande);
            return 1;
        }
    }

    @Override
    public void deleteById(Long id) {
        affiliationdemandeDao.deleteById(id);
    }

    @Override
    public void deleteByReference(String reference) {
        affiliationdemandeDao.deleteByReference(reference);
    }

    public void clone(AffiliationDemande affiliationdemande, AffiliationDemande affiliationdemandeClone) {
        if (affiliationdemande != null && affiliationdemandeClone != null) {
            affiliationdemandeClone.setId(affiliationdemande.getId());
            affiliationdemandeClone.setReference(affiliationdemande.getReference());
            affiliationdemandeClone.setDateDemandeAffiliation(affiliationdemande.getDateDemandeAffiliation());
            affiliationdemandeClone.setAffilie(affilieService.clone(affiliationdemande.getAffilie()));
            affiliationdemandeClone.setLieuActivites(lieuactiviteService.clone(affiliationdemande.getLieuActivites()));
            affiliationdemandeClone.setSalarieAffiliations(salarieaffiliationService.clone(affiliationdemande.getSalarieAffiliations()));
        }
    }

    public AffiliationDemande clone(AffiliationDemande affiliationdemande) {
        if (affiliationdemande == null) {
            return null;
        } else {
            AffiliationDemande affiliationdemandeClone = new AffiliationDemande();
            clone(affiliationdemande, affiliationdemandeClone);
            return affiliationdemandeClone;
        }
    }

    public List<AffiliationDemande> clone(List<AffiliationDemande> affiliationdemandes) {
        if (affiliationdemandes == null) {
            return null;
        } else {
            List<AffiliationDemande> affiliationdemandesClone = new ArrayList();
            affiliationdemandes.forEach((affiliationdemande) -> {
                affiliationdemandesClone.add(clone(affiliationdemande));
            });
            return affiliationdemandesClone;
        }
    }

    @Override
    public List< AffiliationDemande> findByCriteria(String reference, Long idMin, Long idMax, Date dateDemandeAffiliationMin, Date dateDemandeAffiliationMax) {
        return entityManager.createQuery(constructQuery(reference, idMin, idMax, dateDemandeAffiliationMin, dateDemandeAffiliationMax)).getResultList();
    }

    private String constructQuery(String reference, Long idMin, Long idMax, Date dateDemandeAffiliationMin, Date dateDemandeAffiliationMax) {
        String query = "SELECT a FROM AffiliationDemande a where 1=1 ";
        query += SearchUtil.addConstraint("a", "reference", "=", reference);
        query += SearchUtil.addConstraintMinMax("a", "id", idMin, idMax);
        query += SearchUtil.addConstraintMinMaxDate("a", " dateDemandeAffiliation", dateDemandeAffiliationMin, dateDemandeAffiliationMax);

        return query;
    }
}
