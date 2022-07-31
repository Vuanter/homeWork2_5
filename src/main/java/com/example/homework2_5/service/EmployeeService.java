package com.example.homework2_5.service;

import org.springframework.stereotype.Service;
import com.example.homework2_5.exception.EmployeeAlreadyAddedException;
import com.example.homework2_5.exception.EmployeeNotFoundException;
import com.example.homework2_5.exception.EmployeeStorageIsFullException;
import com.example.homework2_5.employee.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
            throw new EmployeeStorageIsFullException();
        }

    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee removeEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }
}

