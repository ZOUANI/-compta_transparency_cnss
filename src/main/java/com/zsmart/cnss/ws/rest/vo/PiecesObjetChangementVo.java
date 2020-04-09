package com.zsmart.cnss.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;

public class PiecesObjetChangementVo {

    private String id;
    private String numbrePieces;
    private String numbrePiecesMin;
    private String numbrePiecesMax;
    private PieceVo pieceVo;
    private ObjetChangementVo objetChangementVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumbrePieces() {
        return numbrePieces;
    }

    public void setNumbrePieces(String numbrePieces) {
        this.numbrePieces = numbrePieces;
    }

    public String getNumbrePiecesMin() {
        return numbrePiecesMin;
    }

    public void setNumbrePiecesMin(String numbrePiecesMin) {
        this.numbrePiecesMin = numbrePiecesMin;
    }

    public String getNumbrePiecesMax() {
        return numbrePiecesMax;
    }

    public void setNumbrePiecesMax(String numbrePiecesMax) {
        this.numbrePiecesMax = numbrePiecesMax;
    }

    public PieceVo getPieceVo() {
        return pieceVo;
    }

    public void setPieceVo(PieceVo pieceVo) {
        this.pieceVo = pieceVo;
    }

    public ObjetChangementVo getObjetChangementVo() {
        return objetChangementVo;
    }

    public void setObjetChangementVo(ObjetChangementVo objetChangementVo) {
        this.objetChangementVo = objetChangementVo;
    }

}
