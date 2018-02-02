package com.edvidarez.tarea1;

/**
 * Created by edvidarez on 2/2/18.
 */

public class Alumno {
    String nombre;
    String telefono;
    String escolaridad;
    boolean male;
    String librofavorito;
    boolean deporte;
    public Alumno(String nombre,String telefono, String escolaridad, boolean male, String librofavorito, boolean deporte){
        this.nombre = nombre;
        this.telefono = telefono;
        this.escolaridad = escolaridad;
        this.male = male;
        this.librofavorito = librofavorito;
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        String res = "";
        res += "Nombre: "+nombre+"\n";
        res += "Telefono: "+telefono+"\n";
        res += "Escolaridad: "+escolaridad+"\n";
        String genero = (male)?"Masculino":"Femenino";
        res += "Género: "+genero+"\n";
        res += "Libro favorito: "+librofavorito+"\n";
        if(deporte)
            res += "Practica Deporte \n";
        return res;
    }
}
