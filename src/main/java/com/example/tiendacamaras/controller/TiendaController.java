package com.example.tiendacamaras.controller;

import com.example.tiendacamaras.fachada.Tienda;
import com.example.tiendacamaras.model.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TiendaController implements Initializable {
    @FXML
    private Pane paneRegistro;
    @FXML
    private Pane paneComponentes;
    @FXML
    private Pane paneRelaciones;
    @FXML
    private Pane paneAlquilar;
    @FXML
    private Pane paneListar;
    @FXML
    private Pane paneIconos;
    @FXML
    private Pane paneTienda;

    @FXML
    private ImageView imageRegistro;
    @FXML
    private ImageView imageComponentes;
    @FXML
    private ImageView imageRelaciones;
    @FXML
    private ImageView imageAlquilar;
    @FXML
    private ImageView imageListar;

    @FXML
    private ComboBox<String> tipoDocumentoCliente;
    @FXML
    private ComboBox<String> comboBoxPelicula1;
    @FXML
    private ComboBox<String> comboBoxPelicula2;
    @FXML
    private ComboBox<String> comboBoxMarca1;
    @FXML
    private ComboBox<String> comboBoxMarca2;
    @FXML
    private ComboBox<String> comboBoxCamara1;
    @FXML
    private ComboBox<String> comboBoxCamara2;
    @FXML
    private ComboBox<String> comboBoxModelo;
    @FXML private ComboBox<String> comboBoxCliente;
    @FXML private ComboBox<String> comboBoxCamara3;

    @FXML
    private TextField nombreTienda;
    @FXML
    private TextField direccionTienda;
    @FXML
    private TextField telefonoTienda;
    @FXML
    private TextField cantidadClientes;
    @FXML
    private TextField cantidadCamaras;
    @FXML
    private TextField nombreCliente;
    @FXML
    private TextField numeroDocumentoCliente;
    @FXML
    private TextField nombreCamara;
    @FXML
    private TextField soporteCamara;
    @FXML
    private TextField nombreMarca;
    @FXML
    private TextField direccionMarca;
    @FXML
    private TextField nombreModelo;
    @FXML
    private TextField nombrePelicula;
    @FXML
    private TextField sencibilidadPelicula;
    @FXML
    private TextField formatoPelicula;

    @FXML TextArea textListaCamarasAlquiladas;

    @FXML
    private Button crearClienteButton;
    @FXML
    private Button crearCamaraButton;
    @FXML
    private Button crearModeloButton;
    @FXML
    private Button crearMarcaButton;
    @FXML
    private Button crearPeliculaButton;

    private Tienda tienda;
    private Pelicula pelicula;
    private int cantClientes;
    private int cantCamaras;
    private String listar="Camaras Alquiladas";

    ObservableList<String> comboDIContent =
            FXCollections.observableArrayList(
                    "C.C",
                    "C.E",
                    "T.I",
                    "PASAPORTE"
            );

    public void initialize(URL location, ResourceBundle resources) {
        nombreTienda.addEventFilter(KeyEvent.ANY,validarLetras);
        nombreCliente.addEventFilter(KeyEvent.ANY,validarLetras);
        numeroDocumentoCliente.addEventFilter(KeyEvent.ANY,validarNumeros);
        telefonoTienda.addEventFilter(KeyEvent.ANY,validarNumeros);
        cantidadClientes.addEventFilter(KeyEvent.ANY,validarNumeros);
        cantidadCamaras.addEventFilter(KeyEvent.ANY,validarNumeros);
        sencibilidadPelicula.addEventFilter(KeyEvent.ANY,validarNumeros);
        formatoPelicula.addEventFilter(KeyEvent.ANY,validarNumeros);

        tipoDocumentoCliente.setItems(comboDIContent);
    }

    public void onRigistroButtonClick (MouseEvent event) {
        paneRegistro.setVisible(true);
        imageRegistro.setVisible(true);

        paneComponentes.setVisible(false);
        paneRelaciones.setVisible(false);
        paneAlquilar.setVisible(false);
        paneListar.setVisible(false);
    }

    public void onComponentesButtonClick (MouseEvent event) {
        paneComponentes.setVisible(true);
        imageComponentes.setVisible(true);

        paneRegistro.setVisible(false);
        paneRelaciones.setVisible(false);
        paneAlquilar.setVisible(false);
        paneListar.setVisible(false);
    }

    public void onRelacionesButtonClick (MouseEvent event) {
        paneRelaciones.setVisible(true);
        imageRelaciones.setVisible(true);

        paneComponentes.setVisible(false);
        paneRegistro.setVisible(false);
        paneAlquilar.setVisible(false);
        paneListar.setVisible(false);
    }

    public void onAlquilarButtonClick (MouseEvent event) {
        paneAlquilar.setVisible(true);
        imageAlquilar.setVisible(true);

        paneComponentes.setVisible(false);
        paneRelaciones.setVisible(false);
        paneRegistro.setVisible(false);
        paneListar.setVisible(false);
    }

    public void onListarButtonClick (MouseEvent event) {
        paneListar.setVisible(true);
        imageListar.setVisible(true);

        paneComponentes.setVisible(false);
        paneRelaciones.setVisible(false);
        paneAlquilar.setVisible(false);
        paneRegistro.setVisible(false);
    }

    EventHandler<KeyEvent> validarLetras = new EventHandler<KeyEvent>() {
        private boolean respuesta = false;
        @Override
        public void handle(KeyEvent event) {
            Object tempO = event.getSource();
            if (respuesta){
                event.consume();
            }
            String temp = event.getCode().toString();
            if (!event.getCode().toString().matches("[a-zA-Z]") && event.getCode() != KeyCode.BACK_SPACE && event.getCode() != KeyCode.SHIFT && event.getCode() != KeyCode.SPACE){
                if(event.getEventType()== KeyEvent.KEY_PRESSED){
                    respuesta=true;
                }
                else if(event.getEventType()==KeyEvent.KEY_RELEASED){
                    respuesta=false;
                }
            }
        }
    };

    EventHandler<KeyEvent> validarNumeros = new EventHandler<KeyEvent>() {
        private boolean respuestas = false;
        private int maxLength = 10;

        @Override
        public void handle(KeyEvent event) {
            TextField temp = (TextField) event.getSource();
            if (respuestas) {
                event.consume();
            }
            if (!event.getText().matches("[0-9]") && event.getCode() != KeyCode.BACK_SPACE) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    respuestas = true;
                } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                    respuestas = false;
                }
            }
            if (temp.getText().length() > maxLength - 1) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    respuestas = true;
                } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                    respuestas = false;
                }
            }
        }
    };

    public void onRegistrarTienda(ActionEvent event) {
        if (nombreTienda.getText().isBlank() || direccionTienda.getText().isBlank() || telefonoTienda.getText().isBlank() || cantidadClientes.getText().isBlank() || cantidadCamaras.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("se encuentran campos vacios");

            alert.showAndWait();
        }

        else {
            tienda = new Tienda(Integer.parseInt(cantidadClientes.getText()),Integer.parseInt(cantidadCamaras.getText()));
            tienda.setNombre(nombreTienda.getText());
            tienda.setDireccion(direccionTienda.getText());
            tienda.setTelefono(telefonoTienda.getText());
            cantClientes=Integer.parseInt(cantidadClientes.getText());
            cantCamaras=Integer.parseInt(cantidadCamaras.getText());

            paneRegistro.setVisible(true);
            paneIconos.setVisible(true);

            paneTienda.setVisible(false);
        }
    }

    public void onCrearClienteButtonClick(ActionEvent event) {
        if (nombreCliente.getText().isBlank() || numeroDocumentoCliente.getText().isBlank() || tipoDocumentoCliente.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("se encuentran campos vacios");

            alert.showAndWait();
        }

        else {

            Cliente cliente = new Cliente(nombreCliente.getText(),tipoDocumentoCliente.getValue(),numeroDocumentoCliente.getText());
            tienda.asignarClientes(cliente);
            ObservableList<String> comboClienteContent =
                    FXCollections.observableArrayList(
                    );
            comboClienteContent.addAll(numeroDocumentoCliente.getText());
            comboBoxCliente.getItems().addAll(comboClienteContent);
        }
    }

    public void onCrearCamaraButtonClick (ActionEvent event) {
        if (nombreCamara.getText().isBlank() || soporteCamara.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("se encuentran campos vacios");

            alert.showAndWait();
        }

        else{
            tienda.crearCamaras(nombreCamara.getText());
            ObservableList<String> comboCamaraContent =
                    FXCollections.observableArrayList(
                    );
            comboCamaraContent.addAll(nombreCamara.getText());
            comboBoxCamara1.getItems().addAll(comboCamaraContent);
            comboBoxCamara2.getItems().addAll(comboCamaraContent);
            comboBoxCamara3.getItems().addAll(comboCamaraContent);
        }
    }

    public void onCrearModeloButtonClick (ActionEvent event) {
        if (nombreModelo.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("se encuentran campos vacios");

            alert.showAndWait();
        }

        else{
            Camara camara = new Camara();
            Modelo modelo = new Modelo(nombreModelo.getText());
            camara.asignarModelo(modelo);
            modelo.setNombre(nombreModelo.getText());
            ObservableList<String> comboModuloContent =
                    FXCollections.observableArrayList(
                    );
            comboModuloContent.addAll(modelo.getNombre());
            comboBoxModelo.getItems().addAll(comboModuloContent);
        }
    }

    public void onCrearMarcaButtonClick (ActionEvent event) {
        if (nombreMarca.getText().isBlank() || direccionMarca.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("se encuentran campos vacios");

            alert.showAndWait();
        }

        else{
            ObservableList<String> comboMarcaContent =
                    FXCollections.observableArrayList(
                    );
            comboMarcaContent.addAll(nombreMarca.getText());
            comboBoxMarca1.getItems().addAll(comboMarcaContent);
            comboBoxMarca2.getItems().addAll(comboMarcaContent);
        }
    }

    public void onCrearPeliculaButtonClick (ActionEvent event) {
        if (nombrePelicula.getText().isBlank() || sencibilidadPelicula.getText().isBlank() || formatoPelicula.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("se encuentran campos vacios");

            alert.showAndWait();
        }

        else{
            Camara camara = new Camara();
            camara.asignarPelicula(nombrePelicula.getText(),sencibilidadPelicula.getText(),formatoPelicula.getText());
            ObservableList<String> comboPeliculaContent =
                    FXCollections.observableArrayList(
                    );
            comboPeliculaContent.addAll(nombrePelicula.getText());
            comboBoxPelicula1.getItems().addAll(comboPeliculaContent);
            comboBoxPelicula2.getItems().addAll(comboPeliculaContent);
        }
    }

    public void onAsociarPeliculaMarcaButtonClick ( MouseEvent event) {
        pelicula = new Pelicula(comboBoxMarca1.getValue());
    }

    public void onAsociarCamaraMarcaModeloButtonClick ( MouseEvent event) {
        Marca marca = new Marca(comboBoxMarca2.getValue(),direccionMarca.getText());
        Modelo modelo = new Modelo(comboBoxModelo.getValue());
        tienda.asignarMarcaACamara(comboBoxCamara1.getValue(),marca);
        tienda.asignarModeloACamara(comboBoxCamara1.getValue(),modelo);
    }

    public void onAsociarCamaraPeliculaButtonClick ( MouseEvent event) {
        tienda.asignarPeliculaACamara(comboBoxCamara2.getValue(),comboBoxPelicula2.getValue(),sencibilidadPelicula.getText(),formatoPelicula.getText());
    }

    public void onAlquilarCamaraButtonClick ( MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ANUNCIO");
        alert.setHeaderText(null);
        alert.setContentText("se alquila la camara "+comboBoxCamara3.getValue()+" al cliente con el numero de documento "+comboBoxCliente.getValue());

        alert.showAndWait();
        ObservableList<String> comboCamarasAlquiladasContent =
                FXCollections.observableArrayList(
                );
        comboCamarasAlquiladasContent.addAll(comboBoxCamara3.getValue());
        listar +="\n* "+comboCamarasAlquiladasContent.toString().replace("[", "").replace("]", "");
    }

    public void onListarCamarasAlquiladaClick ( MouseEvent event) {
        textListaCamarasAlquiladas.setText(listar);
    }

    public void onExitButtonClick (MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }
}