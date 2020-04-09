package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.Piece;
import com.zsmart.cnss.ws.rest.vo.PieceVo;

@Component
public class PieceConverter extends AbstractConverter<Piece, PieceVo> {

    @Override
    public Piece toItem(PieceVo vo) {
        if (vo == null) {
            return null;
        } else {
            Piece item = new Piece();

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
    public PieceVo toVo(Piece item) {
        if (item == null) {
            return null;
        } else {
            PieceVo vo = new PieceVo();

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
