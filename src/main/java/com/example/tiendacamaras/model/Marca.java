package com.example.tiendacamaras.model;

public class Marca {

    private String direccion;
    private String nombre;

    public Marca(String nombre, String direccion) {
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Marca() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " " + direccion;
    }
}
