package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.Affilie;
import com.zsmart.cnss.ws.rest.vo.AffilieVo;

@Component
public class AffilieConverter extends AbstractConverter<Affilie, AffilieVo> {

    private boolean formeJuridique;

    @Autowired
    private FormeJuridqueConverter formeJuridqueConverter;
    private boolean ville;

    @Autowired
    private VilleConverter villeConverter;

    @Override
    public Affilie toItem(AffilieVo vo) {
        if (vo == null) {
            return null;
        } else {
            Affilie item = new Affilie();

            if (formeJuridique && vo.getFormeJuridiqueVo() != null) {
                item.setFormeJuridique(formeJuridqueConverter.toItem(vo.getFormeJuridiqueVo()));
            }

            if (ville && vo.getVilleVo() != null) {
                item.setVille(villeConverter.toItem(vo.getVilleVo()));
            }

            if (StringUtil.isNotEmpty(vo.getRaisonSocial())) {
                item.setRaisonSocial(vo.getRaisonSocial());
            }

            if (StringUtil.isNotEmpty(vo.getNumTaxePro())) {
                item.setNumTaxePro(vo.getNumTaxePro());
            }

            if (StringUtil.isNotEmpty(vo.getNumRegistreComerciale())) {
                item.setNumRegistreComerciale(vo.getNumRegistreComerciale());
            }

            if (StringUtil.isNotEmpty(vo.getIdFiscal())) {
                item.setIdFiscal(vo.getIdFiscal());
            }

            if (StringUtil.isNotEmpty(vo.getIceSociete())) {
                item.setIceSociete(vo.getIceSociete());
            }

            if (StringUtil.isNotEmpty(vo.getNumAffiliationSocieteMere())) {
                item.setNumAffiliationSocieteMere(vo.getNumAffiliationSocieteMere());
            }

            if (StringUtil.isNotEmpty(vo.getNumSalariesEmployes())) {
                item.setNumSalariesEmployes(vo.getNumSalariesEmployes());
            }

            if (StringUtil.isNotEmpty(vo.getDatePremierSalarie())) {
                item.setDatePremierSalarie(vo.getDatePremierSalarie());
            }

            if (StringUtil.isNotEmpty(vo.getAdresseSiegeSocial())) {
                item.setAdresseSiegeSocial(vo.getAdresseSiegeSocial());
            }

            if (StringUtil.isNotEmpty(vo.getTypeSiegeSocial())) {
                item.setTypeSiegeSocial(vo.getTypeSiegeSocial());
            }

            if (StringUtil.isNotEmpty(vo.getCommune())) {
                item.setCommune(vo.getCommune());
            }

            if (StringUtil.isNotEmpty(vo.getQuartie())) {
                item.setQuartie(vo.getQuartie());
            }

            if (StringUtil.isNotEmpty(vo.getCodePostal())) {
                item.setCodePostal(vo.getCodePostal());
            }

            if (StringUtil.isNotEmpty(vo.getNumTel())) {
                item.setNumTel(vo.getNumTel());
            }

            if (StringUtil.isNotEmpty(vo.getEmail())) {
                item.setEmail(vo.getEmail());
            }

            if (vo.getId() != null) {
                item.setId(NumberUtil.toLong(vo.getId()));
            }

            return item;
        }
    }

    @Override
    public AffilieVo toVo(Affilie item) {
        if (item == null) {
            return null;
        } else {
            AffilieVo vo = new AffilieVo();

            if (formeJuridique && item.getFormeJuridique() != null) {
                vo.setFormeJuridiqueVo(formeJuridqueConverter.toVo(item.getFormeJuridique()));
            }

            if (ville && item.getVille() != null) {
                vo.setVilleVo(villeConverter.toVo(item.getVille()));
            }

            if (StringUtil.isNotEmpty(item.getRaisonSocial())) {
                vo.setRaisonSocial(item.getRaisonSocial());
            }

            if (StringUtil.isNotEmpty(item.getNumTaxePro())) {
                vo.setNumTaxePro(item.getNumTaxePro());
            }

            if (StringUtil.isNotEmpty(item.getNumRegistreComerciale())) {
                vo.setNumRegistreComerciale(item.getNumRegistreComerciale());
            }

            if (StringUtil.isNotEmpty(item.getIdFiscal())) {
                vo.setIdFiscal(item.getIdFiscal());
            }

            if (StringUtil.isNotEmpty(item.getIceSociete())) {
                vo.setIceSociete(item.getIceSociete());
            }

            if (StringUtil.isNotEmpty(item.getNumAffiliationSocieteMere())) {
                vo.setNumAffiliationSocieteMere(item.getNumAffiliationSocieteMere());
            }

            if (StringUtil.isNotEmpty(item.getNumSalariesEmployes())) {
                vo.setNumSalariesEmployes(item.getNumSalariesEmployes());
            }

            if (StringUtil.isNotEmpty(item.getDatePremierSalarie())) {
                vo.setDatePremierSalarie(item.getDatePremierSalarie());
            }

            if (StringUtil.isNotEmpty(item.getAdresseSiegeSocial())) {
                vo.setAdresseSiegeSocial(item.getAdresseSiegeSocial());
            }

            if (StringUtil.isNotEmpty(item.getTypeSiegeSocial())) {
                vo.setTypeSiegeSocial(item.getTypeSiegeSocial());
            }

            if (StringUtil.isNotEmpty(item.getCommune())) {
                vo.setCommune(item.getCommune());
            }

            if (StringUtil.isNotEmpty(item.getQuartie())) {
                vo.setQuartie(item.getQuartie());
            }

            if (StringUtil.isNotEmpty(item.getCodePostal())) {
                vo.setCodePostal(item.getCodePostal());
            }

            if (StringUtil.isNotEmpty(item.getNumTel())) {
                vo.setNumTel(item.getNumTel());
            }

            if (StringUtil.isNotEmpty(item.getEmail())) {
                vo.setEmail(item.getEmail());
            }

            if (item.getId() != null) {
                vo.setId(NumberUtil.toString(item.getId()));
            }

            return vo;
        }
    }

    public void init() {

        formeJuridique = true;

        ville = true;
    }
}
