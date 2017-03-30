package com.equalinformation.car.api;

import com.equalinformation.car.dao.CarDAOImpl;
import com.equalinformation.car.model.Car;
import com.equalinformation.car.model.CarRatingData;
import com.equalinformation.car.model.Rating;
import org.codehaus.jettison.json.JSONObject;

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
    private CarDAOImpl carDAO = new CarDAOImpl();
    private CarServicesHelper helper = new CarServicesHelper();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cars")
    public List<Car> getCarsOnly() {
        if (PersistenceCheck.DBREADY) {
            return carDAO.getCarsOnly();
        } else {
            return staticCarData.getCarsOnly();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ratings")
    public List<Car> getRatings() {
        if (PersistenceCheck.DBREADY) {
            return carDAO.getRatings();
        } else {
            return staticCarData.getRatings();
        }
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cars/add")
    public Response addCar(JSONObject inputJSONObj) {
        String result;
        Car car = new Car();

        helper.createCarObj(inputJSONObj, car);

        boolean carAdded = carDAO.addCar(car);

        if(carAdded) {
            result = "Car successfully added!";
        } else {
            result = "Car could not be added!";
        }

        return Response.status(201).entity(result).build();

    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cars/delete/{carID}")
    public Response deleteCar(@PathParam("carID") String carID) {
        String result;

        boolean carDeleted = carDAO.deleteCar(carID);

        if(carDeleted) {
            result = "Car successfully deleted!";
        } else {
            result = "Car could not be deleted!";
        }

        return Response.status(200).entity(result).build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ratings/add/{carID}")
    public Response addRating(@PathParam("carID") String carID, JSONObject inputJSONObj) {
        String result;
        Rating rating = new Rating();

        helper.createRatingObj(inputJSONObj, rating);

        boolean ratingAdded = carDAO.addRating(carID,rating);

        if(ratingAdded) {
            result = "Rating successfully added!";
        } else {
            result = "Rating could not be added!";
        }

        return Response.status(201).entity(result).build();

    }



    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ratings/delete/{carID}")
    public Response deleteRating(@PathParam("carID") String carID, JSONObject inputJSONObj) {
        String result;
        String reviewedBy = "";

        try {
            reviewedBy = (String) inputJSONObj.get("reviewedBy");
        } catch(Exception e) {
            e.printStackTrace();
        }

        boolean ratingDeleted = carDAO.deleteRating(carID,reviewedBy);

        if(ratingDeleted) {
            result = "Rating successfully deleted!";
        } else {
            result = "Rating could not be deleted!";
        }

        return Response.status(200).entity(result).build();
    }


}
