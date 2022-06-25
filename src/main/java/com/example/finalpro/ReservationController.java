package com.example.finalpro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        listOfAvailableChairs.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listOfAvailableChairs.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        availableChairsCount.setText(""+listOfAvailableChairs.getItems().size());
        dateOfScreening.setText(ScreeningController.getSelectedScreening().getScreeningDate().toString());
        roomNo.setText(""+ScreeningController.getSelectedScreening().getRoomNumber());
        ticketPrice.setText(Ticket.getTicketPrice()+"zł");
    }
}
