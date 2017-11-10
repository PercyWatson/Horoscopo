package com.plama.horoscopochino;

import java.io.Serializable;

/**
 * Created by Plama on 09-11-2017.
 */

public class Personas implements Serializable{
    private String nombre;
    private String contrasena;

    public Personas(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
