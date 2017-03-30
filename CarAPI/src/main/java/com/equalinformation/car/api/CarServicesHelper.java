package com.equalinformation.car.api;

import com.equalinformation.car.model.Car;
import com.equalinformation.car.model.Rating;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by bpupadhyaya on 3/29/17.
 */
public class CarServicesHelper {

    public void createCarObj(JSONObject inputJSONObj, Car car) {
        try {
            String carID =  (String) inputJSONObj.get("carID");
            String make = (String) inputJSONObj.get("make");
            String model = (String) inputJSONObj.get("model");
            String year = (String) inputJSONObj.get("year");

            car.setCarID(carID);
            car.setMake(make);
            car.setModel(model);
            car.setYear(year);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void createRatingObj(JSONObject inputJSONObj, Rating rating) {
        try {
            String reviewedBy = (String) inputJSONObj.get("reviewedBy");
            int safety = Integer.parseInt((String) inputJSONObj.get("safety"));
            int performance = Integer.parseInt((String) inputJSONObj.get("performance"));
            int technology = Integer.parseInt((String) inputJSONObj.get("technology"));
            int interior = Integer.parseInt((String) inputJSONObj.get("interior"));
            int reliability = Integer.parseInt((String) inputJSONObj.get("reliability"));

            rating.setReviewedBy(reviewedBy);
            rating.setSafety(safety);
            rating.setPerformance(performance);
            rating.setTechnology(technology);
            rating.setInterior(interior);
            rating.setReliability(reliability);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
