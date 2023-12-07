package com.projectTBS.employeesmicroservice.mapper.implementation;

import com.projectTBS.employeesmicroservice.dto.EmployeeDTO;
import com.projectTBS.employeesmicroservice.entity.EmployeeInfo;
import com.projectTBS.employeesmicroservice.mapper.EmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public EmployeeDTO mapEmployeeToEmployeeDTO(EmployeeInfo employee) {
        if (employee == null) {

            return null;
        }
        EmployeeDTO dto = new EmployeeDTO();
        dto.setPassword(employee.getPassword());
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setRole(employee.getRole());
        dto.setEmail(employee.getEmail());

        dto.setDepartmentId(employee.getDepartment() != null ? employee.getDepartment().getId() : null);
        return dto;
    }

    @Override
    public EmployeeInfo mapEmployeeDTOToEmployee(EmployeeDTO dto) {
        EmployeeInfo employee = new EmployeeInfo();
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setRole(dto.getRole());
        employee.setEmail(dto.getEmail());
        employee.setPassword(dto.getPassword());

        return employee;
    }
}
