package com.projectTBS.employeesmicroservice.repo;

import com.projectTBS.employeesmicroservice.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
