package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.AffiliationDemande;
import com.zsmart.cnss.ws.rest.vo.AffiliationDemandeVo;

@Component
public class AffiliationDemandeConverter extends AbstractConverter<AffiliationDemande, AffiliationDemandeVo> {

    private boolean affilie;

    @Autowired
    private AffilieConverter affilieConverter;
    private boolean lieuActivites;

    @Autowired
    private LieuActiviteConverter lieuActiviteConverter;
    private boolean salarieAffiliations;

    @Autowired
    private SalarieAffiliationConverter salarieAffiliationConverter;

    @Override
    public AffiliationDemande toItem(AffiliationDemandeVo vo) {
        if (vo == null) {
            return null;
        } else {
            AffiliationDemande item = new AffiliationDemande();

            if (affilie && vo.getAffilieVo() != null) {
                item.setAffilie(affilieConverter.toItem(vo.getAffilieVo()));
            }

            if (StringUtil.isNotEmpty(vo.getReference())) {
                item.setReference(vo.getReference());
            }

            if (vo.getId() != null) {
                item.setId(NumberUtil.toLong(vo.getId()));
            }

            if (vo.getDateDemandeAffiliation() != null) {
                item.setDateDemandeAffiliation(DateUtil.parse(vo.getDateDemandeAffiliation()));
            }

            if (ListUtil.isNotEmpty(vo.getLieuActivitesVo()) && lieuActivites) {
                item.setLieuActivites(lieuActiviteConverter.toItem(vo.getLieuActivitesVo()));
            }

            if (ListUtil.isNotEmpty(vo.getSalarieAffiliationsVo()) && salarieAffiliations) {
                item.setSalarieAffiliations(salarieAffiliationConverter.toItem(vo.getSalarieAffiliationsVo()));
            }

            return item;
        }
    }

    @Override
    public AffiliationDemandeVo toVo(AffiliationDemande item) {
        if (item == null) {
            return null;
        } else {
            AffiliationDemandeVo vo = new AffiliationDemandeVo();

            if (affilie && item.getAffilie() != null) {
                vo.setAffilieVo(affilieConverter.toVo(item.getAffilie()));
            }

            if (StringUtil.isNotEmpty(item.getReference())) {
                vo.setReference(item.getReference());
            }

            if (item.getId() != null) {
                vo.setId(NumberUtil.toString(item.getId()));
            }

            if (item.getDateDemandeAffiliation() != null) {
                vo.setDateDemandeAffiliation(DateUtil.formateDate(item.getDateDemandeAffiliation()));
            }

            if (ListUtil.isNotEmpty(item.getLieuActivites()) && lieuActivites) {
                vo.setLieuActivitesVo(lieuActiviteConverter.toVo(item.getLieuActivites()));
            }

            if (ListUtil.isNotEmpty(item.getSalarieAffiliations()) && salarieAffiliations) {
                vo.setSalarieAffiliationsVo(salarieAffiliationConverter.toVo(item.getSalarieAffiliations()));
            }

            return vo;
        }
    }

    public void init() {

        affilie = true;

        lieuActivites = true;

        salarieAffiliations = true;
    }
}
