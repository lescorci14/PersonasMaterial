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
        String sql, uuid,urlfoto, cedula, nombre, apellido, idfoto;
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
                uuid = c.getString(0);
                urlfoto=c.getString(1);
                cedula = c.getString(2);
                nombre =c.getString(3);
                apellido = c.getString(4);
                idfoto = c.getString(5);
                p = new Persona(uuid,urlfoto,cedula,nombre,apellido,idfoto);
                personas.add(p);

            }while (c.moveToNext());
        }

        db.close();

        return personas;

    }

    public static Persona buscarPersona(Context contexto, String ced){


        //Declarar variables
        SQLiteDatabase db;
        String sql, uuid,urlfoto, cedula, nombre, apellido,idfoto;
        Persona p=null;
        //Abrir conexión de lectura
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"dbPersonas",null);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Personas where cedula ='"+ced+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){

            uuid = c.getString(0);
            urlfoto=c.getString(1);
            cedula = c.getString(2);
            nombre =c.getString(3);
            apellido = c.getString(4);
            idfoto = c.getString(5);

            p = new Persona(uuid,urlfoto,cedula,nombre,apellido,idfoto);
        }

        db.close();
        return p;
    }

}
