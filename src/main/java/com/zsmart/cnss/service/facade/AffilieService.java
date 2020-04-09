package com.zsmart.cnss.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.zsmart.cnss.bean.Affilie;
import com.zsmart.cnss.bean.FormeJuridque;
import com.zsmart.cnss.bean.Ville;

public interface AffilieService {

    public Affilie save(Affilie affilie);

    public List<Affilie> findAll();

    public Affilie findById(Long id);

    public int delete(Affilie affilie);

    public void deleteById(Long id);

    public void clone(Affilie affilie, Affilie affilieClone);

    public Affilie clone(Affilie affilie);

    public List<Affilie> clone(List<Affilie> affilies);

    public List<Affilie> findByCriteria(String raisonSocial, String numTaxePro, String numRegistreComerciale, String idFiscal, String iceSociete, String numAffiliationSocieteMere, String numSalariesEmployes, String datePremierSalarie, String adresseSiegeSocial, String typeSiegeSocial, String commune, String quartie, String codePostal, String numTel, String email, Long idMin, Long idMax);

}
