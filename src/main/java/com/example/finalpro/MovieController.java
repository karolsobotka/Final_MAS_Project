package com.example.finalpro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieController implements Initializable {






    @FXML
    void handleButtonAction() {
        chooseMovieButton.setOnAction(actionEvent -> {
            selectedScreening = table.getSelectionModel().getSelectedItem();
            try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reservation-view.fxml"));

                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });
    }

    ObservableList<Movie> list = FXCollections.observableArrayList(
            new Movie("Fight Club", "David Fincher", 139,1999),
            new Movie("Fight Club", "David Fincher", 139,1999),
            new Movie("Fight Club", "David Fincher", 139,1999),
            new Movie("Fight Club", "David Fincher", 139,1999)
    );





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateTo.setCellValueFactory(new PropertyValueFactory<>("dateTo"));
        dateFrom.setCellValueFactory(new PropertyValueFactory<>("dateFrom"));
        room.setCellValueFactory(new PropertyValueFactory<>("room"));
        availability.setCellValueFactory(new PropertyValueFactory<>("availability"));


        table.setItems(list);
    }
}