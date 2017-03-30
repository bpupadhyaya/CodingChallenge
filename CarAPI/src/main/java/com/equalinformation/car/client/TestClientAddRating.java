package com.equalinformation.car.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by bpupadhyaya on 3/29/17.
 */
public class TestClientAddRating {
    public static void main(String...args) {
        String carID = "M1";

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/tesla/api/ratings/add").path(carID);

        JSONObject inputJSONObj = new JSONObject();

        try {
            inputJSONObj.put("reviewedBy", "Bhim");
            inputJSONObj.put("safety","5");
            inputJSONObj.put("performance", "4");
            inputJSONObj.put("technology", "5");
            inputJSONObj.put("interior", "4");
            inputJSONObj.put("reliability", "3");

            ClientResponse response = webResource.accept("application/json").put(ClientResponse.class, inputJSONObj);

            String jsonResponseString = response.getEntity(String.class);
            System.out.println("Response: " + jsonResponseString);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

