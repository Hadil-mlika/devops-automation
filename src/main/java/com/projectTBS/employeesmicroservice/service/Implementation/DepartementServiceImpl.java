package com.projectTBS.employeesmicroservice.service.Implementation;

import com.projectTBS.employeesmicroservice.dto.DepartementDTO;
import com.projectTBS.employeesmicroservice.entity.Departement;
import com.projectTBS.employeesmicroservice.mapper.DepartementMapper;
import com.projectTBS.employeesmicroservice.mapper.EmployeeMapper;
import com.projectTBS.employeesmicroservice.repo.DepartementRepository;
import com.projectTBS.employeesmicroservice.repo.EmployeeRepository;
import com.projectTBS.employeesmicroservice.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    private final DepartementMapper departementMapper;


    @Autowired
    public DepartementServiceImpl(DepartementRepository departementRepository, DepartementMapper departementMapper) {
        this.departementRepository = departementRepository;
        this.departementMapper= departementMapper;
    }
@Override
    public DepartementDTO createDepartment(DepartementDTO departmentDTO) {
        Departement department = departementMapper.convertToEntity(departmentDTO);
        Departement savedDepartment = departementRepository.save(department);
        return departementMapper.convertToDTO(savedDepartment);
    }


@Override
    public List<DepartementDTO> getAllDepartments() {
        List<Departement> departments = departementRepository.findAll();
        return departments.stream()
                .map(departementMapper::convertToDTO)
                .collect(Collectors.toList());
    }
@Override
    public DepartementDTO getDepartmentById(Long id) {
        Departement department = departementRepository.findById(id).orElse(null);
        return (department != null) ?departementMapper.convertToDTO(department) : null;
    }

@Override
    public DepartementDTO updateDepartment(Long id, DepartementDTO updatedDepartmentDTO) {
        Departement existingDepartment = departementRepository.findById(id).orElse(null);

        if (existingDepartment != null) {
            existingDepartment.setName(updatedDepartmentDTO.getName());
            // Vous pouvez ajouter d'autres champs à mettre à jour

            Departement savedDepartment = departementRepository.save(existingDepartment);
            return departementMapper.convertToDTO(savedDepartment);
        }

        return null; // Gérer le cas où le département n'est pas trouvé
    }
@Override
    public void deleteDepartment(Long id) {
        departementRepository.deleteById(id);
    }




}
