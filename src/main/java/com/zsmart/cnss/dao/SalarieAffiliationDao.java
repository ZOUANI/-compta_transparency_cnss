package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.bean.AffiliationDemande;
import com.zsmart.cnss.bean.SalarieAffiliation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface SalarieAffiliationDao extends JpaRepository<SalarieAffiliation,Long> {


	 public SalarieAffiliation findBySalarie(Salarie salarie);
	 public SalarieAffiliation findByAffiliationDemande(AffiliationDemande affiliationDemande);

	 public int deleteBySalarie(Salarie salarie);
	 public int deleteByAffiliationDemande(AffiliationDemande affiliationDemande);

}
