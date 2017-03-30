package com.equalinformation.car.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by bpupadhyaya on 3/29/17.
 */
public class TestClientDeleteRating {
    public static void main(String...args) {
        String carID = "M1";

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/tesla/api/ratings/delete").path(carID);

        JSONObject inputJSONObj = new JSONObject();

        try {
            inputJSONObj.put("reviewedBy", "Bhim");

            ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class, inputJSONObj);

            String jsonResponseString = response.getEntity(String.class);
            System.out.println("Response: " + jsonResponseString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
