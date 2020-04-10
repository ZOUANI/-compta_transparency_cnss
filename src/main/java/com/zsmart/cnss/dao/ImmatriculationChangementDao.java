package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.TypeChangement;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.bean.ImmatriculationChangementEtat;
import com.zsmart.cnss.bean.ImmatriculationChangement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ImmatriculationChangementDao extends JpaRepository<ImmatriculationChangement,Long> {


	 public ImmatriculationChangement findByTypeChangement(TypeChangement typeChangement);
	 public ImmatriculationChangement findBySalarie(Salarie salarie);
	 public ImmatriculationChangement findByImmatriculationChangementEtat(ImmatriculationChangementEtat immatriculationChangementEtat);

	 public int deleteByTypeChangement(TypeChangement typeChangement);
	 public int deleteBySalarie(Salarie salarie);
	 public int deleteByImmatriculationChangementEtat(ImmatriculationChangementEtat immatriculationChangementEtat);

}
