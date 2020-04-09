package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.FormeJuridque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormeJuridqueDao extends JpaRepository<FormeJuridque, Long> {

}
