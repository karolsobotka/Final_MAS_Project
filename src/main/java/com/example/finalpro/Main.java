package com.example.finalpro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main extends Application {
    public static Client client;


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
        Movie movie2 = new Movie("The Dark Knight", "Christopher Nolan", 129,2008);
        Movie movie3 = new Movie("Dune", "Denis Villeneuve", 239,2021);
        Movie movie4 = new Movie("1917", "Sam Mendes", 200,2019);

        Screening screening  = new Screening(LocalDateTime.parse("2022-07-01T19:00"), movie1,2);
        Screening screening2 = new Screening(LocalDateTime.parse("2022-07-12T18:00"), movie1,1);
        Screening screening3 = new Screening(LocalDateTime.parse("2022-07-14T17:00"), movie1,4);
        Screening screening4 = new Screening(LocalDateTime.parse("2022-07-13T18:00"), movie1,5);
        Screening screening5 = new Screening(LocalDateTime.parse("2022-07-16T15:00"), movie1,3);



        client = new RegisteredClient("imie","nazwisko",LocalDate.parse("2002-11-01"));

        launch();

       ExtensionsSaveState.saveState();
    }
}