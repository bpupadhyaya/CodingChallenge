package com.equalinformation.car.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpupadhyaya on 3/27/17.
 */
public class CarRatingData {

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<Car>();

        Rating ratingS = new Rating();
        ratingS.setReviewedBy("Edmunds");
        ratingS.setSafety(5);
        ratingS.setPerformance(5);
        ratingS.setTechnology(5);
        ratingS.setInterior(5);
        ratingS.setReliability(5);
        List<Rating> allRatingsForS = new ArrayList<Rating>();
        allRatingsForS.add(ratingS);

        Car car1 = new Car();
        car1.setMake("Tesla");
        car1.setModel("S");
        car1.setYear("2016");
        car1.setRatings(allRatingsForS);

        cars.add(car1);

        Rating ratingX = new Rating();
        ratingX.setReviewedBy("Car and Driver");
        ratingX.setSafety(4);
        ratingX.setPerformance(5);
        ratingX.setTechnology(5);
        ratingX.setInterior(5);
        ratingX.setReliability(4);
        List<Rating> allRatingsForX = new ArrayList<Rating>();
        allRatingsForX.add(ratingX);

        Car car2 = new Car();
        car2.setMake("Tesla");
        car2.setModel("X");
        car2.setYear("2017");
        car2.setRatings(allRatingsForX);

        cars.add(car2);

        return cars;
    }

}
