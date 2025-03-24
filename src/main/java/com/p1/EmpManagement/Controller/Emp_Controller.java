package com.p1.EmpManagement.Controller;

import com.p1.EmpManagement.Entity.Employee;
import com.p1.EmpManagement.Service.EMP_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/emp")
public class Emp_Controller {
    @Autowired
    EMP_Service es;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        Employee create = es.create(employee);
        return new ResponseEntity<>(create, HttpStatus.OK);
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> createMultipleEmployees(@RequestBody List<Employee> employees) {
        List<Employee> savedEmployees = es.saveAll(employees);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Employees added successfully", "count", savedEmployees.size()));
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getall(){
        List<Employee> employees = es.getall();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getbyid(@PathVariable Long id){
        Employee getbyid = es.getbyid(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @GetMapping("/sal/{salary}")
    public ResponseEntity<List<Employee>> getbysal(@PathVariable Double salary){
        List<Employee> employees = es.getbysalary(salary);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/salary/{minSalary}/{maxSalary}")
    public ResponseEntity<List<Employee>> getbysalrange(@PathVariable Double minSalary, @PathVariable Double maxSalary){
        List<Employee> employees = es.getbysalrange(minSalary, maxSalary);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/loc/{location}")
    public ResponseEntity<List<Employee>> getbyloc(@PathVariable String location){
        List<Employee> employees = es.getbyloc(location);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/job/{job}")
    public ResponseEntity<List<Employee>> getbyjob(@PathVariable String job){
        List<Employee> employees = es.getbyjob(job);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> updatebyid(@PathVariable Long id, @RequestBody Employee employee){
        Employee update = es.updatebyid(id, employee);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        es.deletebyid(id);
        return ResponseEntity.noContent().build();
    }

}
