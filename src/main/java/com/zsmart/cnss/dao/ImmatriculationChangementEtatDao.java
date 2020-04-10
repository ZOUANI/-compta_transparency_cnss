package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.ImmatriculationChangementEtat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ImmatriculationChangementEtatDao extends JpaRepository<ImmatriculationChangementEtat,Long> {
	 public ImmatriculationChangementEtat findByReference(String reference);

	 public int deleteByReference(String reference);



}
