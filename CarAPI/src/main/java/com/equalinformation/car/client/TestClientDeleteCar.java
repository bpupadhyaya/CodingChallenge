package com.equalinformation.car.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by bpupadhyaya on 3/28/17.
 */
public class TestClientDeleteCar {
    public static void main(String...args) {
        String carID = "M1";

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/tesla/api/cars/delete").path(carID);

        ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);

        String jsonString = response.getEntity(String.class);

        System.out.println("Response: "+jsonString);
    }
}
