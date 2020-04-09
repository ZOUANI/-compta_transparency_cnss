package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.ImmatriculationChangement;
import com.zsmart.cnss.bean.TypeChangement;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.bean.ImmatriculationChangementEtat;

public interface ImmatriculationChangementService {

    public ImmatriculationChangement save(ImmatriculationChangement immatriculationchangement);

    public ImmatriculationChangement saveWithObjetChangementImmatriculations(ImmatriculationChangement immatriculationchangement);

    public ImmatriculationChangement saveWithPiecesImmatriculationChangements(ImmatriculationChangement immatriculationchangement);

    public List<ImmatriculationChangement> findAll();

    public ImmatriculationChangement findById(Long id);

    public int delete(ImmatriculationChangement immatriculationchangement);

    public void deleteById(Long id);

    public void clone(ImmatriculationChangement immatriculationchangement, ImmatriculationChangement immatriculationchangementClone);

    public ImmatriculationChangement clone(ImmatriculationChangement immatriculationchangement);

    public List<ImmatriculationChangement> clone(List<ImmatriculationChangement> immatriculationchangements);

    public List<ImmatriculationChangement> findByCriteria(String numAffiliation, String description, Long idMin, Long idMax, Date dateChangementImmatriculationMin, Date dateChangementImmatriculationMax);

}
