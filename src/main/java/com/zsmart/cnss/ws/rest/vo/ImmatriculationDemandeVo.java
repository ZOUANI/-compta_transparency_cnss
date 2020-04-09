package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class ImmatriculationDemandeVo {

    private String id;
    private String numImmatriculation;
    private String dateDemandeImmatriculation;
    private String dateDemandeImmatriculationMin;
    private String dateDemandeImmatriculationMax;
    private AffilieVo affilieVo;
    private ImmatriculationDemandeEtatVo immatriculationDemandeEtatVo;
    private List<SalarieImmatriculationVo> salarieImmatriculationsVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumImmatriculation() {
        return numImmatriculation;
    }

    public void setNumImmatriculation(String numImmatriculation) {
        this.numImmatriculation = numImmatriculation;
    }

    public String getDateDemandeImmatriculation() {
        return dateDemandeImmatriculation;
    }

    public void setDateDemandeImmatriculation(String dateDemandeImmatriculation) {
        this.dateDemandeImmatriculation = dateDemandeImmatriculation;
    }

    public String getDateDemandeImmatriculationMin() {
        return dateDemandeImmatriculationMin;
    }

    public void setDateDemandeImmatriculationMin(String dateDemandeImmatriculationMin) {
        this.dateDemandeImmatriculationMin = dateDemandeImmatriculationMin;
    }

    public String getDateDemandeImmatriculationMax() {
        return dateDemandeImmatriculationMax;
    }

    public void setDateDemandeImmatriculationMax(String dateDemandeImmatriculationMax) {
        this.dateDemandeImmatriculationMax = dateDemandeImmatriculationMax;
    }

    public AffilieVo getAffilieVo() {
        return affilieVo;
    }

    public void setAffilieVo(AffilieVo affilieVo) {
        this.affilieVo = affilieVo;
    }

    public ImmatriculationDemandeEtatVo getImmatriculationDemandeEtatVo() {
        return immatriculationDemandeEtatVo;
    }

    public void setImmatriculationDemandeEtatVo(ImmatriculationDemandeEtatVo immatriculationDemandeEtatVo) {
        this.immatriculationDemandeEtatVo = immatriculationDemandeEtatVo;
    }

    public List<SalarieImmatriculationVo> getSalarieImmatriculationsVo() {
        return salarieImmatriculationsVo;
    }

    public void setSalarieImmatriculationsVo(List<SalarieImmatriculationVo> salarieImmatriculationsVo) {
        this.salarieImmatriculationsVo = salarieImmatriculationsVo;
    }

}
