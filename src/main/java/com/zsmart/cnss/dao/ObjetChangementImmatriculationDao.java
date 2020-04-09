package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.ObjetChangement;
import com.zsmart.cnss.bean.ImmatriculationChangement;
import com.zsmart.cnss.bean.ObjetChangementImmatriculation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetChangementImmatriculationDao extends JpaRepository<ObjetChangementImmatriculation, Long> {

    public ObjetChangementImmatriculation findByObjetChangement(ObjetChangement objetChangement);

    public ObjetChangementImmatriculation findByImmatriculationChangement(ImmatriculationChangement immatriculationChangement);

    public int deleteByObjetChangement(ObjetChangement objetChangement);

    public int deleteByImmatriculationChangement(ImmatriculationChangement immatriculationChangement);

}
