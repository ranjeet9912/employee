package com.example.Employee.serviceImpl;
import com.example.Employee.Model.Employee;
import com.example.Employee.Service.EmployeeService;
import com.example.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getEployee() {
        return this.employeeRepository.findAll();
    }
    @Override
    public Employee updateEmployee(int id, Employee employee) {
     Employee emp1 = this.employeeRepository.findById(id).orElse(null);
     emp1.setFirstName(employee.getFirstName());
     emp1.setLastName(employee.getLastName());
     emp1.setEmail(employee.getEmail());
     return this.employeeRepository.save(emp1);
    }

    @Override
    public String deleteEmp(int id) {
        this.employeeRepository.deleteById(id);
        return  "Employee with Id "+id+" is deleted successfully";

    }
}
