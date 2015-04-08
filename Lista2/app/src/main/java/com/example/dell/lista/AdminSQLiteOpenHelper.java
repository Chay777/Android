package com.example.dell.lista;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Listas(id_lista integer autoincrement, nombre_lista text)");
        db.execSQL("create table Productos(list_pert integer, id_producto autoincrement, nombre_producto,categoria, categoria text" +
                "unidad text, cantidad numeric, precio numeric)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Listas");
        db.execSQL("create table Listas(id_lista integer autoincrement, nombre_lista text)");
        db.execSQL("drop table if exists Productos");
        db.execSQL("create table Productos(list_pert integer, id_producto autoincrement, nombre_producto,categoria, categoria text" +
                "unidad text, cantidad numeric, precio numeric)");



    }
}
