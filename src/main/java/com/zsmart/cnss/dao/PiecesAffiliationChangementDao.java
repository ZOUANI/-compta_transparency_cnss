package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.PiecesObjetChangement;
import com.zsmart.cnss.bean.AffiliationChangement;
import com.zsmart.cnss.bean.PiecesAffiliationChangement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface PiecesAffiliationChangementDao extends JpaRepository<PiecesAffiliationChangement,Long> {


	 public PiecesAffiliationChangement findByPiecesObjetChangement(PiecesObjetChangement piecesObjetChangement);
	 public PiecesAffiliationChangement findByAffiliationChangement(AffiliationChangement affiliationChangement);

	 public int deleteByPiecesObjetChangement(PiecesObjetChangement piecesObjetChangement);
	 public int deleteByAffiliationChangement(AffiliationChangement affiliationChangement);

}
