package org.geektimes.rest.demo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class RestClientDemo {

    public static void main(String[] args) {
//        Client client = ClientBuilder.newClient();
//        Response response = client
//                .target("http://127.0.0.1:8080/hello/world")      // WebTarget
//                .request() // Invocation.Builder
//                .get();                                     //  Response
//
//        String content = response.readEntity(String.class);
//
//        System.out.println(content);

        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://127.0.0.1:8080/hello/world1")      // WebTarget
                .request() // Invocation.Builder
                .post(Entity.entity("{\"value\":\"123456\"}", "application/json"));                                     //  Response

        String content = response.readEntity(String.class);

        System.out.println(content);

    }
}
