package com.equalinformation.car.dao;

import com.equalinformation.car.model.Car;
import com.equalinformation.car.model.Rating;

import java.util.List;

/**
 * Created by bpupadhyaya on 3/27/17.
 */
public interface CarDAO {
    List<Car> getCarsOnly();
    List<Car> getRatings();
    boolean addCar(Car car);
    boolean deleteCar(String vin);
    boolean addRating(String vin, Rating rating);
    boolean deleteRating(String vin, String reviewedBy);
    Car getACarOnly(String vin);
    List<Car> getACarRatings(String vin);

}
