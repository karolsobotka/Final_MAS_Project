package com.example.finalpro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ScreeningController implements Initializable {

    @FXML
    private Button screeningButton;

    @FXML
    private TableView<Screening> screeningTable;

    @FXML
    private TableColumn<Screening, Integer> roomNumber;
    @FXML
    private TableColumn<Screening, LocalDate> screeningDate;


    private Screening selectedScreening;
    @FXML
    private Label titleLabel;

    @FXML
    void handleButtonAction() {
        selectedScreening = screeningTable.getSelectionModel().getSelectedItem();

        screeningButton.setOnAction(actionEvent -> {

            try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reservation-view.fxml"));

                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.show();



                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
        );

    }
    ObservableList<Screening> list = FXCollections.observableArrayList(MovieController.getSelectedMovie().getScreeningList());


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            roomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
            screeningDate.setCellValueFactory(new PropertyValueFactory<>("screeningDate"));

            screeningTable.setItems(list);

    }
}
