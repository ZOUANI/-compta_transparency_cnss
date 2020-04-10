package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.TypeSalarie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface TypeSalarieDao extends JpaRepository<TypeSalarie,Long> {




}
