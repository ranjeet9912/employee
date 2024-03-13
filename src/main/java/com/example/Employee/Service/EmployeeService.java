package com.example.Employee.Service;

import com.example.Employee.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getEployee();

    Employee updateEmployee(int id, Employee employee);

    String deleteEmp(int id);
}
