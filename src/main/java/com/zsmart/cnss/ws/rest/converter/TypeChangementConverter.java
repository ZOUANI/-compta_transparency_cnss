package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.TypeChangement;
import com.zsmart.cnss.ws.rest.vo.TypeChangementVo;

@Component
public class TypeChangementConverter extends AbstractConverter<TypeChangement, TypeChangementVo> {

    @Override
    public TypeChangement toItem(TypeChangementVo vo) {
        if (vo == null) {
            return null;
        } else {
            TypeChangement item = new TypeChangement();

            if (StringUtil.isNotEmpty(vo.getLibelle())) {
                item.setLibelle(vo.getLibelle());
            }

            if (vo.getId() != null) {
                item.setId(NumberUtil.toLong(vo.getId()));
            }

            return item;
        }
    }

    @Override
    public TypeChangementVo toVo(TypeChangement item) {
        if (item == null) {
            return null;
        } else {
            TypeChangementVo vo = new TypeChangementVo();

            if (StringUtil.isNotEmpty(item.getLibelle())) {
                vo.setLibelle(item.getLibelle());
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
