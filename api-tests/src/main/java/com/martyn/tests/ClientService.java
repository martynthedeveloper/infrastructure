package com.martyn.tests;

import com.sun.jersey.api.client.ClientResponse;
import org.springframework.stereotype.Service;

import static com.sun.jersey.api.client.ClientResponse.Status.OK;
import static java.lang.String.format;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Service
public class ClientService {

    String httpGetForReport(String url) {
        String result = "";

        try {
            result += "\nTesting " + url + " " + httpGetForJson(url);
        } catch (RuntimeException e) {
            result += " -> " + e.getMessage();
        }
        result += "\n";

        return result;
    }

    String httpGetForJson(String endpoint) {

        System.out.println(format("GET %s", endpoint));
        ClientResponse clientResponse = com.sun.jersey.api.client.Client.create().resource(endpoint).type(APPLICATION_JSON).get(ClientResponse.class);

        String json;

        if (!clientResponse.getClientResponseStatus().equals(OK)) {
            json = format("{ \"statusCode\":\"%s\",\"body\":\"%s\"}", clientResponse.getClientResponseStatus().getStatusCode(), clientResponse.getEntity(String.class));
        } else {
            json = clientResponse.getEntity(String.class);
        }

        System.out.println(format("Response -> %s", json));

        return json;
    }
}