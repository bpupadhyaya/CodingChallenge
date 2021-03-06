package com.equalinformation.car.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by bpupadhyaya on 3/28/17.
 */
public class TestClientAddCar {
    public static void main(String...args) {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/tesla/api/cars/add");

        JSONObject inputJSONObj = new JSONObject();

        try {
            inputJSONObj.put("carID", "M1");
            inputJSONObj.put("make","Tesla");
            inputJSONObj.put("model", "Z");
            inputJSONObj.put("year", "2018");

            ClientResponse response = webResource.accept("application/json").put(ClientResponse.class, inputJSONObj);

            String jsonResponseString = response.getEntity(String.class);
            System.out.println("Response: " + jsonResponseString);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
