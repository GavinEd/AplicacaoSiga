package com.exemplo.gavin.Model;

import java.io.Serializable;

/**
 * Created by Gavin on 09/05/2015.
 */
public class ModelCliente implements Serializable {

    private static final long serialVersionUID = -4063585427419659013L;



    private Integer ID_CLIENTE;
    private String NOME;
    private Long CPF;
    private String ENDERECO;
    private String BAIRRO;
    private String CIDADE;

    public ModelCliente(){

    }

    public ModelCliente(int id,String nome,Long cpf,String endereco,String bairro,String cidade){
        this.ID_CLIENTE=id;
        this.NOME = nome;
        this.CPF = cpf;
        this.ENDERECO = endereco;
        this.BAIRRO = bairro;
        this.CIDADE = cidade;
    }

    public Integer getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(Integer id_cliente) {
        this.ID_CLIENTE = id_cliente;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    public String getENDERECO() {
        return ENDERECO;
    }

    public void setENDERECO(String ENDERECO) {
        this.ENDERECO = ENDERECO;
    }

    public String getBAIRRO() {
        return BAIRRO;
    }

    public void setBAIRRO(String BAIRRO) {
        this.BAIRRO = BAIRRO;
    }

    public String getCIDADE() {
        return CIDADE;
    }

    public void setCIDADE(String CIDADE) {
        this.CIDADE = CIDADE;
    }
}