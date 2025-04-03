package com.p1.EmpManagement.Service;

import com.p1.EmpManagement.Entity.Employee;
import com.p1.EmpManagement.Repo.Emp_Repo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class EMP_Service implements Service{

    @Autowired
    Emp_Repo er;

    @Override
    public Employee create(Employee employee) {
        return er.save(employee);
    }


    @Override
    public List<Employee> saveAll(List<Employee> employees) {
        return er.saveAll(employees);
    }

    @Override
    public List<Employee> getall() {
        return er.findAll();
    }

    @Override
    public Employee getbyid(Long id) {
        return er.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
    }

    @Override
    public List<Employee> getbysalary(Double salary) {
        return er.findbysalary(salary);
    }

    @Override
    public List<Employee> getbysalrange(Double minsalary, Double maxsalary) {
        return er.findbysalrange(minsalary, maxsalary);
    }

    @Override
    public List<Employee> getbyloc(String location) {
        return er.findbyloc(location);
    }

    @Override
    public List<Employee> getbyjob(String job) {
        return er.findbyjob(job);
    }

    @Override
    public List<Employee> getbyjoindate(LocalDate joindate) {
        return er.findbyjoindate(joindate);
    }

    @Transactional
    @Override
    public Employee updatebyid(Long id, Employee employee) {

        Employee emp = er.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
            emp.setName(employee.getName());
            emp.setLocation(employee.getLocation());
            emp.setJob(employee.getJob());
            emp.setSalary(employee.getSalary());
            return er.save(emp);
    }

    @Override
    public void deletebyid(Long id) {
        er.deleteById(id);
    }

}
