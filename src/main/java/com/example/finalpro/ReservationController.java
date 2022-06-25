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
    private TextField title;

    private static Reservation newReservation = new Reservation(ScreeningController.getSelectedScreening(),
                                                new RegisteredClient("imie", "nazwisko", LocalDate.parse("1999-02-03")),
                                                ReservationState.AVAILABLE.toString());
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
        title.setText(MovieController.getSelectedMovie().getName());
        availableChairsCount.setText("5");
        dateOfScreening.setText(ScreeningController.getSelectedScreening().getScreeningDate().toString());
        roomNo.setText(""+ScreeningController.getSelectedScreening().getRoomNumber());
        ticketPrice.setText(""+Ticket.getTicketPrice());
        listOfAvailableChairs.getItems().addAll("1","2", "3", "15","18");
    }
}
