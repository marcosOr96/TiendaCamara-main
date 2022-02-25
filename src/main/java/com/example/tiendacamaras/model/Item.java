package com.example.tiendacamaras.model;

public class Item {
    private String referencia;
    private String estado;

    public Item(String referencia, String estado) {
        this.referencia = referencia;
        this.estado = estado;
    }

    public Item() {
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return referencia +
                " " + estado;
    }
}
