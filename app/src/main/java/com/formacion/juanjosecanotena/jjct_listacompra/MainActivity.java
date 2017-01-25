package com.formacion.juanjosecanotena.jjct_listacompra;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String[] lista ;
    public static int[] arrEstados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        lista = getResources().getStringArray(R.array.arrListaCompra);

        arrEstados= new int[lista.length];

        Arrays.fill(arrEstados,0);

        final ListView lvLista = (ListView)findViewById(R.id.lvLista);

        final ListaAdaptador listaAdaptador = new ListaAdaptador(this,lista);

        lvLista.setAdapter(listaAdaptador);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> parent, View v, int position, long id){

                arrEstados[position] = (arrEstados[position]==2)? 0 : arrEstados[position] + 1 ;

                TextView tvEstado = (TextView)v.findViewById(R.id.tvEstado);

                actualizarEstado(tvEstado,arrEstados[position]);

            }
        });
    } //FIN OnCreate

    public static void actualizarEstado(TextView tv, int estado){

        String estadoStr="";
        int color=0;

        switch (estado){
            case 0:
                estadoStr = "NO SELECCIONADO";
                color= Color.GREEN;
                break;
            case 1:
                estadoStr = "SELECCIONADO";
                color=Color.BLUE;
                break;
            case 2:
                estadoStr= "COMPRADO";
                color=Color.RED;
                break;
        }

        tv.setText(estadoStr);
        tv.setTextColor(color);

    } //FIN actualizarEstado

}
