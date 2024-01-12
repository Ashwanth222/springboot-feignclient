package com.springboot.springbootfeignclient.repository;

import com.springboot.springbootfeignclient.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}

