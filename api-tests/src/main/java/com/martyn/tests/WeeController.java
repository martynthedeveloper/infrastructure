package com.martyn.servertests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import org.springframework.web.bind.annotation.*;

import static com.sun.jersey.api.client.ClientResponse.Status.OK;
import static java.lang.String.format;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("tests")
public class WeeController {

    @GetMapping
    public String tests() {

        String result = "Testing ...\n";

        try {
            String url = getURL("STARTER_REST_API_SERVICE_HOST", "STARTER_REST_API_SERVICE_PORT") + "groups";
            result += "\nTesting SERVER " + url + " ";
            result += getForJson(url);
        } catch (RuntimeException e) {
            result += " -> " + e.getMessage();
        }
        result += "\n";


        try {
            String url = getURL("STARTER_REST_API_CLIENT_SERVICE_HOST", "STARTER_REST_API_CLIENT_SERVICE_PORT")  + "proxy";
            result += "\nTesting PROXY " + url + " ";
            result += getForJson(url);
        } catch (RuntimeException e) {
            result += " -> " + e.getMessage();
        }
        result += "\n";


        return result;
    }

    private String getURL(String host, String port) {

        String hostx = System.getenv(host);
        String portx = System.getenv(port);
        return "http://" + hostx + ":" + portx + "/";
    }

    private String getForJson(String endpoint) {
        System.out.println(format("GET %s", endpoint));
        ClientResponse clientResponse = Client.create().resource(endpoint).type(APPLICATION_JSON).get(ClientResponse.class);

        return toJSON(clientResponse);
    }

    private String toJSON(ClientResponse clientResponse) {
        String json;

        if (!clientResponse.getClientResponseStatus().equals(OK)) {
            json = format("{ \"statusCode\":\"%s\",\"body\":\"%s\"}", clientResponse.getClientResponseStatus().getStatusCode(), clientResponse.getEntity(String.class));
        } else {
            json = clientResponse.getEntity(String.class);
        }

        System.out.println(format("Response -> %s", json));

        return json;
    }

    @ResponseStatus(value = NOT_ACCEPTABLE, reason = "Doh!")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println("Doh! " + e.getMessage());
    }
}