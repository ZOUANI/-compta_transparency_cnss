package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class SalarieAffiliationVo {

    private String id;
    private SalarieVo salarieVo;
    private AffiliationDemandeVo affiliationDemandeVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SalarieVo getSalarieVo() {
        return salarieVo;
    }

    public void setSalarieVo(SalarieVo salarieVo) {
        this.salarieVo = salarieVo;
    }

    public AffiliationDemandeVo getAffiliationDemandeVo() {
        return affiliationDemandeVo;
    }

    public void setAffiliationDemandeVo(AffiliationDemandeVo affiliationDemandeVo) {
        this.affiliationDemandeVo = affiliationDemandeVo;
    }

}
