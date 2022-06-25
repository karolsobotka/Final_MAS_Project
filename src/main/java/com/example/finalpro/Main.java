package com.example.finalpro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cinema");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

      // ExtensionsSaveState.loadSaveState();
        Movie movie1 = new Movie("Fight Club", "David Fincher", 139,1999);
        Movie movie2 = new Movie("The Dark Knight", "Christopher Nolan", 139,2008);
        Movie movie3 = new Movie("Dune", "Denis Villeneuve", 139,2021);
        Movie movie4 = new Movie("1917", "Sam Mendes", 139,2019);
        Screening screening = new Screening(LocalDate.parse("2022-07-01"), movie1,2);
        Screening screening2 = new Screening(LocalDate.parse("2022-07-12"), movie1,3);
        Screening screening3 = new Screening(LocalDate.parse("2022-07-12"), movie1,3);
        Screening screening4 = new Screening(LocalDate.parse("2022-07-12"), movie1,3);
        Screening screening5 = new Screening(LocalDate.parse("2022-07-12"), movie1,3);
        Screening screening6 = new Screening(LocalDate.parse("2022-07-12"), movie1,3);
        Screening screening7 = new Screening(LocalDate.parse("2022-07-12"), movie1,3);
        Screening screening8 = new Screening(LocalDate.parse("2022-07-12"), movie1,3);
        Screening screening9 = new Screening(LocalDate.parse("2022-07-12"), movie1,3);

        Client client = new RegisteredClient("imie","nazwisko",LocalDate.parse("2002-11-01"));

        launch();

     //   ExtensionsSaveState.saveState();
    }
}