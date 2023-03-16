package com.isuru.EmployeeManagementSystemAPI.service;

import com.isuru.EmployeeManagementSystemAPI.dto.EmployeeDTO;
import com.isuru.EmployeeManagementSystemAPI.dto.EmployeeSaveDTO;
import com.isuru.EmployeeManagementSystemAPI.dto.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {
    String saveEmployee(EmployeeSaveDTO employeeSaveDTO);

    List<EmployeeDTO> getAllEmployees();

    String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    String deleteEmployee(Long id);
}
