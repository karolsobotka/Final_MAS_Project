package com.example.finalpro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PayController implements Initializable {

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Button button;

    @FXML
    void reserveButtonHandler(){
        button.setOnAction(e ->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reservation-confirmed.fxml"));

                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();


            } catch (IOException exeption) {
                throw new RuntimeException(exeption);
            }
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll("Zwykła rezerwacja","Natychmiastowa opłata");


    }
}
