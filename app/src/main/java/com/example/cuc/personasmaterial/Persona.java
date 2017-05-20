package com.example.cuc.personasmaterial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CUC on 20/05/2017.
 */

public class Persona {
    private String foto, cedula, nombre, apellido;

    public Persona(String foto, String cedula, String nombre, String apellido) {
        this.foto = foto;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void guardar(Context contexto){
        SQLiteDatabase db;
        String sql;

        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto, "DBPersonas",null);
        db = aux.getWritableDatabase();

        sql = "INSERT INTO Personas values('"+this.getFoto()+"','"
                +this.getCedula()+"','"
                +this.getNombre()+"','"
                +this.getApellido()+"')";

        db.execSQL(sql);

        db.close();
    }
}
