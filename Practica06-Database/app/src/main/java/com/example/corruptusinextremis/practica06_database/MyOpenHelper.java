package com.example.corruptusinextremis.practica06_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CorruptusinExtremis on 11/09/14.
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Practica061";

    public MyOpenHelper(Context contexto){
        super(contexto,DB_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.execSQL("CREATE TABLE Alumno("+
                "idAlumno INT PRIMARY KEY,"+
                "codigo VARCHAR(255),"+
                "nombre VARCHAR(255) NOT NULL,"+
                "apellido VARCHAR(255) NOT NULL,"+
                "telefono VARCHAR(50),"+
                "sexo VARCHAR(15),"+
                "edad TINYINT "+
                ")");*/
        db.execSQL("CREATE TABLE Alumno("+
                "idAlumno INTEGER PRIMARY KEY AUTO_INCREMENT,"+ //0
                "codigo VARCHAR(20) NOT NULL UNIQUE,"+ //1
                "nombre TEXT NOT NULL,"+ //2
                "apellido TEXT NOT NULL,"+ //3
                "telefono TEXT ,"+ //4
                "sexo TEXT ,"+ //5
                "edad VARCHAR(50))"); //6
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Alumno");
        onCreate(db);
    }
}
