package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.ImmatriculationDemandeEtat;
import com.zsmart.cnss.ws.rest.vo.ImmatriculationDemandeEtatVo;

@Component
public class ImmatriculationDemandeEtatConverter extends AbstractConverter<ImmatriculationDemandeEtat, ImmatriculationDemandeEtatVo> {

    @Override
    public ImmatriculationDemandeEtat toItem(ImmatriculationDemandeEtatVo vo) {
        if (vo == null) {
            return null;
        } else {
            ImmatriculationDemandeEtat item = new ImmatriculationDemandeEtat();

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
    public ImmatriculationDemandeEtatVo toVo(ImmatriculationDemandeEtat item) {
        if (item == null) {
            return null;
        } else {
            ImmatriculationDemandeEtatVo vo = new ImmatriculationDemandeEtatVo();

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
