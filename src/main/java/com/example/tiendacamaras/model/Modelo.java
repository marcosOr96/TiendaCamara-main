package com.example.tiendacamaras.model;

import java.util.Arrays;

public class Modelo {

    private String nombre;

    private Item[] items;

    public Modelo(String nombre) {
        this.nombre = nombre;
    }

    public Modelo(int items) {
        this.items=new Item[items];
    }

    public Modelo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public boolean asignarItem(Item item) {
        boolean estado = false;
        for (int i = 0; i < items.length; i++) {
            items[i] = item;
            estado = true;
            break;
        }
        return estado;
    }

    @Override
    public String toString() {
        return nombre +
                Arrays.toString(items);
    }
}
