package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.ObjetChangementImmatriculation;
import com.zsmart.cnss.ws.rest.vo.ObjetChangementImmatriculationVo;

@Component
public class ObjetChangementImmatriculationConverter extends AbstractConverter<ObjetChangementImmatriculation, ObjetChangementImmatriculationVo> {

    private boolean objetChangement;

    @Autowired
    private ObjetChangementConverter objetChangementConverter;
    private boolean immatriculationChangement;

    @Autowired
    private ImmatriculationChangementConverter immatriculationChangementConverter;

    @Override
    public ObjetChangementImmatriculation toItem(ObjetChangementImmatriculationVo vo) {
        if (vo == null) {
            return null;
        } else {
            ObjetChangementImmatriculation item = new ObjetChangementImmatriculation();

            if (objetChangement && vo.getObjetChangementVo() != null) {
                item.setObjetChangement(objetChangementConverter.toItem(vo.getObjetChangementVo()));
            }

            if (immatriculationChangement && vo.getImmatriculationChangementVo() != null) {
                item.setImmatriculationChangement(immatriculationChangementConverter.toItem(vo.getImmatriculationChangementVo()));
            }

            if (vo.getId() != null) {
                item.setId(NumberUtil.toLong(vo.getId()));
            }

            return item;
        }
    }

    @Override
    public ObjetChangementImmatriculationVo toVo(ObjetChangementImmatriculation item) {
        if (item == null) {
            return null;
        } else {
            ObjetChangementImmatriculationVo vo = new ObjetChangementImmatriculationVo();

            if (objetChangement && item.getObjetChangement() != null) {
                vo.setObjetChangementVo(objetChangementConverter.toVo(item.getObjetChangement()));
            }

            if (immatriculationChangement && item.getImmatriculationChangement() != null) {
                vo.setImmatriculationChangementVo(immatriculationChangementConverter.toVo(item.getImmatriculationChangement()));
            }

            if (item.getId() != null) {
                vo.setId(NumberUtil.toString(item.getId()));
            }

            return vo;
        }
    }

    public void init() {

        objetChangement = true;

        immatriculationChangement = true;
    }
}
