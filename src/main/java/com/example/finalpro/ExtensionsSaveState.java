package com.example.finalpro;

import java.io.*;

public class ExtensionsSaveState {

    private static final File saveFile = new File("state.dat");
    public static void loadSaveState(){
        if(saveFile.isFile()) {
            try (FileInputStream fis = new FileInputStream(saveFile);
                 ObjectInputStream ois = new ObjectInputStream(fis)){

                Person.readFromPersonsList(ois);
                Movie.readFromMovieList(ois);
                Ticket.readFromTicketList(ois);
                Snacks.readFromSnacksList(ois);
                MovieMarathon.readFromMovieMarathonList(ois);
                Reservation.readFromReservationList(ois);
                Screening.readFromScreeningList(ois);

            } catch(IOException e) {
                System.err.println(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }
    }
    public static void saveState(){
        try (FileOutputStream fos = new FileOutputStream(saveFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(Person.getPersonsList());
            oos.writeObject(Movie.getMovieList());
            oos.writeObject(Ticket.getTicketList());
            oos.writeObject(Reservation.getReservationList());
            oos.writeObject(Snacks.getSnackList());
            oos.writeObject(MovieMarathon.getMovieMarathonList());
            oos.writeObject(Screening.getScreeningList());



        } catch(IOException e) {
            System.err.println(e);
        }



    }
}
