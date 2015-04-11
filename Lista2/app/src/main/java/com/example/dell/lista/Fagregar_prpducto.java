package com.example.dell.lista;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_spinner_item;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fagregar_prpducto extends Fragment {


    View rootView;
    private DbHelper helper;
    private SQLiteDatabase db;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final List<String> categorias = new ArrayList<String>();
        final List<String> unidades = new ArrayList<String>();
        final List<String> listas = new ArrayList<String>();
        rootView = inflater.inflate(R.layout.fragment_fagregar_prpducto, container, false);

        categorias.add("Lacteos");
        categorias.add("Carnes rojas");
        categorias.add("Carnes blancas");
        categorias.add("Jugos");
        categorias.add("Refrescos");
        categorias.add("Dulces");
        categorias.add("Verduras");
        categorias.add("Frutas");
        categorias.add("Semilla");
        categorias.add("Agua");

        unidades.add("Kilogramos");
        unidades.add("Litros");

        listas.add("Lista1");
        listas.add("Lista2");


        Spinner s = (Spinner) rootView.findViewById(R.id.sp_categoria);
        Spinner s2 = (Spinner) rootView.findViewById(R.id.sp_unidad);
        Spinner s3 = (Spinner) rootView.findViewById(R.id.sp_lista_origen);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categorias);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, unidades);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(dataAdapter2);

        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listas);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(dataAdapter3);

        return rootView;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final DataBaseManager manejador = new DataBaseManager(getActivity());

        final Spinner lista_origen = (Spinner) getActivity().findViewById(R.id.sp_lista_origen);
        final EditText clave = (EditText) getActivity().findViewById(R.id.et_clave);
        final EditText nombre_producto = (EditText) getActivity().findViewById(R.id.et_nombre_producto);
        final Spinner categoria = (Spinner) getActivity().findViewById(R.id.sp_categoria);
        final Spinner unidad = (Spinner) getActivity().findViewById(R.id.sp_unidad);
        final EditText cantidad = (EditText) getActivity().findViewById(R.id.et_cantidad);
        final EditText precio = (EditText) getActivity().findViewById(R.id.et_precio);

        final Button btn_agregar_producto = (Button) getActivity().findViewById(R.id.btn_agregar_producto);



        cantidad.setText("0");
        precio.setText("0");
       final String val0=claves();
        clave.setText(val0);
        btn_agregar_producto.setOnClickListener(new View.OnClickListener() {
        Fagregar_prpducto ap =new Fagregar_prpducto();


            public void onClick(View v) {




                new DataBaseManager(getActivity()).insetar_producto(



                        lista_origen.getSelectedItem().toString(),
                        nombre_producto.getText().toString(),
                        categoria.getSelectedItem().toString(),
                        unidad.getSelectedItem().toString(),
                        Double.parseDouble(cantidad.getText().toString()),
                        Double.parseDouble(precio.getText().toString()),
                        clave.getText().toString());
                        nombre_producto.setText("");
                        clave.setText(claves());
                Toast.makeText (getActivity(),"Tu producto se ha agregado exitosamente",Toast.LENGTH_SHORT).show();


            }

        });
    }
    public String  claves()
    {
        final int  numero_aleatorio=(int)(Math.random () * (1000) + 1);
        final int elegir_letra=(int) (Math.random()*(23)+1);
        final  String [] pr = new String[]{"Ar","Br","Cr","Dr","Er","Fr","Gr","Hr","Ir","Jr","Kr","Lr","Mr","Nr","Or","Pr","Qr","Rr","Sr","Tr","Vr","Wr","Zr"};

       return pr[elegir_letra]+numero_aleatorio;
    }
}

