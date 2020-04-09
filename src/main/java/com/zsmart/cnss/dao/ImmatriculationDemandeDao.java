package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.Affilie;
import com.zsmart.cnss.bean.ImmatriculationDemandeEtat;
import com.zsmart.cnss.bean.ImmatriculationDemande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmatriculationDemandeDao extends JpaRepository<ImmatriculationDemande, Long> {

    public ImmatriculationDemande findByAffilie(Affilie affilie);

    public ImmatriculationDemande findByImmatriculationDemandeEtat(ImmatriculationDemandeEtat immatriculationDemandeEtat);

    public int deleteByAffilie(Affilie affilie);

    public int deleteByImmatriculationDemandeEtat(ImmatriculationDemandeEtat immatriculationDemandeEtat);

}
