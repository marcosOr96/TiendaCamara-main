package com.example.tiendacamaras.fachada;


import com.example.tiendacamaras.controller.TiendaController;
import com.example.tiendacamaras.model.Camara;
import com.example.tiendacamaras.model.Cliente;
import com.example.tiendacamaras.model.Marca;
import com.example.tiendacamaras.model.Modelo;

import java.util.Arrays;

public class Tienda {
    private Camara[] camaras;
    private Cliente[] clientes;
    private String nombre;
    private String telefono;
    private String direccion;

    public Tienda(int clientes, int camaras, String nombre, String telefono, String direccion) {
        this.camaras = new Camara[camaras];
        this.clientes = new Cliente[clientes];
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Tienda() {

    }

    public Tienda(int clientes, int camaras) {
        this.camaras = new Camara[camaras];
        this.clientes = new Cliente[clientes];
    }

    public Camara[] getCamaras() {
        return camaras;
    }

    public void setCamaras(Camara[] camaras) {
        this.camaras = camaras;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public boolean crearCamaras(boolean soporte, String nombre, int cantidadPeliculas) {
        boolean estado = false;
        for (int i = 0; i < camaras.length; i++) {
            if (camaras[i] == null) {
                camaras[i] = new Camara(cantidadPeliculas);
                camaras[i].setSoporte(soporte);
                camaras[i].setNombre(nombre);
                estado = true;
                break;
            }
        }
        return estado;
    }

    public boolean asignarClientes(Cliente cliente) {
        boolean estado = false;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                estado = true;
                break;
            }
        }
        return estado;
    }

    public String alquilarCamaraAClienteSinMetodoPrivado(String tipoDocumento, String numeroDocumento, String nombreCamara) {
        String estado="";
        boolean b=false;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getNumeroDocumento().equalsIgnoreCase(numeroDocumento) && clientes[i].getTipoDocumento().equalsIgnoreCase(tipoDocumento)) {
                b=true;
                boolean a=false;
                for (int j = 0; j < camaras.length; j++) {
                    if(camaras[j].getNombre().equalsIgnoreCase(nombreCamara)){
                        clientes[i].setCamara(camaras[i]);
                        estado="Se asigno efectivamente la Camara al Cliente";
                        a=true;
                        break;
                    }
                }
                if(!a){
                    estado="No existe una camara con este nombre";
                }
                break;
            }

        }
        if (!b){
            estado="No existe un Cliente con este tipo de documento y numero de documento";
        }
        return estado;
    }

    public String alquilarCamaraAClienteConMetodosPrivados(String tipoDocumento, String numeroDocumento, String nombreCamara) {
        Cliente cliente=this.buscarCliente(tipoDocumento,numeroDocumento);
        Camara camara=this.buscarCamara(nombreCamara);
        if(cliente==null){
            return "No existe un Cliente con este tipo de documento y numero de documento";
        }
        if(camara==null){
            return "No existe una camara con este nombre";
        }
        cliente.setCamara(camara);
        return "Se asigno efectivamente la Camara al Cliente";
    }

    private Cliente buscarCliente(String tipoDocumento, String numeroDocumento){
        for (int i = 0; i < clientes.length; i++) {
            if(clientes[i]!=null) {
                if (clientes[i].getNumeroDocumento().equalsIgnoreCase(numeroDocumento) && clientes[i].getTipoDocumento().equalsIgnoreCase(tipoDocumento)) {
                    return clientes[i];
                }
            }
        }
         return null;
    }

    private Camara buscarCamara(String nombreCamara){
        for (int i = 0; i < camaras.length; i++) {
            if(camaras[i]!=null) {
                if (camaras[i].getNombre().equalsIgnoreCase(nombreCamara)) {
                    return camaras[i];
                }
            }
        }
        return null;
    }

    public String listarCamaras(){
        String cad="";
        for (Camara camara:camaras) {
            if(camara!=null){
                cad+="Nombre: "+camara.getNombre()+" - Soporte: "+camara.isSoporte();
                cad+="\n";
            }
        }
        return cad;
    }

    public String listarClientes(){
        String cad="";
        for (Cliente cliente:clientes) {
            if(cliente!=null){
                cad+="Nombre: "+cliente.getNombre()+" - Tipo de documento: "+cliente.getTipoDocumento()+" - Numero de documento: "+cliente.getNumeroDocumento();
                cad+="\n";
            }
        }
        return cad;
    }

    public String asignarPeliculaACamara(String nombreCamara, String nombre, String sencibilidad, String formato){
        Camara camara=this.buscarCamara(nombreCamara);
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
        Camara camara=this.buscarCamara(nombreCamara);
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
        Camara camara = this.buscarCamara(nombreCamara);
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
        return "camaras= " + Arrays.toString(camaras) +
                "\nclientes= " + Arrays.toString(clientes) +
                "\nnombre= " + nombre +
                "\ntelefono= " + telefono +
                "\ndireccion= " + direccion;
    }
}
