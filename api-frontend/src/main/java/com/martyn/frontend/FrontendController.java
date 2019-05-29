package com.martyn.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("/api-frontend/departments") // TODO config prefix in application.yml
public class FrontendController {

    private final ClientService clientService;
    private final String backendUrl;

    @Autowired
    public FrontendController(ClientService clientService, @Value("${backend.host}") String backendHost, @Value("${backend.port}") String backendPort) {
        this.clientService = clientService;
        backendUrl = "http://" + backendHost + ":" + backendPort + "/api-backend/departments";
        System.out.println(format("backendUrl=%s", backendUrl));
    }

    @GetMapping
    public String frontend() {
        return clientService.httpGetForJson(backendUrl);
    }

    @ResponseStatus(value = NOT_ACCEPTABLE, reason = "Doh!")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println("Doh! " + e.getMessage());
    }
}