package com.edvidarez.tarea1;

/**
 * Created by edvidarez on 2/2/18.
 */

public class Alumno {
    String nombre;
    String telefono;
    String escolaridad;
    int escolaridad_index;
    boolean male;
    String librofavorito;
    int libro_index;
    boolean deporte;
    public Alumno(String nombre,String telefono, String escolaridad, int escolaridad_index, boolean male, String librofavorito, int libro_index, boolean deporte){
        this.nombre = nombre;
        this.telefono = telefono;
        this.escolaridad = escolaridad;
        this.escolaridad_index = escolaridad_index;
        this.male = male;
        this.librofavorito = librofavorito;
        this.libro_index = libro_index;
        this.deporte = deporte;
    }
}
