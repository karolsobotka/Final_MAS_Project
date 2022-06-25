package com.example.finalpro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class MovieController implements Initializable {


    @FXML
    private TableView<Movie> table;
    @FXML
    private TableColumn<Movie, String> name;
    @FXML
    private TableColumn<Movie, String> director;
    @FXML
    private TableColumn<Movie, Integer> releaseYear;
    @FXML
    private TableColumn<Movie, Integer> videoLength;

    private static Movie selectedMovie;
    @FXML
    private Button chooseMovieButton;

    @FXML
    void handleButtonAction() {
        selectedMovie = table.getSelectionModel().getSelectedItem();

        chooseMovieButton.setOnAction(actionEvent -> {
            try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screening-list.fxml"));

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

    ObservableList<Movie> list = FXCollections.observableArrayList(Movie.getMovieList());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        director.setCellValueFactory(new PropertyValueFactory<>("director"));
        videoLength.setCellValueFactory(new PropertyValueFactory<>("videoLength"));
        releaseYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));

        table.setItems(list);
    }

    public static Movie getSelectedMovie() {
        return selectedMovie;
    }
}