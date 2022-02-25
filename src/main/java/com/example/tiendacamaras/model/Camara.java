package com.example.tiendacamaras.model;

import java.util.Arrays;

public class Camara {
    private Marca marca;
    private Modelo modelo;
    private Pelicula[] peliculas;
    private boolean soporte;
    String nombre;

    public Camara(int peliculas) {
        this.peliculas = new Pelicula[peliculas];
    }

    public Camara() {
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

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Pelicula[] peliculas) {
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
        for (int i = 0; i < peliculas.length; i++) {
            if(peliculas[i]==null){
                Pelicula pelicula=new Pelicula(nombre, sencibilidad, formato);
                peliculas[i]=pelicula;
                estado=true;
                break;
            }
        }
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
        return "Camara{" +
                "marcas=" + marca +
                ", modelos=" + modelo +
                ", peliculas=" + Arrays.toString(peliculas) +
                ", soporte=" + soporte +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
