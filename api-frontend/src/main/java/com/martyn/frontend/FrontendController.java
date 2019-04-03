package com.martyn.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.getenv;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("departments")
public class FrontendController {

    private final ClientService clientService;

    @Autowired
    public FrontendController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String frontend() {
       return clientService.httpGetForJson("http://" + getenv("API_BACKEND_SERVICE_HOST") + ":" + getenv("API_BACKEND_SERVICE_PORT") + "/departments") + "\n";
    }

    @ResponseStatus(value = NOT_ACCEPTABLE, reason = "Doh!")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println("Doh! " + e.getMessage());
    }
}