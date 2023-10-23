package com.AboussororAbderrahmane.app.services;


import com.AboussororAbderrahmane.app.daoImplementaion.EmployeeDAOImp;
import com.AboussororAbderrahmane.app.entities.Employee;

import java.util.Collections;
import java.util.List;

public class EmployeeService {

    private final EmployeeDAOImp employeeDAOImp;

    public EmployeeService(EmployeeDAOImp instance) {
        employeeDAOImp = instance;
    }

    public Employee save(Employee employee) {

        return employeeDAOImp.save(employee).orElse(null);

    }

    public  boolean delete(String code) {

        return employeeDAOImp.delete(code);
    }

    public List<Employee> findAll() {

        return employeeDAOImp.findAll().orElse(Collections.emptyList());
    }

    public  Employee findByCode(String code) {

        return employeeDAOImp.findByCode(code).orElse(null);
    }

    public  Employee findByPhoneNumber(String phoneNumber) {

        return employeeDAOImp.findByPhoneNumber(phoneNumber).orElse(null);
    }

    public  boolean update(Employee employee) {

        return employeeDAOImp.update(employee);
    }

}
