package com.martyn.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.getenv;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("/api-tests/tests") // TODO config prefix in application.yml
public class TestsController {

    private final ClientService clientService;

    @Autowired
    public TestsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String tests() {

        String result = "Testing ...\n";
        result += clientService.httpGetForReport("backend","http://api-backend/" + getenv("API_FRONTEND_SERVICE_HOST") + ":" + getenv("API_FRONTEND_SERVICE_PORT") + "/departments") + "\n";
        result += clientService.httpGetForReport("frontend","http://api-frontend/" + getenv("API_BACKEND_SERVICE_HOST") + ":" + getenv("API_BACKEND_SERVICE_PORT") + "/departments") + "\n";
        return result;
    }

    @ResponseStatus(value = NOT_ACCEPTABLE, reason = "Doh!")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println("Doh! " + e.getMessage());
    }
}