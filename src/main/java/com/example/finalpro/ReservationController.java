package com.example.finalpro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ReservationController {

    @FXML
    private TextField availableChairsCount;

    @FXML
    private ChoiceBox<?> comboBox;

    @FXML
    private TextField dateOfScreening;

    @FXML
    private ImageView imgArea;

    @FXML
    private ListView<?> listOfAvailableChairs;

    @FXML
    private Button reserveScreening;

    @FXML
    private TextField roomNo;

    @FXML
    private TextField ticketPrice;

    @FXML
    private TextField title;

    Seans seans = HelloController.getSelectedSeans();
    @FXML
    void reserveButtonHandler(){
        reserveScreening.setOnAction(e ->{


        });
    }

}
