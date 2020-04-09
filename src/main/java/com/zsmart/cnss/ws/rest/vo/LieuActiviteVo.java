package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class LieuActiviteVo {

    private String id;
    private String adresse;
    private String commune;
    private String codePostal;
    private VilleVo villeVo;
    private AffiliationDemandeVo affliationDemandeVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public VilleVo getVilleVo() {
        return villeVo;
    }

    public void setVilleVo(VilleVo villeVo) {
        this.villeVo = villeVo;
    }

    public AffiliationDemandeVo getAffliationDemandeVo() {
        return affliationDemandeVo;
    }

    public void setAffliationDemandeVo(AffiliationDemandeVo affliationDemandeVo) {
        this.affliationDemandeVo = affliationDemandeVo;
    }

}
