package com.martyn.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    Collection<Department> allDepartments() {
        return departmentRepository.allDepartments();
    }

    Department createDepartment(Department department) {
        return departmentRepository.createDepartment(department);
    }

}
