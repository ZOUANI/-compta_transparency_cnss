package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.Ville;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface VilleDao extends JpaRepository<Ville,Long> {




}
