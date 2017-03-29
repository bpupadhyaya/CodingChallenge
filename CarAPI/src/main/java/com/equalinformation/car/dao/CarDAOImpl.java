package com.equalinformation.car.dao;

import com.equalinformation.car.model.Car;
import com.equalinformation.car.model.Rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpupadhyaya on 3/27/17.
 */
public class CarDAOImpl implements CarDAO {
    DBUtil dbUtil = new DBUtil();


    public List<Car> getCarsOnly() {
        List<Car> cars = new ArrayList<Car>();

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectCarQuery = "SELECT VIN, MAKE, MODEL, YEAR FROM CAR";

        try {
            dbConnection = dbUtil.getConnection();
            preparedStatement = dbConnection.prepareStatement(selectCarQuery);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                String vin = rs.getString("VIN");
                String make = rs.getString("MAKE");
                String model = rs.getString("MODEL");
                String year = rs.getString("YEAR");

                Car car = new Car();
                car.setCarID(vin);
                car.setMake(make);
                car.setModel(model);
                car.setYear(year);

                cars.add(car);
            }


        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }

        }

        return cars;
    }

    public List<Car> getRatings() {
        List<Car> cars = new ArrayList<Car>();

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectCarRatingQuery = "SELECT CAR.VIN, CAR.MAKE, CAR.MODEL, CAR.YEAR," +
                "  RATING.REVIEWEDBY, RATING.SAFETY, RATING.PERFORMANCE, RATING.TECHNOLOGY, RATING.INTERIOR, RATING.RELIABILITY" +
                " FROM RATING" +
                " INNER JOIN CAR ON RATING.VIN = CAR.VIN";

        try {
            dbConnection = dbUtil.getConnection();
            preparedStatement = dbConnection.prepareStatement(selectCarRatingQuery);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                String vin = rs.getString("VIN");
                String make = rs.getString("MAKE");
                String model = rs.getString("MODEL");
                String year = rs.getString("YEAR");

                String reviewedBy = rs.getString("REVIEWEDBY");
                int safety = rs.getInt("SAFETY");
                int performance = rs.getInt("PERFORMANCE");
                int technology = rs.getInt("TECHNOLOGY");
                int interior = rs.getInt("INTERIOR");
                int reliability = rs.getInt("RELIABILITY");
                List<Rating> ratings = new ArrayList<Rating>();
                Rating rating = new Rating();
                rating.setReviewedBy(reviewedBy);
                rating.setSafety(safety);
                rating.setPerformance(performance);
                rating.setTechnology(technology);
                rating.setInterior(interior);
                rating.setReliability(reliability);
                ratings.add(rating);

                Car car = new Car();
                car.setCarID(vin);
                car.setMake(make);
                car.setModel(model);
                car.setYear(year);
                car.setRatings(ratings);

                cars.add(car);
            }


        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }

        }

        return cars;
    }

    public boolean addCar(Car car) {
        int status = -1;
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectCarQuery = "INSERT INTO CAR(VIN, MAKE, MODEL, YEAR)" +
                " VALUES(?, ?, ?, ?)";

        try {
            dbConnection = dbUtil.getConnection();
            preparedStatement = dbConnection.prepareStatement(selectCarQuery);

            preparedStatement.setString(1, car.getCarID());
            preparedStatement.setString(2, car.getMake());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setString(4, car.getYear());

            status = preparedStatement.executeUpdate(); // row count or 0

        } catch(Exception e) {
            e.printStackTrace();
        }

        if(status > -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteCar(String vin) {
        int status = -1;
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectCarQuery = "DELETE FROM CAR WHERE VIN = ?";

        try {
            dbConnection = dbUtil.getConnection();
            preparedStatement = dbConnection.prepareStatement(selectCarQuery);
            preparedStatement.setString(1,vin);

            status = preparedStatement.executeUpdate(); // row count or 0

        } catch(Exception e) {
            e.printStackTrace();
        }

        if(status > -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addRating(String vin, Rating rating) {
        int status = -1;
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectCarQuery = "INSERT INTO RATING(REVIEWEDBY, SAFETY, PERFORMANCE, TECHNOLOGY, INTERIOR, RELIABILITY, VIN)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            dbConnection = dbUtil.getConnection();
            preparedStatement = dbConnection.prepareStatement(selectCarQuery);

            preparedStatement.setString(1, rating.getReviewedBy());
            preparedStatement.setInt(2, rating.getSafety());
            preparedStatement.setInt(3, rating.getPerformance());
            preparedStatement.setInt(4, rating.getTechnology());
            preparedStatement.setInt(5, rating.getInterior());
            preparedStatement.setInt(6, rating.getReliability());
            preparedStatement.setString(7, vin);

            status = preparedStatement.executeUpdate(); // row count or 0

        } catch(Exception e) {
            e.printStackTrace();
        }

        if(status > -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteRating(String vin, String reviewedBy) {
        int status = -1;
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectCarQuery = "DELETE FROM RATING WHERE VIN = ? AND REVIEWEDBY = ?";

        try {
            dbConnection = dbUtil.getConnection();
            preparedStatement = dbConnection.prepareStatement(selectCarQuery);
            preparedStatement.setString(1,vin);
            preparedStatement.setString(2, reviewedBy);

            status = preparedStatement.executeUpdate(); // row count or 0

        } catch(Exception e) {
            e.printStackTrace();
        }

        if(status > -1) {
            return true;
        }
        else {
            return false;
        }
    }

}
