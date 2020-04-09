package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class SalarieImmatriculationVo {

    private String id;
    private SalarieVo salarieVo;
    private ImmatriculationDemandeVo immatriculationDemandeVo;

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

    public ImmatriculationDemandeVo getImmatriculationDemandeVo() {
        return immatriculationDemandeVo;
    }

    public void setImmatriculationDemandeVo(ImmatriculationDemandeVo immatriculationDemandeVo) {
        this.immatriculationDemandeVo = immatriculationDemandeVo;
    }

}
