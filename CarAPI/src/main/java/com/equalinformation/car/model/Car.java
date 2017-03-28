package com.equalinformation.car.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpupadhyaya on 3/27/17.
 */
public class Car {
    private String carID;
    private String make;
    private String model;
    private String year; // Can be converted to date if date comparison is required.
    private List<Rating> ratings = new ArrayList<Rating>();

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
