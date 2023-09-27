package com.thinhle.democrm.rest;

import com.thinhle.democrm.entity.Employee;
import com.thinhle.democrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        Employee employee = employeeService.getById(id);

        if (employee == null) {
            throw new RuntimeException("Not Found employee " + id);
        }
        return employee;
    }

    @PostMapping()
    public Employee create(@RequestBody Employee employee) {
        employee.setId(0);

        Employee newEmployee = employeeService.save(employee);

        return newEmployee;
    }

    @PutMapping()
    public Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        Employee emp = employeeService.getById(id);
        if (emp == null) {
            throw new RuntimeException("Not Found employee " + id);
        }

        employeeService.delete(id);
        return "Deleted employee " + id;
    }
}
