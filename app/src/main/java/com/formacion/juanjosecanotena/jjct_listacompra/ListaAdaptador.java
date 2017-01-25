package com.formacion.juanjosecanotena.jjct_listacompra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by juanjosecanotena on 25/1/17.
 */

public class ListaAdaptador extends ArrayAdapter<String> {


    public ListaAdaptador(Context context , String[] lista ){

        super(context,0,lista);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String item = getItem(position);

        if (convertView==null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila,parent,false);
        }

        TextView tvLista = (TextView)convertView.findViewById(R.id.tvLista);

        TextView tvEstado = (TextView)convertView.findViewById(R.id.tvEstado);

        MainActivity.actualizarEstado(tvEstado,MainActivity.arrEstados[position]);

        tvLista.setText(item);

        return convertView;

    }


}
