package com.projectTBS.employeesmicroservice.controller;

import com.projectTBS.employeesmicroservice.dto.DepartementDTO;
import com.projectTBS.employeesmicroservice.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/departments")
@CrossOrigin
public class DepartementController {

    @Autowired
    private DepartementService departmentService;


    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public DepartementDTO createDepartment(@RequestBody DepartementDTO departmentDTO) {
        return departmentService.createDepartment(departmentDTO);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<DepartementDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public DepartementDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public DepartementDTO updateDepartment(@PathVariable Long id, @RequestBody DepartementDTO updatedDepartmentDTO) {
        return departmentService.updateDepartment(id, updatedDepartmentDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
