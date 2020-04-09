package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.TypeChangement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeChangementDao extends JpaRepository<TypeChangement, Long> {

}
