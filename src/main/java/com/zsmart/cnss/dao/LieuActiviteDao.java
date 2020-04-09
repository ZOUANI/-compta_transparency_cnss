package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.Ville;
import com.zsmart.cnss.bean.AffiliationDemande;
import com.zsmart.cnss.bean.LieuActivite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuActiviteDao extends JpaRepository<LieuActivite, Long> {

    public LieuActivite findByVille(Ville ville);

    public LieuActivite findByAffliationDemande(AffiliationDemande affliationDemande);

    public int deleteByVille(Ville ville);

    public int deleteByAffliationDemande(AffiliationDemande affliationDemande);

}
