package com.equalinformation.car.api;

import com.equalinformation.car.dao.CarDAOImpl;
import com.equalinformation.car.model.Car;
import com.equalinformation.car.model.CarRatingData;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
            return dbCarData.getCars();
        } else {
            return staticCarData.getCars();
        }
    }





/*
    @POST
    @Produces("application/x-www-form-urlencoded")
    @Consumes("application/x-www-form-urlencoded")
    @Path("/addCar")
    public Form addCar(@FormParam("carID") String carID,
                              @FormParam("data2") String data2,
                              @FormParam("data3") String data3,
                              @FormParam("data4") String data4){


        Form form = new Form();
        form.add("data1", carID+" :s1");
        form.add("data2", data2+" :s2");
        form.add("data3", data3+" :s3");
        form.add("data4", data4+" :s4");

        return form;
    }*/

}
