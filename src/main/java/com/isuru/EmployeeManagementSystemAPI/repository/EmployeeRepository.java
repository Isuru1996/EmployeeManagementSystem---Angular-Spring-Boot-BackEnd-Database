package com.isuru.EmployeeManagementSystemAPI.repository;

import com.isuru.EmployeeManagementSystemAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
