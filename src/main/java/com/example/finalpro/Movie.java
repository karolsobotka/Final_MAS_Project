package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Movie implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id


    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private String name;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private String director;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private double videoLength;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private int releaseYear;

    public static List<Movie> movieList = new ArrayList<>();



    @Getter
    private List<Screening> screeningList = new ArrayList<>();

    public Movie(String name, String director, double videoLength, int releaseYear){
       setName(name);
       setDirector(director);
       setVideoLength(videoLength);
       setReleaseYear(releaseYear);
       movieList.add(this);
    }
    public static List<Movie> getMovieList() {
        return Collections.unmodifiableList(movieList);
    }
    public List<Screening> getScreeningList() {
        return screeningList;
    }

    public  void addMovie(Movie movie) throws Exception {
        if(movieList.contains(movie)){
            throw new Exception("there is already a movie like this");
        }
        else
            movieList.add(movie);
    }


    public void deleteMovie(){

    }


}
