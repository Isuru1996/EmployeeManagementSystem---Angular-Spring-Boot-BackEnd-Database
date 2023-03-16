package com.isuru.EmployeeManagementSystemAPI.controller;

import com.isuru.EmployeeManagementSystemAPI.dto.EmployeeDTO;
import com.isuru.EmployeeManagementSystemAPI.dto.EmployeeSaveDTO;
import com.isuru.EmployeeManagementSystemAPI.dto.EmployeeUpdateDTO;
import com.isuru.EmployeeManagementSystemAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO){
        String name=employeeService.saveEmployee(employeeSaveDTO);
        return name;
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeDTO> employeeDTOS=employeeService.getAllEmployees();
        return employeeDTOS;
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO){
        String updateStatus=employeeService.updateEmployee(employeeUpdateDTO);
        return updateStatus;
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value="id") Long id){
        String deleteStatus=employeeService.deleteEmployee(id);
        return deleteStatus;
    }
}
