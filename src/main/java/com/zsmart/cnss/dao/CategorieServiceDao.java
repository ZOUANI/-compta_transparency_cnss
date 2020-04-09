package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.CategorieService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieServiceDao extends JpaRepository<CategorieService, Long> {

}
