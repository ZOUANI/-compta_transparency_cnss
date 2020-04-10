package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.TypeDemande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface TypeDemandeDao extends JpaRepository<TypeDemande,Long> {




}
