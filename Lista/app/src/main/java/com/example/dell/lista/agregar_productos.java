package com.example.dell.lista;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class agregar_productos extends ActionBarActivity {
    Spinner spinner;

    ArrayAdapter <CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_productos);

        spinner=(Spinner) findViewById(R.id.sp_categoria);


        adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Lacteos");
        adapter.add("Carnes rojas");
        adapter.add("Carnes blancas");
        adapter.add("Jugos");
        adapter.add("Refrescos");
        adapter.add("Dulces");
        adapter.add("Verduras");
        adapter.add("Frutas");
        adapter.add("Semilla");
        adapter.add("Agua");

        spinner.setAdapter(adapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agregar_productos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
