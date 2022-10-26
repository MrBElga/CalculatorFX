package com.example.fxcalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaTabelaController implements Initializable {
    public Button btapagar;
    public TableView tabela;
    public TableColumn colHorario;
    public TableColumn colEquacao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       colHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));
       colEquacao.setCellValueFactory(new PropertyValueFactory<>("equacao"));
       ObservableList <Historico> modelo = FXCollections.observableArrayList(Singleton.colhisto.getLista());
       tabela.setItems(modelo);
    }
    public void onApagar(ActionEvent actionEvent) {

        Singleton.colhisto.getLista().remove(tabela.getSelectionModel().getSelectedIndex());
        tabela.getItems().remove(tabela.getSelectionModel().getSelectedItem());
        btapagar.setDisable(true);
    }

    public void onFecharJanela(ActionEvent actionEvent) {
        btapagar.getScene().getWindow().hide();
    }


    public void onMouseClick(MouseEvent mouseEvent) {
         if(tabela.getSelectionModel().getSelectedItem()!=null)
             btapagar.setDisable(false);
    }
}
