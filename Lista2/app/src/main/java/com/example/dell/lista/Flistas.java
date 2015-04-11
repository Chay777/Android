package com.example.dell.lista;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class Flistas extends Fragment {

DbHelper helper;
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_flistas, container, false);
        return rootView;

    }
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        DataBaseManager manejador = new DataBaseManager(getActivity());
        final ListView lista_de_listas = (ListView)getActivity().findViewById(R.id.lista_de_listas);

       







    }
}
