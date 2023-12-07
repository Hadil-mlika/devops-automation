package com.projectTBS.employeesmicroservice.mapper;

import com.projectTBS.employeesmicroservice.dto.DepartementDTO;

import com.projectTBS.employeesmicroservice.entity.Departement;

import org.springframework.stereotype.Component;

@Component
public interface DepartementMapper {

    DepartementDTO convertToDTO(Departement departement);
    Departement convertToEntity(DepartementDTO departementDTO);
}
