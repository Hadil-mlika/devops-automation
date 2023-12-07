package com.projectTBS.employeesmicroservice.repo;


import com.projectTBS.employeesmicroservice.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Long> {
    Optional<EmployeeInfo> findByEmail(String email);

    List<EmployeeInfo> findByRole(String role);
}