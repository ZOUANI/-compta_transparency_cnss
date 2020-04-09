package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.AffiliationChangementEtat;
import com.zsmart.cnss.ws.rest.vo.AffiliationChangementEtatVo;

@Component
public class AffiliationChangementEtatConverter extends AbstractConverter<AffiliationChangementEtat, AffiliationChangementEtatVo> {

    @Override
    public AffiliationChangementEtat toItem(AffiliationChangementEtatVo vo) {
        if (vo == null) {
            return null;
        } else {
            AffiliationChangementEtat item = new AffiliationChangementEtat();

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
    public AffiliationChangementEtatVo toVo(AffiliationChangementEtat item) {
        if (item == null) {
            return null;
        } else {
            AffiliationChangementEtatVo vo = new AffiliationChangementEtatVo();

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
