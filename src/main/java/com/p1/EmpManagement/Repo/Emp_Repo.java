package com.p1.EmpManagement.Repo;

import com.p1.EmpManagement.Entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

import java.util.List;

public interface Emp_Repo extends JpaRepository<Employee, Long> {


    // Find employee by salary
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> findbysalary(@Param("salary") Double salary);

    // Find employee by sal range

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary  AND :maxSalary")
    List<Employee> findbysalrange(@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary);


    //Find by location

    @Query("SELECT e FROM Employee e WHERE e.location LIKE %:location%")
    List<Employee> findbyloc(@Param("location") String location);

    //find by job

    @Query("SELECT e FROM Employee e WHERE e.job LIKE %:job%")
    List<Employee> findbyjob(@Param("job") String job);

    @Query("SELECT e FROM Employee e WHERE e.joindate = :joindate")
    List<Employee> findbyjoindate(@Param("joindate") LocalDate joindate);
}



