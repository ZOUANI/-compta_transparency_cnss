package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class ObjetChangementImmatriculationVo {

    private String id;
    private ObjetChangementVo objetChangementVo;
    private ImmatriculationChangementVo immatriculationChangementVo;

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

    public ImmatriculationChangementVo getImmatriculationChangementVo() {
        return immatriculationChangementVo;
    }

    public void setImmatriculationChangementVo(ImmatriculationChangementVo immatriculationChangementVo) {
        this.immatriculationChangementVo = immatriculationChangementVo;
    }

}
