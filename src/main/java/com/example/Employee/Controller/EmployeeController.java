package com.example.Employee.Controller;

import com.example.Employee.Model.Employee;
import com.example.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @PostMapping("/addEmployee")
    public Employee addEmplyee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/getEmployee")
    public List<Employee> getEmployee(){
        return this.employeeService.getEployee();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        return this.employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/delete/{id}")
    public  String deleteEmp(@PathVariable int id){

      return this.employeeService.deleteEmp(id);

    }
}

