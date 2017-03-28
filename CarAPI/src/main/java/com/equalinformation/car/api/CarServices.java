package com.equalinformation.car.api;

import com.equalinformation.car.dao.CarDAOImpl;
import com.equalinformation.car.model.Car;
import com.equalinformation.car.model.CarRatingData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by bpupadhyaya on 3/27/17.
 */


@Path("/api")
public class CarServices {
    private CarRatingData staticCarData = new CarRatingData();
    private CarDAOImpl dbCarData = new CarDAOImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ratings")
    public List<Car> getRatings() {
        if (PersistenceCheck.DBREADY) {
            return dbCarData.getRatings();
        } else {
            return staticCarData.getRatings();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cars")
    public List<Car> getCarsOnly() {
        if (PersistenceCheck.DBREADY) {
            return dbCarData.getCarsOnly();
        } else {
            return staticCarData.getCarsOnly();
        }
    }

    // TODO Below is work in progress, so please do not evaluate now.
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cars/{carID}")
    public Response addCar(@PathParam("carID") String carID) {
        String result;
        Car car = new Car();
        populateCarData(carID, car);
        staticCarData.getCarsOnly().add(car);
        result = "Car added: " + car;

        return Response.status(201).entity(result).build();

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cars/{carID}")
    public Response deleteCar(@PathParam("carID") String carID) {
        String result;

        staticCarData.getCarsOnly().remove(getCarsOnly().size()-1);
        result = "Car removed. ";
        System.out.println("New size: "+staticCarData.getCarsOnly().size());

        return Response.status(200).entity(result).build();

    }

    private void populateCarData(String carID, Car car) {
        // This is temporary method till I complete DAO layer.
        if(carID.equalsIgnoreCase("X1")) {
            car.setCarID("X1");
            car.setMake("Tesla");
            car.setModel("X");
            car.setYear("2017");

        } else if(carID.equalsIgnoreCase("S1")) {
            car.setCarID("S1");
            car.setMake("Tesla");
            car.setModel("S");
            car.setYear("2016");
        }
    }


}
