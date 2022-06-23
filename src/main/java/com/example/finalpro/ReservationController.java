package com.example.finalpro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReservationController implements Initializable {

    @FXML
    private TextField availableChairsCount;

    @FXML
    private ChoiceBox<String> comboBox;

    @FXML
    private TextField dateOfScreening;

    @FXML
    private ImageView imgArea;

    @FXML
    private ListView<String> listOfAvailableChairs;

    @FXML
    private Button reserveScreening;

    @FXML
    private TextField roomNo;

    @FXML
    private TextField ticketPrice;

    @FXML
    private TextField title;

    @FXML
    void reserveButtonHandler(){
        reserveScreening.setOnAction(e ->{
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pay-view.fxml"));

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
        availableChairsCount.setText("5");
        dateOfScreening.setText("18.06.2022");
        imgArea.setImage(new Image("C:\\Users\\WIN\\Desktop\\MAS\\PROJEKT\\FINAL\\src\\main\\resources\\Posters\\fightClub.jpg"));
        roomNo.setText("1");
        ticketPrice.setText("15zł");
        listOfAvailableChairs.getItems().addAll("1","2", "3", "15","18");
    }
}
