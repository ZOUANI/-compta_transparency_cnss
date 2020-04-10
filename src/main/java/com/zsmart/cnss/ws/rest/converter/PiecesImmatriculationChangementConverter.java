package com.zsmart.cnss.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.cnss.service.util.*;
import com.zsmart.cnss.bean.PiecesImmatriculationChangement;
import com.zsmart.cnss.ws.rest.vo.PiecesImmatriculationChangementVo;

@Component
public class PiecesImmatriculationChangementConverter
		extends AbstractConverter<PiecesImmatriculationChangement, PiecesImmatriculationChangementVo> {

	private boolean piecesObjetChangement;

	@Autowired
	private PiecesObjetChangementConverter piecesObjetChangementConverter;
	private boolean immatriculationChangement;

	@Autowired
	private ImmatriculationChangementConverter immatriculationChangementConverter;

	@Override
	public PiecesImmatriculationChangement toItem(PiecesImmatriculationChangementVo vo) {
		if (vo == null) {
			return null;
		} else {
			PiecesImmatriculationChangement item = new PiecesImmatriculationChangement();

			if (piecesObjetChangement && vo.getPiecesObjetChangementVo() != null) {
				item.setPiecesObjetChangement(piecesObjetChangementConverter.toItem(vo.getPiecesObjetChangementVo()));
			}

			if (immatriculationChangement && vo.getImmatriculationChangementVo() != null) {
				item.setImmatriculationChangement(
						immatriculationChangementConverter.toItem(vo.getImmatriculationChangementVo()));
			}

			if (vo.getId() != null) {
				item.setId(NumberUtil.toLong(vo.getId()));
			}

			if (vo.getNombreFourni() != null) {
				item.setNombreFourni(NumberUtil.toInt(vo.getNombreFourni()));
			}

			return item;
		}
	}

	@Override
	public PiecesImmatriculationChangementVo toVo(PiecesImmatriculationChangement item) {
		if (item == null) {
			return null;
		} else {
			PiecesImmatriculationChangementVo vo = new PiecesImmatriculationChangementVo();

			if (piecesObjetChangement && item.getPiecesObjetChangement() != null) {
				vo.setPiecesObjetChangementVo(piecesObjetChangementConverter.toVo(item.getPiecesObjetChangement()));
			}

			if (immatriculationChangement && item.getImmatriculationChangement() != null) {
				vo.setImmatriculationChangementVo(
						immatriculationChangementConverter.toVo(item.getImmatriculationChangement()));
			}

			if (item.getId() != null) {
				vo.setId(NumberUtil.toString(item.getId()));
			}

			if (item.getNombreFourni() != null) {
				vo.setNombreFourni(NumberUtil.toString(item.getNombreFourni()));
			}

			return vo;
		}
	}

	public void init() {

		piecesObjetChangement = true;

		immatriculationChangement = true;
	}
}
