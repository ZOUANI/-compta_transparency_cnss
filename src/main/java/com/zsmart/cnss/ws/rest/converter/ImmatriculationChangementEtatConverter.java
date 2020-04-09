package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.ImmatriculationChangementEtat;
import com.zsmart.cnss.ws.rest.vo.ImmatriculationChangementEtatVo;

@Component
public class ImmatriculationChangementEtatConverter extends AbstractConverter<ImmatriculationChangementEtat, ImmatriculationChangementEtatVo> {

    @Override
    public ImmatriculationChangementEtat toItem(ImmatriculationChangementEtatVo vo) {
        if (vo == null) {
            return null;
        } else {
            ImmatriculationChangementEtat item = new ImmatriculationChangementEtat();

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
    public ImmatriculationChangementEtatVo toVo(ImmatriculationChangementEtat item) {
        if (item == null) {
            return null;
        } else {
            ImmatriculationChangementEtatVo vo = new ImmatriculationChangementEtatVo();

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
