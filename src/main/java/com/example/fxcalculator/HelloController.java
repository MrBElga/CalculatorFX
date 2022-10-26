package com.example.fxcalculator;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    public TextField tfResultado;
    @FXML
    private Button btClose;
    private double valor,acm;
    private char op;
    private double cx,cy;
    private String calculo="";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       valor=0;
       acm=0;
       op='+';
    }

    public void onCloseWindow(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onResultado(ActionEvent actionEvent) {
        efetuarCalculo();
        calculo+=" = "+acm;
        acm=0;
        op='+';

        System.out.println(calculo);
        Singleton.colhisto.addHistorico(new Historico(calculo, LocalTime.now().toString()));
        // guardar a expressão do calculo + hora
        calculo="";
    }

    public void onMultiplicar(ActionEvent actionEvent) {
        efetuarCalculo();
        op='*';
    }

    public void onDividir(ActionEvent actionEvent) {
        efetuarCalculo();
        op='/';
    }

    public void onSubtrair(ActionEvent actionEvent) {
        efetuarCalculo();
        op='-';
    }

    public void onSomar(ActionEvent actionEvent) {
        efetuarCalculo();
        op='+';
    }

    private void efetuarCalculo() {
        calculo+=""+valor+""+op;
        switch(op)
        {
            case '+':
                acm+=valor;
                break;
            case '-':
                acm-=valor;
                break;
            case '*':
                acm*=valor;
                break;
            case '/':
                acm/=valor;
                break;
        }
        tfResultado.setText(""+acm);
        valor=0;
    }

    public void onNumero(ActionEvent actionEvent) {

        String num=((Button)actionEvent.getSource()).getText();
        if(!num.equals("."))
        {
            valor=valor*10+Double.parseDouble(num);
        }
        tfResultado.setText(""+valor);

    }


    public void onMouseDragged(MouseEvent mouseEvent) {
        Stage stage = ((Stage)((Node)mouseEvent.getSource()).getScene().getWindow());
        stage.setX(mouseEvent.getScreenX()+cx);
        stage.setY(mouseEvent.getScreenY()+cy);

    }

    public void onMousePressed(MouseEvent mouseEvent) {
        Stage stage = ((Stage)((Node)mouseEvent.getSource()).getScene().getWindow());
        cx=stage.getX() - mouseEvent.getScreenX();
        cy=stage.getY() - mouseEvent.getScreenY();
    }

    public void onOpenAbout(ActionEvent actionEvent) throws IOException {
        //carregar e mostrar a janela de Sobre o app
        // na forma modal
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("tela-sobre.fxml")));
        stage.setScene(scene);
        stage.setTitle("Sobre");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }

    public void onOpenLista(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("tela-tabela.fxml")));
        stage.setScene(scene);
        stage.setTitle("Histórico de Equações");
        //stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}