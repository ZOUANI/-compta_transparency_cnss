package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.PiecesObjetChangement;
import com.zsmart.cnss.bean.ImmatriculationChangement;
import com.zsmart.cnss.bean.PiecesImmatriculationChangement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface PiecesImmatriculationChangementDao extends JpaRepository<PiecesImmatriculationChangement,Long> {


	 public PiecesImmatriculationChangement findByPiecesObjetChangement(PiecesObjetChangement piecesObjetChangement);
	 public PiecesImmatriculationChangement findByImmatriculationChangement(ImmatriculationChangement immatriculationChangement);

	 public int deleteByPiecesObjetChangement(PiecesObjetChangement piecesObjetChangement);
	 public int deleteByImmatriculationChangement(ImmatriculationChangement immatriculationChangement);

}
