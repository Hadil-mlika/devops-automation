package com.projectTBS.employeesmicroservice.service.Implementation;


import com.projectTBS.employeesmicroservice.dto.EmployeeDTO;
import com.projectTBS.employeesmicroservice.entity.Departement;
import com.projectTBS.employeesmicroservice.entity.EmployeeInfo;
import com.projectTBS.employeesmicroservice.mapper.EmployeeMapper;
import com.projectTBS.employeesmicroservice.repo.DepartementRepository;
import com.projectTBS.employeesmicroservice.repo.EmployeeRepository;
import com.projectTBS.employeesmicroservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartementRepository departementRepository;
    private final EmployeeMapper employeeMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,DepartementRepository departementRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departementRepository=departementRepository;
    }



    @Override
    public List<EmployeeInfo> getEmployeesByRole(String role) {
        return employeeRepository.findByRole(role);
    }
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeInfo employee = employeeMapper.mapEmployeeDTOToEmployee(employeeDTO);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        if (employeeDTO.getDepartmentId()!= null) {
            Departement department = departementRepository.findById(employeeDTO.getDepartmentId()).orElse(null);
            employee.setDepartment(department);
        }
        EmployeeInfo savedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapEmployeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Optional<EmployeeInfo> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employeeMapper.mapEmployeeToEmployeeDTO(employee.get());
        } else {
            // Gérer la non-existence de l'employé (par exemple, lever une exception)
            return null;
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeInfo> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::mapEmployeeToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<EmployeeInfo> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            EmployeeInfo updatedEmployee = employeeMapper.mapEmployeeDTOToEmployee(employeeDTO);
            updatedEmployee.setId(id); // Assurez-vous que l'ID reste le même
            EmployeeInfo savedEmployee = employeeRepository.save(updatedEmployee);
            return employeeMapper.mapEmployeeToEmployeeDTO(savedEmployee);
        } else {
            // Gérer la non-existence de l'employé (par exemple, lever une exception)
            return null;
        }
    }



    public EmployeeDTO getUserInfoByUsername(String email) {
        Optional<EmployeeInfo> employeeInfoOptional = employeeRepository.findByEmail(email);

        // Check if the employeeInfo is present in the optional before attempting to convert
        if (employeeInfoOptional.isPresent()) {
            EmployeeInfo employeeInfo = employeeInfoOptional.get();

            // Convert EmployeeInfo to EmployeeDTO (you need to implement this conversion method)
            EmployeeDTO employeeDTO = employeeMapper.mapEmployeeToEmployeeDTO(employeeInfo);

            return employeeDTO;
        } else {
            // Handle the case when employeeInfo is not found, you can throw an exception or return null
            // For simplicity, I'm returning null here, but you might want to handle this case differently
            return null;
        }
    }
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
