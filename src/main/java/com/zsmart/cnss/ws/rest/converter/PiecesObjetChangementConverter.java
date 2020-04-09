package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.PiecesObjetChangement;
import com.zsmart.cnss.ws.rest.vo.PiecesObjetChangementVo;

@Component
public class PiecesObjetChangementConverter extends AbstractConverter<PiecesObjetChangement, PiecesObjetChangementVo> {

    private boolean piece;

    @Autowired
    private PieceConverter pieceConverter;
    private boolean objetChangement;

    @Autowired
    private ObjetChangementConverter objetChangementConverter;

    @Override
    public PiecesObjetChangement toItem(PiecesObjetChangementVo vo) {
        if (vo == null) {
            return null;
        } else {
            PiecesObjetChangement item = new PiecesObjetChangement();

            if (piece && vo.getPieceVo() != null) {
                item.setPiece(pieceConverter.toItem(vo.getPieceVo()));
            }

            if (objetChangement && vo.getObjetChangementVo() != null) {
                item.setObjetChangement(objetChangementConverter.toItem(vo.getObjetChangementVo()));
            }

            if (vo.getId() != null) {
                item.setId(NumberUtil.toLong(vo.getId()));
            }

            if (vo.getNumbrePieces() != null) {
                item.setNumbrePieces(NumberUtil.toInt(vo.getNumbrePieces()));
            }

            return item;
        }
    }

    @Override
    public PiecesObjetChangementVo toVo(PiecesObjetChangement item) {
        if (item == null) {
            return null;
        } else {
            PiecesObjetChangementVo vo = new PiecesObjetChangementVo();

            if (piece && item.getPiece() != null) {
                vo.setPieceVo(pieceConverter.toVo(item.getPiece()));
            }

            if (objetChangement && item.getObjetChangement() != null) {
                vo.setObjetChangementVo(objetChangementConverter.toVo(item.getObjetChangement()));
            }

            if (item.getId() != null) {
                vo.setId(NumberUtil.toString(item.getId()));
            }

            if (item.getNumbrePieces() != null) {
                vo.setNumbrePieces(NumberUtil.toString(item.getNumbrePieces()));
            }

            return vo;
        }
    }

    public void init() {

        piece = true;

        objetChangement = true;
    }
}
