package com.exemplo.gavin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gavin.aplicacaosiga.DBSQLite;
import com.exemplo.gavin.Model.ModelApiario;
import com.exemplo.gavin.Model.ModelCliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gavin on 09/05/2015.
 */
public class DaoCliente {
    private static String table_name = "CLIENTE";

    private static Context ctx;
    private static String[] columns = {"ID_CLIENTE", "NOME", "CPF","ENDERECO","BAIRRO","CIDADE"};

    public DaoCliente(Context ctx) {
        this.ctx=ctx;
    }

    public void inserirCliente(ModelCliente clienteModel){
        SQLiteDatabase db = new DBSQLite(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("NOME",clienteModel.getNOME());
        ctv.put("CPF",clienteModel.getCPF());
        ctv.put("ENDERECO",clienteModel.getENDERECO());
        ctv.put("BAIRRO",clienteModel.getBAIRRO());
        ctv.put("CIDADE",clienteModel.getCIDADE());


         db.insert(table_name,null,ctv);


    }

    public boolean deleteCliente(ModelCliente clienteModel){

        SQLiteDatabase db = new DBSQLite(ctx).getWritableDatabase();
        return (db.delete(table_name,"ID_CLIENTE=?",new String[]{clienteModel.getID_CLIENTE().toString()})>0);
    }

    public boolean alterarCliente(ModelCliente clienteModel){
        SQLiteDatabase db = new DBSQLite(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("nome", clienteModel.getNOME());
        ctv.put("cpf", clienteModel.getCPF());
        ctv.put("endereco", clienteModel.getENDERECO());
        ctv.put("bairro", clienteModel.getBAIRRO());
        ctv.put("cidade", clienteModel.getCIDADE());


        return (db.update(table_name,ctv,"ID_CLIENTE=?", new String[]{clienteModel.getID_CLIENTE().toString()})>0);

    }

    public ModelCliente pesquisaClientePorID(Integer id_cliente){
        ModelCliente Mo = new ModelCliente();
        SQLiteDatabase db = new DBSQLite(ctx).getReadableDatabase();

        Cursor rs = db.query(table_name,columns,"ID_CLIENTE=?",new String[]{id_cliente.toString()},null,null,"ID_CLIENTE");
        if(rs.moveToNext()){
            Mo.setID_CLIENTE(rs.getInt(rs.getColumnIndex("ID_CLIENTE")));
            Mo.setNOME(rs.getString(rs.getColumnIndex("NOME")));
            Mo.setCPF(rs.getLong(rs.getColumnIndex("CPF")));
            Mo.setENDERECO(rs.getString(rs.getColumnIndex("ENDERECO")));
            Mo.setBAIRRO(rs.getString(rs.getColumnIndex("BAIRRO")));
            Mo.setCIDADE(rs.getString(rs.getColumnIndex("CIDADE")));
        }
        return Mo;
    }


    public List<ModelCliente> ListaCliente(){
        SQLiteDatabase db = new DBSQLite(ctx).getReadableDatabase();
        //Cursor rs = db.rawQuery("SELECT * FROM CLIENTE",null);
        List<ModelCliente> lista = new ArrayList<ModelCliente>();
        Cursor rs = db.query(true,table_name,null,null,null,null,null,"NOME",null,null);

        while(rs.moveToNext()){
            //ModelCliente Mo = new ModelCliente(rs.getInt(0),rs.getString(1),rs.getLong(2),rs.getString(3),rs.getString(4),rs.getString(5));
            ModelCliente Mo = new ModelCliente();
            Mo.setID_CLIENTE(rs.getInt(rs.getColumnIndex("ID_CLIENTE")));
            Mo.setNOME(rs.getString(rs.getColumnIndex("NOME")));
            Mo.setENDERECO(rs.getString(rs.getColumnIndex("ENDERECO")));
            Mo.setBAIRRO(rs.getString(rs.getColumnIndex("BAIRRO")));
            Mo.setCIDADE(rs.getString(rs.getColumnIndex("CIDADE")));
            lista.add(Mo);

        }


        return lista;
    }

    public void RemoverCliente(Integer IdCliente){
        SQLiteDatabase db = new DBSQLite(ctx).getWritableDatabase();

        db.delete(table_name,"ID_CLIENTE=?",new String[]{IdCliente.toString()});
    }
}
