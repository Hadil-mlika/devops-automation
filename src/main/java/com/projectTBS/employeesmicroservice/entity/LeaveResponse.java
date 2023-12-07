package com.projectTBS.employeesmicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LeaveResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean approved;
    private String message;
    @OneToOne
    @JoinColumn(name = "leave_request_id")
    private LeaveRequest leaveRequest;

    // Getters and Setters
}
