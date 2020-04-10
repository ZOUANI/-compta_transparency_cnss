package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.ObjetChangement;
import com.zsmart.cnss.bean.AffiliationChangement;
import com.zsmart.cnss.bean.ObjetChangementAffiliation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ObjetChangementAffiliationDao extends JpaRepository<ObjetChangementAffiliation,Long> {


	 public ObjetChangementAffiliation findByObjetChangement(ObjetChangement objetChangement);
	 public ObjetChangementAffiliation findByAffiliationChangement(AffiliationChangement affiliationChangement);

	 public int deleteByObjetChangement(ObjetChangement objetChangement);
	 public int deleteByAffiliationChangement(AffiliationChangement affiliationChangement);

}
