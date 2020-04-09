package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.ws.rest.vo.SalarieVo;

@Component
public class SalarieConverter extends AbstractConverter<Salarie, SalarieVo> {

    private boolean dernierAffilie;

    @Autowired
    private AffilieConverter affilieConverter;
    private boolean immatriculationDemande;

    @Autowired
    private ImmatriculationDemandeConverter immatriculationDemandeConverter;
    private boolean immatriculationChangements;

    @Autowired
    private ImmatriculationChangementConverter immatriculationChangementConverter;

    @Override
    public Salarie toItem(SalarieVo vo) {
        if (vo == null) {
            return null;
        } else {
            Salarie item = new Salarie();

            if (dernierAffilie && vo.getDernierAffilieVo() != null) {
                item.setDernierAffilie(affilieConverter.toItem(vo.getDernierAffilieVo()));
            }

            if (immatriculationDemande && vo.getImmatriculationDemandeVo() != null) {
                item.setImmatriculationDemande(immatriculationDemandeConverter.toItem(vo.getImmatriculationDemandeVo()));
            }

            if (StringUtil.isNotEmpty(vo.getNom())) {
                item.setNom(vo.getNom());
            }

            if (StringUtil.isNotEmpty(vo.getPrenom())) {
                item.setPrenom(vo.getPrenom());
            }

            if (StringUtil.isNotEmpty(vo.getSexe())) {
                item.setSexe(vo.getSexe());
            }

            if (StringUtil.isNotEmpty(vo.getNationalite())) {
                item.setNationalite(vo.getNationalite());
            }

            if (StringUtil.isNotEmpty(vo.getCin())) {
                item.setCin(vo.getCin());
            }

            if (StringUtil.isNotEmpty(vo.getAdresse())) {
                item.setAdresse(vo.getAdresse());
            }

            if (StringUtil.isNotEmpty(vo.getCodePostal())) {
                item.setCodePostal(vo.getCodePostal());
            }

            if (StringUtil.isNotEmpty(vo.getVille())) {
                item.setVille(vo.getVille());
            }

            if (StringUtil.isNotEmpty(vo.getEmail())) {
                item.setEmail(vo.getEmail());
            }

            if (StringUtil.isNotEmpty(vo.getTelNum())) {
                item.setTelNum(vo.getTelNum());
            }

            if (StringUtil.isNotEmpty(vo.getNumImmatriculation())) {
                item.setNumImmatriculation(vo.getNumImmatriculation());
            }

            if (vo.getId() != null) {
                item.setId(NumberUtil.toLong(vo.getId()));
            }

            if (vo.getDateNaissance() != null) {
                item.setDateNaissance(DateUtil.parse(vo.getDateNaissance()));
            }

            if (ListUtil.isNotEmpty(vo.getImmatriculationChangementsVo()) && immatriculationChangements) {
                item.setImmatriculationChangements(immatriculationChangementConverter.toItem(vo.getImmatriculationChangementsVo()));
            }

            return item;
        }
    }

    @Override
    public SalarieVo toVo(Salarie item) {
        if (item == null) {
            return null;
        } else {
            SalarieVo vo = new SalarieVo();

            if (dernierAffilie && item.getDernierAffilie() != null) {
                vo.setDernierAffilieVo(affilieConverter.toVo(item.getDernierAffilie()));
            }

            if (immatriculationDemande && item.getImmatriculationDemande() != null) {
                vo.setImmatriculationDemandeVo(immatriculationDemandeConverter.toVo(item.getImmatriculationDemande()));
            }

            if (StringUtil.isNotEmpty(item.getNom())) {
                vo.setNom(item.getNom());
            }

            if (StringUtil.isNotEmpty(item.getPrenom())) {
                vo.setPrenom(item.getPrenom());
            }

            if (StringUtil.isNotEmpty(item.getSexe())) {
                vo.setSexe(item.getSexe());
            }

            if (StringUtil.isNotEmpty(item.getNationalite())) {
                vo.setNationalite(item.getNationalite());
            }

            if (StringUtil.isNotEmpty(item.getCin())) {
                vo.setCin(item.getCin());
            }

            if (StringUtil.isNotEmpty(item.getAdresse())) {
                vo.setAdresse(item.getAdresse());
            }

            if (StringUtil.isNotEmpty(item.getCodePostal())) {
                vo.setCodePostal(item.getCodePostal());
            }

            if (StringUtil.isNotEmpty(item.getVille())) {
                vo.setVille(item.getVille());
            }

            if (StringUtil.isNotEmpty(item.getEmail())) {
                vo.setEmail(item.getEmail());
            }

            if (StringUtil.isNotEmpty(item.getTelNum())) {
                vo.setTelNum(item.getTelNum());
            }

            if (StringUtil.isNotEmpty(item.getNumImmatriculation())) {
                vo.setNumImmatriculation(item.getNumImmatriculation());
            }

            if (item.getId() != null) {
                vo.setId(NumberUtil.toString(item.getId()));
            }

            if (item.getDateNaissance() != null) {
                vo.setDateNaissance(DateUtil.formateDate(item.getDateNaissance()));
            }

            if (ListUtil.isNotEmpty(item.getImmatriculationChangements()) && immatriculationChangements) {
                vo.setImmatriculationChangementsVo(immatriculationChangementConverter.toVo(item.getImmatriculationChangements()));
            }

            return vo;
        }
    }

    public void init() {

        dernierAffilie = true;

        immatriculationDemande = true;

        immatriculationChangements = true;
    }
}
