package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Snacks {

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private String snackName;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private double snackPrice;

    private List<Snacks> snackList = new ArrayList<>();

    public Snacks(String name, double price) {
        setSnackName(name);
        setSnackPrice(price);
    }


    public void addNewSnack(@NonNull String snackName,@NonNull double price) throws Exception {
        if(snackName.length() < 1){
            throw new Exception("Too short name");
        }
        snackList.add(new Snacks(snackName, price));
    }

    public void removeSnack(String snackName){

    }

}
