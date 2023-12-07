package com.projectTBS.employeesmicroservice.service;


import com.projectTBS.employeesmicroservice.dto.EmployeeDTO;
import com.projectTBS.employeesmicroservice.entity.EmployeeInfo;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    EmployeeDTO getUserInfoByUsername(String email);
    void deleteEmployee(Long id);

    List<EmployeeInfo> getEmployeesByRole(String role);
}
