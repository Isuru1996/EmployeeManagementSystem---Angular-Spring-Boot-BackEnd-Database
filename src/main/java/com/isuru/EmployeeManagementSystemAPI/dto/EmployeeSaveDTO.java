package com.isuru.EmployeeManagementSystemAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSaveDTO {
    private String name;
    private String designation;
    private int salary;
}
