package com.example.tiendacamaras.fachada;


import com.example.tiendacamaras.model.Camara;
import com.example.tiendacamaras.model.Cliente;
import com.example.tiendacamaras.model.Marca;
import com.example.tiendacamaras.model.Modelo;

import java.util.ArrayList;

public class Tienda {
    private ArrayList camaras;
    private ArrayList clientes;
    private String nombre;
    private String telefono;
    private String direccion;

    public Tienda(String nombre, String telefono, String direccion) {
        this.camaras = new ArrayList();
        this.clientes = new ArrayList();
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Tienda() {

    }

    public Tienda(int clientes, int camaras) {
        this.camaras = new ArrayList(camaras);
        this.clientes = new ArrayList(clientes);
    }

    public ArrayList getCamaras() {
        return camaras;
    }

    public void setCamaras(ArrayList camaras) {
        this.camaras = camaras;
    }

    public ArrayList getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList clientes) {
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public Object setNombre(String nombre) {
        this.nombre = nombre;
        return null;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean crearCamaras(String nombre) {
        boolean estado = false;
        camaras.add(new Camara(nombre));
        estado = true;
        return estado;
    }

    public boolean asignarClientes(Cliente cliente) {
        boolean estado = false;
        if (clientes == null) {
            clientes.add(cliente);
            estado = true;
        }
        return estado;
    }

    private String buscarCamara(String nombreCamara){
            if(camaras!=null) {
                if (camaras.toString().equals(nombreCamara)) {
                    return camaras.toString();
                }
            }
            return null;
    }

    public String asignarPeliculaACamara(String nombreCamara, String nombre, String sencibilidad, String formato){
        Camara camara=new Camara(nombreCamara);
        camara.getNombre().equals(this.buscarCamara(nombreCamara));
        if(camara==null){
            return "Camara No existe";
        }
        boolean resultado=camara.asignarPelicula(nombre,sencibilidad,formato);
        if(resultado){
            return "Se agrego la pelicula a la camara";
        }
        return "No se pudo agregar la pelicula a la camara, la camara no puede insertar más peliculas";
    }

    public String asignarMarcaACamara(String nombreCamara, Marca marca) {
        Camara camara=new Camara(nombreCamara);
        camara.getNombre().equals(this.buscarCamara(nombreCamara));
        if (camara==null){
            return "camara No existe";
        }
        boolean asignado=camara.asignarMarca(marca);
        if (asignado){
            return "se asignó la marca de la camara";
        }
        return "No se pudo asignar la marca de la camara";
    }

    public String asignarModeloACamara(String nombreCamara, Modelo modelo) {
        Camara camara=new Camara(nombreCamara);
        camara.getNombre().equals(this.buscarCamara(nombreCamara));
        if (camara==null){
            return "camara No existe";
        }
        boolean asignado=camara.asignarModelo(modelo);
        if (asignado){
            return "se asignó el modelo de la camara";
        }
        return "No se pudo asignar el modelo de la camara";
    }

    @Override
    public String toString() {
        return "camaras " + camaras +
                "\nclientes " + clientes +
                "\nnombre " + nombre +
                "\ntelefono " + telefono +
                "\ndireccion " + direccion;
    }
}
