package com.example.finalpro;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class Manger {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id
    @Getter
    @Setter
    @NonNull
    private double managerBonus;

    public Manger(double managerBonus) {
        setManagerBonus(managerBonus);
    }

    public void getNewReleasesInfo(){

    }
    public void getSellInfo(){

    }
}
