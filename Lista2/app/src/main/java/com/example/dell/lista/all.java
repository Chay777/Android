package com.example.dell.lista;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class all extends ActionBarActivity  implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private EditText Et_clave, Et_nombre_lista, Et_cantidad, Et_precio,Et_nombre_producto ;
    private Spinner Sp_lista,Sp_categoria, Sp_unidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        Et_clave = (EditText) findViewById(R.id.et_clave);
        Et_nombre_lista= (EditText) findViewById(R.id.et_lista);

        Et_nombre_producto = (EditText) findViewById(R.id.et_nombre_producto);
        Et_cantidad= (EditText) findViewById(R.id.et_cantidad);
        Et_precio = (EditText) findViewById(R.id.et_precio);
        Sp_categoria= (Spinner) findViewById(R.id.sp_categoria);
        Sp_lista=(Spinner) findViewById(R.id.sp_lista);
        Sp_unidad= (Spinner) findViewById(R.id.sp_unidad);






        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab().setText("Listas").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Agregar lista").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Agregar producto").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Comparar productos").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Buscar productos").setTabListener(this);
        actionBar.addTab(tab);




    }
    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nombre_lista = Et_nombre_lista.getText().toString();
        String listas_en_pr=Sp_lista.getSelectedItem().toString();
        String nombre_producto = Et_nombre_producto.getText().toString();
        String clave= Et_clave.getText().toString();
        String categoria = Sp_categoria.getSelectedItem().toString();
        String unidad = Sp_unidad.getSelectedItem().toString();
        Integer cantidad= Integer.parseInt(Et_cantidad.getText().toString());
        Integer precio= Integer.parseInt(Et_precio.getText().toString());


        ContentValues registro = new ContentValues();

        registro.put("nombre_lista", nombre_lista);
        registro.put("list_pert",+);
        registro.put("colegio", colegio);
        registro.put("nromesa", nromesa);
        bd.insert("votantes", null, registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        Toast.makeText(this, "Se cargaron los datos de la persona",
                Toast.LENGTH_SHORT).show();
    }


    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    return new Flistas();
                case 1:
                    return new Fagregar_lista();
                case 2:
                    return new Fagregar_prpducto();
                case 3:
                    return new Fcomparar();
                case 4:
                    return new Fbuscar_productos();
                default:
                    return null;
            }
        }
        public int getCount() {
            return 5;
        }
    }









    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {
        getSupportActionBar().setSelectedNavigationItem(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
