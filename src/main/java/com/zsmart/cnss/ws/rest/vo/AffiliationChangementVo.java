package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class AffiliationChangementVo {

    private String id;
    private String numAffiliation;
    private String description;
    private String dateChangementAffiliation;
    private String dateChangementAffiliationMin;
    private String dateChangementAffiliationMax;
    private TypeDemandeVo typeDemandeVo;
    private List<ObjetChangementAffiliationVo> objetChangementAffiliationsVo;
    private List<PiecesAffiliationChangementVo> piecesAffiliationChangementsVo;

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

    public String getDateChangementAffiliation() {
        return dateChangementAffiliation;
    }

    public void setDateChangementAffiliation(String dateChangementAffiliation) {
        this.dateChangementAffiliation = dateChangementAffiliation;
    }

    public String getDateChangementAffiliationMin() {
        return dateChangementAffiliationMin;
    }

    public void setDateChangementAffiliationMin(String dateChangementAffiliationMin) {
        this.dateChangementAffiliationMin = dateChangementAffiliationMin;
    }

    public String getDateChangementAffiliationMax() {
        return dateChangementAffiliationMax;
    }

    public void setDateChangementAffiliationMax(String dateChangementAffiliationMax) {
        this.dateChangementAffiliationMax = dateChangementAffiliationMax;
    }

    public TypeDemandeVo getTypeDemandeVo() {
        return typeDemandeVo;
    }

    public void setTypeDemandeVo(TypeDemandeVo typeDemandeVo) {
        this.typeDemandeVo = typeDemandeVo;
    }

    public List<ObjetChangementAffiliationVo> getObjetChangementAffiliationsVo() {
        return objetChangementAffiliationsVo;
    }

    public void setObjetChangementAffiliationsVo(List<ObjetChangementAffiliationVo> objetChangementAffiliationsVo) {
        this.objetChangementAffiliationsVo = objetChangementAffiliationsVo;
    }

    public List<PiecesAffiliationChangementVo> getPiecesAffiliationChangementsVo() {
        return piecesAffiliationChangementsVo;
    }

    public void setPiecesAffiliationChangementsVo(List<PiecesAffiliationChangementVo> piecesAffiliationChangementsVo) {
        this.piecesAffiliationChangementsVo = piecesAffiliationChangementsVo;
    }

}
