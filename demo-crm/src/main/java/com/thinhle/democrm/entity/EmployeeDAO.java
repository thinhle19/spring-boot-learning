package com.thinhle.democrm.entity;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();

    Employee getById();

    void add();

    void update();

    int delete();
}
