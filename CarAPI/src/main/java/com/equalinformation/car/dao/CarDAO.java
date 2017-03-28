package com.equalinformation.car.dao;

import com.equalinformation.car.model.Car;
import com.equalinformation.car.model.Rating;

import java.util.List;

/**
 * Created by bpupadhyaya on 3/27/17.
 */
public interface CarDAO {
    public List<Car> getCars();
    public List<Rating> getRatings();
    public boolean addCar();
    public boolean deleteCar();
}
