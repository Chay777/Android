package com.example.dell.lista;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_spinner_item;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fagregar_prpducto extends Fragment {
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final List<String> categorias=new ArrayList<String>();
        final List<String> unidades=new ArrayList<String>();
        final List<String> listas=new ArrayList<String>();
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
        Spinner s3 = (Spinner) rootView.findViewById(R.id.sp_lista);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, categorias);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, unidades);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(dataAdapter2);

        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, listas);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(dataAdapter3);


        return rootView;


    }



}
