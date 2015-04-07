package com.example.dell.lista02;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;



@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ver_listas extends FragmentActivity implements ActionBar.TabListener {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
         ActionBar.Tab tab1=actionBar.newTab();
         tab1.setText("Listas");
        tab1.setTabListener(this);

        ActionBar.Tab tab2=actionBar.newTab();
        tab2.setText("Agregar lista");
        tab2.setTabListener(this);

        ActionBar.Tab tab3=actionBar.newTab();
        tab3.setText("Agregar producto");
        tab3.setTabListener(this);

        ActionBar.Tab tab4=actionBar.newTab();
        tab4.setText("Comparar");
        tab4.setTabListener(this);

        ActionBar.Tab tab5=actionBar.newTab();
        tab5.setText("Buscar producto");
        tab5.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
        actionBar.addTab(tab4);
        actionBar.addTab(tab5);







    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        Log.d("lista02","onTabSelected at "+"position"+tab.getPosition()+"name"+tab.getText());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.d("lista02","onTabSelected at "+"position"+tab.getPosition()+"name"+tab.getText());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        Log.d("lista02","onTabSelected at "+"position"+tab.getPosition()+"name"+tab.getText());

    }
}
