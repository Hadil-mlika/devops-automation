package com.projectTBS.employeesmicroservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private boolean approved;

    @OneToOne(mappedBy = "leaveRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private LeaveResponse leaveResponse;


    // Getters and Setters
}
