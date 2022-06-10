package com.example.finalpro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TableView<Seans> table;
    @FXML
    private TableColumn<Seans,String> dateFrom;
    @FXML
    private TableColumn<Seans,String> dateTo;
    @FXML
    private TableColumn<Seans,String> name;
    @FXML
    private TableColumn<Seans,String> room;
    @FXML
    private TableColumn<Seans,String> availability;

    @FXML
    private Button chooseMovieButton;

    public static Seans getSelectedSeans() {
        return selectedSeans;
    }

    static Seans selectedSeans;

    @FXML
    void handleButtonAction() {
        chooseMovieButton.setOnAction(actionEvent -> {
            selectedSeans = table.getSelectionModel().getSelectedItem();
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

    ObservableList<Seans> list = FXCollections.observableArrayList(
            new Seans("17.05.2022","01.09.2022","Fight Club","1","yes"),
            new Seans("18.06.2022","02.10.2022","The Dark Knight Returns","4","yes"),
            new Seans("19.07.2022","03.11.2022","Star Wars Empire Strikes Back","2","no"),
            new Seans("20.08.2022","04.12.2022","Dune (2021)","5","yes")
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