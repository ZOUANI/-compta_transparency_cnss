package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.CategorieService;
import com.zsmart.cnss.ws.rest.vo.CategorieServiceVo;

@Component
public class CategorieServiceConverter extends AbstractConverter<CategorieService, CategorieServiceVo> {

    @Override
    public CategorieService toItem(CategorieServiceVo vo) {
        if (vo == null) {
            return null;
        } else {
            CategorieService item = new CategorieService();

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
    public CategorieServiceVo toVo(CategorieService item) {
        if (item == null) {
            return null;
        } else {
            CategorieServiceVo vo = new CategorieServiceVo();

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
