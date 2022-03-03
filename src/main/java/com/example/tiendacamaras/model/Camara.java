package com.example.tiendacamaras.model;

import java.util.ArrayList;

public class Camara {
    private Marca marca;
    private Modelo modelo;
    private ArrayList peliculas;
    private boolean soporte;
    String nombre;

    public Camara(String nombre) {
        this.nombre = nombre;
        this.peliculas = new ArrayList();
    }

    public Camara() {
        this.peliculas = new ArrayList();
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelos) {
        this.modelo = modelo;
    }

    public ArrayList getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList peliculas) {
        this.peliculas = peliculas;
    }

    public boolean isSoporte() {
        return soporte;
    }

    public void setSoporte(boolean soporte) {
        this.soporte = soporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean asignarPelicula(String nombre, String sencibilidad, String formato) {
        boolean estado = false;
        this.peliculas.add(new Pelicula(nombre, sencibilidad, formato));
        estado = true;
        return estado;
    }

    public boolean asignarMarca(Marca marca) {
        boolean estado = false;
        this.marca=marca;
        estado = true;
        return estado;
    }

    public boolean asignarModelo(Modelo modelo) {
        boolean estado = false;
        this.modelo=modelo;
        estado = true;
        return estado;
    }

    @Override
    public String toString() {
        return "marcas " + marca +
                "\nmodelos " + modelo +
                "\npeliculas " + peliculas +
                "\nsoporte " + soporte +
                "\nnombre " + nombre;
    }
}
