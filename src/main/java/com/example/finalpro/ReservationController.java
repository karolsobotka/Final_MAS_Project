package com.example.finalpro;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReservationController implements Initializable {

    @FXML
    private TextField availableChairsCount;

    @FXML
    private ChoiceBox<String> comboBox;

    @FXML
    private TextField dateOfScreening;



    @FXML
    private ListView<String> listOfAvailableChairs;

    @FXML
    private Button reserveScreening;

    @FXML
    private TextField roomNo;

    @FXML
    private TextField ticketPrice;
    @FXML
    private ComboBox<Integer> sitCountComboBox;

    @FXML
    private TextField title;

    private static Reservation newReservation = new Reservation(ScreeningController.getSelectedScreening(),
                                                new RegisteredClient("imie", "nazwisko", LocalDate.parse("1999-02-03")),
                                                ReservationState.AVAILABLE.toString());
    @FXML
    void reserveButtonHandler(){

        reserveScreening.setOnAction(e ->{


                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reservation_pay-view.fxml"));

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
        title.setText(MovieController.getSelectedMovie().getName());
        availableChairsCount.setText("5");
        sitCountComboBox = new ComboBox(FXCollections.observableArrayList(1,2,3));
        dateOfScreening.setText(ScreeningController.getSelectedScreening().getScreeningDate().toString());
        roomNo.setText("Sala nr: "+ScreeningController.getSelectedScreening().getRoomNumber());
        ticketPrice.setText(Ticket.getTicketPrice()+"zł");
        listOfAvailableChairs.getItems().addAll("1","2", "3", "15","18");
        listOfAvailableChairs.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
