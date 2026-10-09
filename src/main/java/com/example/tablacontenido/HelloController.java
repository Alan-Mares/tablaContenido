package com.example.tablacontenido;

import java.io.File;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

public class HelloController {

    @FXML
    private TableView<Token> tablaContenido;
    @FXML
    private TableColumn<Token, String> colLexema;
    @FXML
    private TableColumn<Token, String> colTipo;
    @FXML
    private TableColumn<Token, Integer> colLinea;
    @FXML
    private TableColumn<Token, Integer> colInicio;
    @FXML
    private TableColumn<Token, Integer> colFin;
    @FXML
    private Label etiquetaArchivo;

    Analizador analizador = new Analizador();

    @FXML
    public void initialize() {
        colLexema.setCellValueFactory(new PropertyValueFactory<Token, String>("lexema"));
        colTipo.setCellValueFactory(new PropertyValueFactory<Token, String>("tipo"));
        colLinea.setCellValueFactory(new PropertyValueFactory<Token, Integer>("linea"));
        colInicio.setCellValueFactory(new PropertyValueFactory<Token, Integer>("inicio"));
        colFin.setCellValueFactory(new PropertyValueFactory<Token, Integer>("fin"));
    }

    @FXML
    protected void onAbrirArchivo() {
        FileChooser selector = new FileChooser();
        selector.setTitle("Elegir archivo");
        selector.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"));
        File archivo = selector.showOpenDialog(tablaContenido.getScene().getWindow());

        if (archivo == null) {
            return;
        }

        try {
            ArrayList<Token> tokens = analizador.leerArchivo(archivo);
            tablaContenido.setItems(FXCollections.observableArrayList(tokens));
            etiquetaArchivo.setText("Archivo: " + archivo.getName());

            if (tokens.size() == 0) {
                Alert vacio = new Alert(Alert.AlertType.WARNING, "El archivo esta vacio, no tiene texto");
                vacio.show();
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "No se pudo leer el archivo: " + e.getMessage());
            alerta.show();
        }
    }
}