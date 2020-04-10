package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.ImmatriculationDemandeEtat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ImmatriculationDemandeEtatDao extends JpaRepository<ImmatriculationDemandeEtat,Long> {
	 public ImmatriculationDemandeEtat findByReference(String reference);

	 public int deleteByReference(String reference);



}
