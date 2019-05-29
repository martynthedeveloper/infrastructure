package com.martyn.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("/api-tests/tests") // TODO config prefix in application.yml
public class TestsController {

    private final ClientService clientService;
    private final String backendUrl;
    private final String frontendUrl;


    @Autowired
    public TestsController(ClientService clientService,
                           @Value("${backend.host}") String backendHost, @Value("${backend.port}") String backendPort,
                           @Value("${frontend.host}") String frontendHost, @Value("${frontend.port}") String frontendPort
    ) {
        this.clientService = clientService;

        backendUrl = "http://" + backendHost + ":" + backendPort + "/api-backend/departments";
        System.out.println(format("backendUrl=%s", backendUrl));

        frontendUrl = "http://" + frontendHost + ":" + frontendPort + "/api-frontend/departments";
        System.out.println(format("frontendUrl=%s", frontendUrl));
    }

    @GetMapping
    public String tests() {

        String result = "Testing ...\n";
        result += clientService.httpGetForReport("backend", backendUrl) + "\n";
        result += clientService.httpGetForReport("frontend", frontendUrl) + "\n";
        return result;
    }

    @ResponseStatus(value = NOT_ACCEPTABLE, reason = "Doh!")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println("Doh! " + e.getMessage());
    }
}