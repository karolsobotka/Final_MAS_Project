package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieMarathon implements Serializable {


   //list of movies in marathon
    @Setter(AccessLevel.PRIVATE)
    private List<Movie> movieList = new ArrayList<>();
    @Setter
    @Getter
    @NonNull
    private LocalDate marathonDate;
    // list of all movie marathons
    @Getter
    private static List<MovieMarathon> movieMarathonList = new ArrayList<>();

    public MovieMarathon(LocalDate marathonDate, ArrayList<Movie> movies) {
        setMarathonDate(marathonDate);
        setMovieList(movieList);

    }

    public static void readFromMovieMarathonList(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            movieMarathonList = (List<MovieMarathon>) ois.readObject();

    }

    public List<Movie> getMovieList() {
        return Collections.unmodifiableList(movieList);
    }


    public void addNewMarathon(LocalDate date, ArrayList<Movie> movieList){
        MovieMarathon newMovieMarathon = new MovieMarathon(date, movieList);
        newMovieMarathon.setMovieList(movieList);
        movieMarathonList.add(newMovieMarathon);
    }

    public void cancelMarathon(MovieMarathon marathon){
        if(movieMarathonList.contains(marathon)){
            movieMarathonList.remove(marathon);

        }
        else
            System.out.println("nie ma takiego maratonu");
    }
}
