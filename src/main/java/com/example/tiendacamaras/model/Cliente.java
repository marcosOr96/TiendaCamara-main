package com.example.tiendacamaras.model;

public class Cliente {

    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private Camara camara;

    public Cliente(String nombre, String tipoDocumento, String numeroDocumento, Camara camara) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.camara = camara;
    }

    public Cliente() {
    }

    public Cliente(String nombre, String tipoDocumento, String numeroDocumento) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    public boolean crearCamara(boolean soporte, String nombre) {
        boolean estado = false;
            if(camara==null) {
                camara = new Camara();
                camara.setSoporte(soporte);
                camara.setNombre(nombre);
                estado = true;
            }

        return estado;
    }

    @Override
    public String toString() {
        return "nombre= " + nombre +
                " tipoDocumento= " + tipoDocumento +
                " numeroDocumento= " + numeroDocumento +
                " camara=" + camara;
    }
}
