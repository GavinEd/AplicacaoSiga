package com.exemplo.gavin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gavin.aplicacaosiga.DBSQLite;
import com.example.gavin.aplicacaosiga.ValidacaoCliente;
import com.exemplo.gavin.Model.ModelApiario;
import com.exemplo.gavin.Model.ModelCliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gavin on 01/05/2015.
 */
public class DaoApiario {

    private static String table_name ="APIARIO";
    private static Context ctx;
    private static String[] columns = {"ID_APIARIO", "DESCRICAO"};

    public DaoApiario(Context ctx){
        this.ctx = ctx;
    }
    public boolean inserirApiario(ModelApiario apiarioModel){
        SQLiteDatabase db = new DBSQLite(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("DESCRICAO",apiarioModel.getDESCRICAO());

        return (db.insert(table_name,null,ctv)>0);
    }

    public boolean deleteApiario(ModelApiario apiarioModel){

       SQLiteDatabase db = new DBSQLite(ctx).getWritableDatabase();
       return (db.delete(table_name,"ID_APIARIO=?",new String[]{apiarioModel.getID_APIARIO().toString()})>0);
    }

    public boolean alterarApiaro(ModelApiario apiarioModel){
        SQLiteDatabase db = new DBSQLite(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("descricao", apiarioModel.getDESCRICAO());

        return (db.update(table_name,ctv,"ID_APIARIO=?", new String[]{apiarioModel.getID_APIARIO().toString()})>0);

    }

    public ModelApiario pesquisaID(Integer id_apiario){
        SQLiteDatabase db = new DBSQLite(ctx).getWritableDatabase();
        Cursor rs = db.query(table_name,columns,"ID_APIARIO=?",new String[]{id_apiario.toString()},null,null,null);

        ModelApiario Mo = null;
        if(rs.moveToFirst()){
            Mo = new ModelApiario();
            Mo.setID_APIARIO(rs.getInt(rs.getColumnIndex("ID_APIARIO")));
            Mo.setDESCRICAO(rs.getString(rs.getColumnIndex("DESCRICAO")));
        }
        return Mo;
    }

    public List<ModelApiario> ListaApiario(){
        SQLiteDatabase db = new DBSQLite(ctx).getReadableDatabase();
        Cursor rs = db.rawQuery("SELECT * FROM APIARIO",null);
        List<ModelApiario> lista = new ArrayList<ModelApiario>();

        while(rs.moveToNext()){
            ModelApiario Mo = new ModelApiario(rs.getInt(0),rs.getString(1));
            lista.add(Mo);

        }
        return lista;
    }


}
