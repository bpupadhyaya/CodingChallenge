package com.equalinformation.car.dao;

import com.equalinformation.car.model.Car;

import java.util.List;

/**
 * Created by bpupadhyaya on 3/27/17.
 */
public interface CarDAO {
    List<Car> getCarsOnly();
    List<Car> getRatings();
    boolean addCar(String vin);
    boolean deleteCar(String vin);
    boolean addRating(String vin);
    boolean deleteRating(String vin);

}
