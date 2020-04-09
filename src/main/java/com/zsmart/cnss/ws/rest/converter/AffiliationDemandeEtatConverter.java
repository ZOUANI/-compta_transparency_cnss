package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.AffiliationDemandeEtat;
import com.zsmart.cnss.ws.rest.vo.AffiliationDemandeEtatVo;

@Component
public class AffiliationDemandeEtatConverter extends AbstractConverter<AffiliationDemandeEtat, AffiliationDemandeEtatVo> {

    @Override
    public AffiliationDemandeEtat toItem(AffiliationDemandeEtatVo vo) {
        if (vo == null) {
            return null;
        } else {
            AffiliationDemandeEtat item = new AffiliationDemandeEtat();

            if (StringUtil.isNotEmpty(vo.getLibelle())) {
                item.setLibelle(vo.getLibelle());
            }

            if (StringUtil.isNotEmpty(vo.getReference())) {
                item.setReference(vo.getReference());
            }

            if (vo.getId() != null) {
                item.setId(NumberUtil.toLong(vo.getId()));
            }

            return item;
        }
    }

    @Override
    public AffiliationDemandeEtatVo toVo(AffiliationDemandeEtat item) {
        if (item == null) {
            return null;
        } else {
            AffiliationDemandeEtatVo vo = new AffiliationDemandeEtatVo();

            if (StringUtil.isNotEmpty(item.getLibelle())) {
                vo.setLibelle(item.getLibelle());
            }

            if (StringUtil.isNotEmpty(item.getReference())) {
                vo.setReference(item.getReference());
            }

            if (item.getId() != null) {
                vo.setId(NumberUtil.toString(item.getId()));
            }

            return vo;
        }
    }

    public void init() {
    }
}
