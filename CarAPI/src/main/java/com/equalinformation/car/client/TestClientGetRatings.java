package com.equalinformation.car.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by bpupadhyaya on 3/27/17.
 * Note: This test class should be replaced by unit tests and/or system tests
 */
public class TestClientGetRatings {
    public static void main(String...args) {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/tesla/api/ratings");

        ClientResponse response = webResource.accept("application/json")
                                            .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String jsonString = response.getEntity(String.class);

        System.out.println("JSON for List of Cars: "+jsonString);
    }
}
