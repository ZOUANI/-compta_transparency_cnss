package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.LieuActivite;
import com.zsmart.cnss.bean.Ville;
import com.zsmart.cnss.bean.AffiliationDemande;

public interface LieuActiviteService {

    public LieuActivite save(LieuActivite lieuactivite);

    public List<LieuActivite> findAll();

    public LieuActivite findById(Long id);

    public int delete(LieuActivite lieuactivite);

    public void deleteById(Long id);

    public void clone(LieuActivite lieuactivite, LieuActivite lieuactiviteClone);

    public LieuActivite clone(LieuActivite lieuactivite);

    public List<LieuActivite> clone(List<LieuActivite> lieuactivites);

    public List<LieuActivite> findByCriteria(String adresse, String commune, String codePostal, Long idMin, Long idMax);

}
