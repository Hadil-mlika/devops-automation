package com.projectTBS.employeesmicroservice.mapper.implementation;

import com.projectTBS.employeesmicroservice.dto.DepartementDTO;
import com.projectTBS.employeesmicroservice.dto.EmployeeDTO;
import com.projectTBS.employeesmicroservice.entity.Departement;
import com.projectTBS.employeesmicroservice.entity.EmployeeInfo;
import com.projectTBS.employeesmicroservice.mapper.DepartementMapper;
import com.projectTBS.employeesmicroservice.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DepartementMapperImpl implements DepartementMapper {

    @Autowired
private EmployeeMapper employeeMapper;
    @Override
    public DepartementDTO convertToDTO(Departement department) {

        if (department == null) {

            return null;
        }

        DepartementDTO departmentDTO = new DepartementDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());


        List<EmployeeDTO> employeeDTOs = (department.getEmployees() != null && employeeMapper != null)
                ? department.getEmployees().stream()
                .map(employeeMapper::mapEmployeeToEmployeeDTO)
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                : Collections.emptyList();

        departmentDTO.setEmployees(employeeDTOs);



        return departmentDTO;
    }
    @Override
    public Departement convertToEntity(DepartementDTO departmentDTO) {
        Departement department = new Departement();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());

        return department;
    }
}
