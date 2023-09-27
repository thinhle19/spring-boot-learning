package com.thinhle.democrm.service;

import com.thinhle.democrm.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
