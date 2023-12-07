package com.projectTBS.employeesmicroservice.service;

import com.projectTBS.employeesmicroservice.dto.DepartementDTO;

import java.util.List;

public interface DepartementService {

    DepartementDTO createDepartment(DepartementDTO departmentDTO);

    List<DepartementDTO> getAllDepartments();

    public DepartementDTO getDepartmentById(Long id);

    public DepartementDTO updateDepartment(Long id, DepartementDTO updatedDepartmentDTO);
    public void deleteDepartment(Long id);
}
