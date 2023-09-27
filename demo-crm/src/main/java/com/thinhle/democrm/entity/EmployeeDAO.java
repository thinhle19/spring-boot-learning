package com.thinhle.democrm.entity;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();

    Employee getById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
