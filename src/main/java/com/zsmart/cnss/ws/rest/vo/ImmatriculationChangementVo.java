package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class ImmatriculationChangementVo {

    private String id;
    private String numAffiliation;
    private String description;
    private String dateChangementImmatriculation;
    private String dateChangementImmatriculationMin;
    private String dateChangementImmatriculationMax;
    private TypeChangementVo typeChangementVo;
    private SalarieVo salarieVo;
    private ImmatriculationChangementEtatVo immatriculationChangementEtatVo;
    private List<ObjetChangementImmatriculationVo> objetChangementImmatriculationsVo;
    private List<PiecesImmatriculationChangementVo> piecesImmatriculationChangementsVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumAffiliation() {
        return numAffiliation;
    }

    public void setNumAffiliation(String numAffiliation) {
        this.numAffiliation = numAffiliation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateChangementImmatriculation() {
        return dateChangementImmatriculation;
    }

    public void setDateChangementImmatriculation(String dateChangementImmatriculation) {
        this.dateChangementImmatriculation = dateChangementImmatriculation;
    }

    public String getDateChangementImmatriculationMin() {
        return dateChangementImmatriculationMin;
    }

    public void setDateChangementImmatriculationMin(String dateChangementImmatriculationMin) {
        this.dateChangementImmatriculationMin = dateChangementImmatriculationMin;
    }

    public String getDateChangementImmatriculationMax() {
        return dateChangementImmatriculationMax;
    }

    public void setDateChangementImmatriculationMax(String dateChangementImmatriculationMax) {
        this.dateChangementImmatriculationMax = dateChangementImmatriculationMax;
    }

    public TypeChangementVo getTypeChangementVo() {
        return typeChangementVo;
    }

    public void setTypeChangementVo(TypeChangementVo typeChangementVo) {
        this.typeChangementVo = typeChangementVo;
    }

    public SalarieVo getSalarieVo() {
        return salarieVo;
    }

    public void setSalarieVo(SalarieVo salarieVo) {
        this.salarieVo = salarieVo;
    }

    public ImmatriculationChangementEtatVo getImmatriculationChangementEtatVo() {
        return immatriculationChangementEtatVo;
    }

    public void setImmatriculationChangementEtatVo(ImmatriculationChangementEtatVo immatriculationChangementEtatVo) {
        this.immatriculationChangementEtatVo = immatriculationChangementEtatVo;
    }

    public List<ObjetChangementImmatriculationVo> getObjetChangementImmatriculationsVo() {
        return objetChangementImmatriculationsVo;
    }

    public void setObjetChangementImmatriculationsVo(List<ObjetChangementImmatriculationVo> objetChangementImmatriculationsVo) {
        this.objetChangementImmatriculationsVo = objetChangementImmatriculationsVo;
    }

    public List<PiecesImmatriculationChangementVo> getPiecesImmatriculationChangementsVo() {
        return piecesImmatriculationChangementsVo;
    }

    public void setPiecesImmatriculationChangementsVo(List<PiecesImmatriculationChangementVo> piecesImmatriculationChangementsVo) {
        this.piecesImmatriculationChangementsVo = piecesImmatriculationChangementsVo;
    }

}
