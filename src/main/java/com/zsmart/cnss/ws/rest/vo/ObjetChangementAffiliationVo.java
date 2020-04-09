package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class ObjetChangementAffiliationVo {

    private String id;
    private ObjetChangementVo objetChangementVo;
    private AffiliationChangementVo affiliationChangementVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjetChangementVo getObjetChangementVo() {
        return objetChangementVo;
    }

    public void setObjetChangementVo(ObjetChangementVo objetChangementVo) {
        this.objetChangementVo = objetChangementVo;
    }

    public AffiliationChangementVo getAffiliationChangementVo() {
        return affiliationChangementVo;
    }

    public void setAffiliationChangementVo(AffiliationChangementVo affiliationChangementVo) {
        this.affiliationChangementVo = affiliationChangementVo;
    }

}
