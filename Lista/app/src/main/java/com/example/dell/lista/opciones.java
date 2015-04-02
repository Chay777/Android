package com.example.dell.lista;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class opciones extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        View btn_ver_lista= findViewById(R.id.btn_ver_listas);
        btn_ver_lista.setOnClickListener(this);

        View btn_agregar_lista= findViewById(R.id.btn_agregar_lista);
        btn_agregar_lista.setOnClickListener(this);

        View btn_agregar_producto= findViewById(R.id.btn_agregar_producto);
        btn_agregar_producto.setOnClickListener(this);




    }

    public void onClick(View vista)
    {

        if (vista.getId() == findViewById(R.id.btn_ver_listas).getId())

        {

            Intent i = new Intent(this, ver_listas.class);

            startActivity(i);

        }else
            if (vista.getId() == findViewById(R.id.btn_agregar_lista).getId())
                {
                    Intent i = new Intent(this, agregar_listas.class);
                    startActivity(i);
                }else
                        if (vista.getId() == findViewById(R.id.btn_agregar_producto).getId())
                            {
                                Intent i = new Intent(this, agregar_productos.class);
                                startActivity(i);
                            }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
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
