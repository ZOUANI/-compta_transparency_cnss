package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.ImmatriculationDemande;
import com.zsmart.cnss.bean.Affilie;
import com.zsmart.cnss.bean.ImmatriculationDemandeEtat;

public interface ImmatriculationDemandeService {

    public ImmatriculationDemande save(ImmatriculationDemande immatriculationdemande);

    public ImmatriculationDemande saveWithSalarieImmatriculations(ImmatriculationDemande immatriculationdemande);

    public List<ImmatriculationDemande> findAll();

    public ImmatriculationDemande findById(Long id);

    public int delete(ImmatriculationDemande immatriculationdemande);

    public void deleteById(Long id);

    public void clone(ImmatriculationDemande immatriculationdemande, ImmatriculationDemande immatriculationdemandeClone);

    public ImmatriculationDemande clone(ImmatriculationDemande immatriculationdemande);

    public List<ImmatriculationDemande> clone(List<ImmatriculationDemande> immatriculationdemandes);

    public List<ImmatriculationDemande> findByCriteria(String numImmatriculation, Long idMin, Long idMax, Date dateDemandeImmatriculationMin, Date dateDemandeImmatriculationMax);

}
