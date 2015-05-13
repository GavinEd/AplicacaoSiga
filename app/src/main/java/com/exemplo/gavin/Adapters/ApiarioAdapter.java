package com.exemplo.gavin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gavin.aplicacaosiga.R;
import com.exemplo.gavin.Model.ModelApiario;

import java.util.List;

/**
 * Created by Gavin on 01/05/2015.
 */
public class ApiarioAdapter extends BaseAdapter {

    private Context ctx;
    private List<ModelApiario> lista;

    public ApiarioAdapter(Context ctx,List<ModelApiario> lista){
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ModelApiario Mo = (ModelApiario) getItem(position);
        LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.activity_listar,null);

        TextView txtID =(TextView) v.findViewById(R.id.txtId);
        txtID.setText(Mo.getID_APIARIO().toString());

        TextView txtNOME =(TextView) v.findViewById(R.id.txtNome);
        txtNOME.setText(Mo.getDESCRICAO());

        return v;
    }
}
