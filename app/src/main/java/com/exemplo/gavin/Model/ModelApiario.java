package com.exemplo.gavin.Model;

/**
 * Created by Gavin on 01/05/2015.
 */
public class ModelApiario {
    private Integer ID_APIARIO;
    private String DESCRICAO;

    public ModelApiario(){

    }

    public ModelApiario(int id,String descricao){
        this.ID_APIARIO=id;
        this.DESCRICAO = descricao;
    }

    public Integer getID_APIARIO() {
        return ID_APIARIO;
    }

    public void setID_APIARIO(Integer ID_APIARIO) {
        this.ID_APIARIO = ID_APIARIO;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {

        this.DESCRICAO = DESCRICAO;
    }
}
