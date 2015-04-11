package com.example.dell.lista;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fagregar_lista extends Fragment {


    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fagregar_lista, container, false);



        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final DataBaseManager manejador = new DataBaseManager(getActivity());
        final EditText nombre_lista =(EditText)getActivity().findViewById(R.id.et_nombre_lista);

        final Button btn_agregar_lista = (Button)getActivity().findViewById(R.id.btn_agregar_lista);
        btn_agregar_lista.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                new DataBaseManager(getActivity()).insetar_lista(nombre_lista.getText().toString());
                nombre_lista.setText("");


            }
        });
    }

}


