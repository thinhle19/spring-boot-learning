package com.thinhle.democrm.service;

import com.thinhle.democrm.dao.EmployeeRepository;
import com.thinhle.democrm.entity.Employee;
import com.thinhle.democrm.entity.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //    private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Not Found Employee " + id);
        }

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
