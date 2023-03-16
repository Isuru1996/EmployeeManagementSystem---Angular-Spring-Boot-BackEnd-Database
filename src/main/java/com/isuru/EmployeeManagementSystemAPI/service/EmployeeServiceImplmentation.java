package com.isuru.EmployeeManagementSystemAPI.service;

import com.isuru.EmployeeManagementSystemAPI.dto.EmployeeDTO;
import com.isuru.EmployeeManagementSystemAPI.dto.EmployeeSaveDTO;
import com.isuru.EmployeeManagementSystemAPI.dto.EmployeeUpdateDTO;
import com.isuru.EmployeeManagementSystemAPI.entity.Employee;
import com.isuru.EmployeeManagementSystemAPI.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplmentation implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public String saveEmployee(EmployeeSaveDTO employeeSaveDTO) {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeSaveDTO,employee);
        employeeRepository.save(employee);
        return employee.getName();
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();

//        List<EmployeeDTO> employees=employeeEntities.stream()
//                .map(emp->new EmployeeDTO(emp.getId(),emp.getName(),emp.getDesignation(),emp.getSalary()))
//                .collect(Collectors.toList());
        List<EmployeeDTO> employeeDTOS=new ArrayList<>();
        for(Employee a:employees){
            EmployeeDTO employeeDTO=new EmployeeDTO(
                    a.getId(),
                    a.getName(),
                    a.getDesignation(),
                    a.getSalary()
            );

            employeeDTOS.add(employeeDTO);
        }
        return employeeDTOS;
    }

    @Override
    public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        if(employeeRepository.existsById(employeeUpdateDTO.getId())) {
            Employee employee = employeeRepository.findById(employeeUpdateDTO.getId()).get();
            employee.setName(employeeUpdateDTO.getName());
            employee.setDesignation(employeeUpdateDTO.getDesignation());
            employee.setSalary(employeeUpdateDTO.getSalary());
            employeeRepository.save(employee);
            return "Update success";
        }
        else{
            return "Id not exist";
        }

    }

    @Override
    public String deleteEmployee(Long id) {
        if(employeeRepository.existsById(id)){
            Employee employee = employeeRepository.findById(id).get();
            employeeRepository.delete(employee);
            return "delete success";
        }
        else{
            return "Id not exist";
        }
    }
}
