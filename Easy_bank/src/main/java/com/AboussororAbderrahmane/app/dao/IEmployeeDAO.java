package com.AboussororAbderrahmane.app.dao;

import com.AboussororAbderrahmane.app.entities.Employee;
import com.AboussororAbderrahmane.app.entities.Person;

import java.util.Optional;

public interface IEmployeeDAO<T> extends IPersonDAO<T> {
    Optional<Employee> findByPhoneNumber(String phoneNumber);
}
