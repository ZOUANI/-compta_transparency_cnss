package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.Affilie;
import com.zsmart.cnss.bean.AffiliationDemande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliationDemandeDao extends JpaRepository<AffiliationDemande, Long> {

    public AffiliationDemande findByReference(String reference);

    public int deleteByReference(String reference);

    public AffiliationDemande findByAffilie(Affilie affilie);

    public int deleteByAffilie(Affilie affilie);

}
