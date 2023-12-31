package com.thinhle.democrm.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        //typed for auto casting type, rather than manually casting from Object when using normal query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee getById(int id) {
        var result = entityManager.find(Employee.class, id);

        return result;
    }

    @Override
    public Employee save(Employee employee) {
        var result = entityManager.merge(employee);
        return result;
    }

    @Override
    public void delete(int id) {
        var employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);
    }
}
