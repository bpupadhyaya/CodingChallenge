package com.equalinformation.car.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by bpupadhyaya on 3/29/17.
 */
public class TestClientGetACarRatings {
    public static void main(String...args) {
        String carID = "S1";

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/tesla/api/ratings").path(carID);

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String jsonString = response.getEntity(String.class);

        System.out.println("Response: "+jsonString);
    }
}
