package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.FormeJuridque;
import com.zsmart.cnss.bean.Ville;
import com.zsmart.cnss.bean.Affilie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffilieDao extends JpaRepository<Affilie, Long> {

    public Affilie findByFormeJuridique(FormeJuridque formeJuridique);

    public Affilie findByVille(Ville ville);

    public int deleteByFormeJuridique(FormeJuridque formeJuridique);

    public int deleteByVille(Ville ville);

}
