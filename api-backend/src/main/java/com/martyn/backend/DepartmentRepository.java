package com.martyn.backend;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
class DepartmentRepository {

    private final ConcurrentHashMap<Integer, Department> departments = new ConcurrentHashMap<>();
    private final AtomicInteger maxId = new AtomicInteger();

    public DepartmentRepository() {
        createDepartment(new Department(0, "IT Department", "UK"));
    }

    Collection<Department> allDepartments() {
        return departments.values();
    }

    Department createDepartment(Department department) {
        Integer id = maxId.getAndIncrement();
        department.setId(id);

        departments.put(id, department);

        return department;
    }
}
