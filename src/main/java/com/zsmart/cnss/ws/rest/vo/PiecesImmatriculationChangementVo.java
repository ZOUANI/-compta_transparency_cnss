package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class PiecesImmatriculationChangementVo {

    private String id;
    private String nombreFourni;
    private String nombreFourniMin;
    private String nombreFourniMax;
    private PiecesObjetChangementVo piecesObjetChangementVo;
    private ImmatriculationChangementVo immatriculationChangementVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreFourni() {
        return nombreFourni;
    }

    public void setNombreFourni(String nombreFourni) {
        this.nombreFourni = nombreFourni;
    }

    public String getNombreFourniMin() {
        return nombreFourniMin;
    }

    public void setNombreFourniMin(String nombreFourniMin) {
        this.nombreFourniMin = nombreFourniMin;
    }

    public String getNombreFourniMax() {
        return nombreFourniMax;
    }

    public void setNombreFourniMax(String nombreFourniMax) {
        this.nombreFourniMax = nombreFourniMax;
    }

    public PiecesObjetChangementVo getPiecesObjetChangementVo() {
        return piecesObjetChangementVo;
    }

    public void setPiecesObjetChangementVo(PiecesObjetChangementVo piecesObjetChangementVo) {
        this.piecesObjetChangementVo = piecesObjetChangementVo;
    }

    public ImmatriculationChangementVo getImmatriculationChangementVo() {
        return immatriculationChangementVo;
    }

    public void setImmatriculationChangementVo(ImmatriculationChangementVo immatriculationChangementVo) {
        this.immatriculationChangementVo = immatriculationChangementVo;
    }

}
