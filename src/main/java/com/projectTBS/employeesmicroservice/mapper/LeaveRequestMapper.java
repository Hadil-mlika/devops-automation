package com.projectTBS.employeesmicroservice.mapper;


import com.projectTBS.employeesmicroservice.dto.LeaveRequestDto;
import com.projectTBS.employeesmicroservice.entity.LeaveRequest;

import org.springframework.stereotype.Component;


@Component
public interface LeaveRequestMapper {

    LeaveRequestDto convertToDTO(LeaveRequest leaveRequest);

    LeaveRequest convertToEntity(LeaveRequestDto leaveRequestDTO);
}
