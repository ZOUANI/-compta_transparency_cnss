package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.TypeDemande;
import com.zsmart.cnss.bean.AffiliationChangement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface AffiliationChangementDao extends JpaRepository<AffiliationChangement,Long> {


	 public AffiliationChangement findByTypeDemande(TypeDemande typeDemande);

	 public int deleteByTypeDemande(TypeDemande typeDemande);

}
