package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.Piece;
import com.zsmart.cnss.bean.ObjetChangement;
import com.zsmart.cnss.bean.PiecesObjetChangement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface PiecesObjetChangementDao extends JpaRepository<PiecesObjetChangement,Long> {


	 public PiecesObjetChangement findByPiece(Piece piece);
	 public PiecesObjetChangement findByObjetChangement(ObjetChangement objetChangement);

	 public int deleteByPiece(Piece piece);
	 public int deleteByObjetChangement(ObjetChangement objetChangement);

}
