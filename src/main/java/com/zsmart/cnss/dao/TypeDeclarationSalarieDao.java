package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.TypeDeclarationSalarie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface TypeDeclarationSalarieDao extends JpaRepository<TypeDeclarationSalarie,Long> {




}
