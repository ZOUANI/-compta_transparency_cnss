package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.AffiliationDemandeEtat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliationDemandeEtatDao extends JpaRepository<AffiliationDemandeEtat, Long> {

    public AffiliationDemandeEtat findByReference(String reference);

    public int deleteByReference(String reference);

}
