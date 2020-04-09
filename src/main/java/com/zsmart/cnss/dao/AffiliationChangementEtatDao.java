package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.AffiliationChangementEtat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliationChangementEtatDao extends JpaRepository<AffiliationChangementEtat, Long> {

    public AffiliationChangementEtat findByReference(String reference);

    public int deleteByReference(String reference);

}
