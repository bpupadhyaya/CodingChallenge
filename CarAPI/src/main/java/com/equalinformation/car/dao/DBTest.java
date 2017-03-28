package com.equalinformation.car.dao;

import com.equalinformation.car.model.Car;

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

        getCars();

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

    private static boolean insertCar() {
        //TODO
        return false; //TODO
    }

    private static boolean deleteCar() {
        //TODO

        return false; // TODO
    }

    private static boolean insertRating() {
        //TODO
        return false; //TODO
    }

    private static boolean deleteRating() {
        //TODO

        return false; // TODO
    }
}
