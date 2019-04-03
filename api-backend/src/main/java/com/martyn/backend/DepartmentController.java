package com.martyn.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public Collection<Department> allDepartments() {
        return departmentService.allDepartments();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @ResponseStatus(value = NOT_FOUND, reason = "Doh!")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println("Doh! " + e.getMessage());
    }
}