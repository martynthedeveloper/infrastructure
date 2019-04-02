package com.martyn.frontend;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import org.springframework.web.bind.annotation.*;

import static com.sun.jersey.api.client.ClientResponse.Status.OK;
import static java.lang.String.format;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("proxy")
public class ProxyController {

    @GetMapping
    public String proxy() {

        String host = System.getenv("STARTER_REST_API_SERVICE_HOST");
        String port = System.getenv("STARTER_REST_API_SERVICE_PORT");

        String url = "http://127.0.0.1:8888/";

        if(host != null && port != null){
            url = "http://" + host + ":" + port + "/";
        }

        try {
//            return new DepartmentClient(url).allDepartments();
            return "";

        } catch (RuntimeException e) {
            return url + " -> " + e.getMessage();
        }
    }

    @ResponseStatus(value = NOT_ACCEPTABLE, reason = "Doh!")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println("Doh! " + e.getMessage());
    }
}