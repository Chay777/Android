package com.example.dell.lista;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dell on 09/04/2015.
 */
public class DataBaseManager  {

    public static final String Table_Name_listas = "Listas";
    public static final String Table_Name_productos = "Productos";
//tabla listas
    public static final String columna_ID ="_id";
    public static final String columna_Nombre_lista ="nombre_lista";
//tabla producto
    // *lista origen* la lista en la que se agregara al producto.

    public static final String columna_ID_producto ="_id_producto";
    public static final String columna_nombre_producto ="nombre_producto";
    public static final String columna_lista_origen ="lista_origen";
    public static final String columna_categoria ="categoria";
    public static final String columna_unidad ="unidad";
    public static final String columna_cantidad ="cantidad";
    public static final String columna_precio ="precio";
    public static final String columna_clave ="clave";


        public static final String CREATE_TABLE1 = "create table "+Table_Name_listas+
                " ("+ columna_ID + " integer primary key autoincrement,"
                +columna_Nombre_lista +" text not null);";

        public static final String CREATE_TABLE2= " create table "+Table_Name_productos+
                " ("+ columna_ID_producto + " integer primary key autoincrement,"
                +columna_nombre_producto +" text not null,"
                + columna_lista_origen+" text,"
                + columna_categoria+ " text,"
                + columna_unidad+" text,"
                + columna_cantidad+" numeric not null,"
                + columna_precio+" numeric not null," +
                columna_clave+" text );";
private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context)
    {
        helper=new DbHelper(context);
        db=helper.getWritableDatabase();


    }
    public ContentValues generarvalores_lista(String nombre_de_lista)
    {
        ContentValues valores = new ContentValues();
        valores.put(columna_Nombre_lista,nombre_de_lista);


        return valores;
    }
    public ContentValues generarvalores_producto(String lista_origen,String nombre_producto,String categoria,String unidad,double cantidad,double precio, String clave)
    {
        ContentValues valores = new ContentValues();
        valores.put(columna_lista_origen,lista_origen);
        valores.put(columna_nombre_producto,nombre_producto);
        valores.put(columna_categoria,categoria);
        valores.put(columna_unidad,unidad);
        valores.put(columna_cantidad,cantidad);
        valores.put(columna_precio,precio);
        valores.put(columna_clave,clave);

        return valores;
    }
    public void insetar_lista (String nombre_de_lista)
    {

        db.insert(Table_Name_listas,null,generarvalores_lista(nombre_de_lista));


    }
    public void insetar_producto (String lista_origen,String nombre_producto,String categoria,String unidad,double cantidad,double precio,String clave)
    {

        //db.insert(Table_Name2,null,generarvalores_producto(lista_origen,nombre_producto,categoria,unidad,cantidad,precio));
        db.insert(Table_Name_productos,null,generarvalores_producto(lista_origen,nombre_producto,categoria,unidad,cantidad,precio,clave));


    }







}

