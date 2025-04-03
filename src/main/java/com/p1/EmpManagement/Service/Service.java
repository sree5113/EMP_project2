package com.p1.EmpManagement.Service;

import com.p1.EmpManagement.Entity.Employee;

import java.time.LocalDate;

import java.util.List;

public interface Service {
    Employee create(Employee employee);

    List<Employee> saveAll(List<Employee> employees);

    List<Employee> getall();

    Employee getbyid(Long id);

    List<Employee> getbysalary(Double salary);

    List<Employee> getbysalrange(Double minsalary, Double maxsalary);

    List<Employee> getbyloc(String location);

    List<Employee> getbyjob(String job);

    List<Employee>getbyjoindate(LocalDate joindate);

    Employee updatebyid(Long id, Employee employee);


    void deletebyid(Long id);
}


