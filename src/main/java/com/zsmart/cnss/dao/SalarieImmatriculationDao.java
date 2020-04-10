package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.bean.ImmatriculationDemande;
import com.zsmart.cnss.bean.SalarieImmatriculation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface SalarieImmatriculationDao extends JpaRepository<SalarieImmatriculation,Long> {


	 public SalarieImmatriculation findBySalarie(Salarie salarie);
	 public SalarieImmatriculation findByImmatriculationDemande(ImmatriculationDemande immatriculationDemande);

	 public int deleteBySalarie(Salarie salarie);
	 public int deleteByImmatriculationDemande(ImmatriculationDemande immatriculationDemande);

}
