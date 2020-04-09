package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.AffiliationChangement;
import com.zsmart.cnss.ws.rest.vo.AffiliationChangementVo;

@Component
public class AffiliationChangementConverter extends AbstractConverter<AffiliationChangement, AffiliationChangementVo> {

    private boolean typeDemande;

    @Autowired
    private TypeDemandeConverter typeDemandeConverter;
    private boolean objetChangementAffiliations;

    @Autowired
    private ObjetChangementAffiliationConverter objetChangementAffiliationConverter;
    private boolean piecesDemandeChangements;

    @Autowired
    private PiecesAffiliationChangementConverter piecesAffiliationChangementConverter;

    @Override
    public AffiliationChangement toItem(AffiliationChangementVo vo) {
        if (vo == null) {
            return null;
        } else {
            AffiliationChangement item = new AffiliationChangement();

            if (typeDemande && vo.getTypeDemandeVo() != null) {
                item.setTypeDemande(typeDemandeConverter.toItem(vo.getTypeDemandeVo()));
            }

            if (StringUtil.isNotEmpty(vo.getNumAffiliation())) {
                item.setNumAffiliation(vo.getNumAffiliation());
            }

            if (StringUtil.isNotEmpty(vo.getDescription())) {
                item.setDescription(vo.getDescription());
            }

            if (vo.getId() != null) {
                item.setId(NumberUtil.toLong(vo.getId()));
            }

            if (vo.getDateChangementAffiliation() != null) {
                item.setDateChangementAffiliation(DateUtil.parse(vo.getDateChangementAffiliation()));
            }

            if (ListUtil.isNotEmpty(vo.getObjetChangementAffiliationsVo()) && objetChangementAffiliations) {
                item.setObjetChangementAffiliations(objetChangementAffiliationConverter.toItem(vo.getObjetChangementAffiliationsVo()));
            }

            if (ListUtil.isNotEmpty(vo.getPiecesAffiliationChangementsVo()) && piecesDemandeChangements) {
                item.setPiecesDemandeChangements(piecesAffiliationChangementConverter.toItem(vo.getPiecesAffiliationChangementsVo()));
            }

            return item;
        }
    }

    @Override
    public AffiliationChangementVo toVo(AffiliationChangement item) {
        if (item == null) {
            return null;
        } else {
            AffiliationChangementVo vo = new AffiliationChangementVo();

            if (typeDemande && item.getTypeDemande() != null) {
                vo.setTypeDemandeVo(typeDemandeConverter.toVo(item.getTypeDemande()));
            }

            if (StringUtil.isNotEmpty(item.getNumAffiliation())) {
                vo.setNumAffiliation(item.getNumAffiliation());
            }

            if (StringUtil.isNotEmpty(item.getDescription())) {
                vo.setDescription(item.getDescription());
            }

            if (item.getId() != null) {
                vo.setId(NumberUtil.toString(item.getId()));
            }

            if (item.getDateChangementAffiliation() != null) {
                vo.setDateChangementAffiliation(DateUtil.formateDate(item.getDateChangementAffiliation()));
            }

            if (ListUtil.isNotEmpty(item.getObjetChangementAffiliations()) && objetChangementAffiliations) {
                vo.setObjetChangementAffiliationsVo(objetChangementAffiliationConverter.toVo(item.getObjetChangementAffiliations()));
            }

            if (ListUtil.isNotEmpty(item.getPiecesDemandeChangements()) && piecesDemandeChangements) {
                vo.setPiecesAffiliationChangementsVo(piecesAffiliationChangementConverter.toVo(item.getPiecesDemandeChangements()));
            }

            return vo;
        }
    }

    public void init() {

        typeDemande = true;

        objetChangementAffiliations = true;

        piecesDemandeChangements = true;
    }
}
