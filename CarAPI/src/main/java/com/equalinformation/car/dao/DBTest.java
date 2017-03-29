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
 * Created by bpupadhyaya on 3/28/17.
 */
public class DBTest {


    public static void main(String...args) throws SQLException {

//        getCars();

/*        Car car = new Car();
        car.setCarID("M1");
        car.setMake("Tesla");
        car.setModel("Z");
        car.setYear("2018");
        addCar(car);*/

//        deleteCar("M1");

        Rating rating = new Rating();
        rating.setReviewedBy("Bhim");
        rating.setSafety(4);
        rating.setPerformance(5);
        rating.setTechnology(5);
        rating.setInterior(4);
        rating.setReliability(5);
        addRating("M1",rating);

//        deleteRating("M1","Bhim");

    }

    private static List<Car> getCars() throws SQLException {
        DBUtil dbUtil = new DBUtil();
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

                System.out.println("vin: "+vin);

                Car car = new Car();
                car.setCarID(vin);
                car.setMake(make);
                car.setModel(model);
                car.setYear(year);

                cars.add(car);
            }

            for (Car car: cars) {
                System.out.println("year: "+car.getYear());
            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }

        }

        return cars;
    }

    private static List<Car> getRatings() throws SQLException {
        //TODO

        return null; //TODO
    }

    private static boolean addCar(Car car) {
        DBUtil dbUtil = new DBUtil();
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

    private static boolean deleteCar(String vin) {
        DBUtil dbUtil = new DBUtil();
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

    private static boolean addRating(String vin, Rating rating) {
        DBUtil dbUtil = new DBUtil();
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
            System.out.println("status: "+status);

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

    private static boolean deleteRating(String vin, String reviewedBy) {
        DBUtil dbUtil = new DBUtil();
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
