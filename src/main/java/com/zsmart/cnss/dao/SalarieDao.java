package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.TypeSalarie;
import com.zsmart.cnss.bean.Affilie;
import com.zsmart.cnss.bean.ImmatriculationDemande;
import com.zsmart.cnss.bean.Salarie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface SalarieDao extends JpaRepository<Salarie,Long> {


	 public Salarie findByTypeSalarie(TypeSalarie typeSalarie);
	 public Salarie findByDernierAffilie(Affilie dernierAffilie);
	 public Salarie findByImmatriculationDemande(ImmatriculationDemande immatriculationDemande);

	 public int deleteByTypeSalarie(TypeSalarie typeSalarie);
	 public int deleteByDernierAffilie(Affilie dernierAffilie);
	 public int deleteByImmatriculationDemande(ImmatriculationDemande immatriculationDemande);

}
