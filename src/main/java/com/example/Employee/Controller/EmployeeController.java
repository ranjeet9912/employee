package com.example.Employee.Controller;

import com.example.Employee.Model.Employee;
import com.example.Employee.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmplyee(@RequestBody Employee employee){
        logger.info("posting data from controller");
         return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.OK);
    }
    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> getEmployee(){
       List<Employee> emp= this.employeeService.getEployee();
        logger.info("Getting data from controller");
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        logger.info("updating data");
        return this.employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/delete/{id}")
    public  String deleteEmp(@PathVariable int id){
        logger.info("deleting data from controller");
      return this.employeeService.deleteEmp(id);

    }
}

