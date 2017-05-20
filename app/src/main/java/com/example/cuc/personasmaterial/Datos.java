package com.example.cuc.personasmaterial;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Lab Software 1 on 13/05/2017.
 */

public class Datos {
    public static ArrayList<Persona> traerPersonas(Context contexto){
        ArrayList<Persona> personas = new ArrayList<>();

        //Declarar variables
        SQLiteDatabase db;
        String sql, foto, cedula, nombre, apellido;
        Persona p;
        //Abrir conexión de lectura
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Personas";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                cedula = c.getString(1);
                nombre =c.getString(2);
                apellido = c.getString(3);
                p = new Persona(foto,cedula,nombre,apellido);
                personas.add(p);

            }while (c.moveToNext());
        }

        db.close();

        return personas;

    }

    public static Persona buscarPersona(Context contexto, String ced){


        //Declarar variables
        SQLiteDatabase db;
        String sql, foto, cedula, nombre, apellido;
        Persona p=null;
        //Abrir conexión de lectura
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Personas where cedula ='"+ced+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
                foto = c.getString(0);
                cedula = c.getString(1);
                nombre =c.getString(2);
                apellido = c.getString(3);
                p = new Persona(foto,cedula,nombre,apellido);
        }

        db.close();
        return p;
    }

}
