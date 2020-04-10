package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.ObjetChangement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ObjetChangementDao extends JpaRepository<ObjetChangement,Long> {




}
