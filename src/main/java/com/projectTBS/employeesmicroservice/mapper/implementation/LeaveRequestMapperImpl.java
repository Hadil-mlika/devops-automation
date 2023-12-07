package com.projectTBS.employeesmicroservice.mapper.implementation;

import com.projectTBS.employeesmicroservice.dto.LeaveRequestDto;
import com.projectTBS.employeesmicroservice.entity.LeaveRequest;
import com.projectTBS.employeesmicroservice.mapper.LeaveRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class LeaveRequestMapperImpl implements LeaveRequestMapper {


@Override
    public LeaveRequestDto convertToDTO(LeaveRequest leaveRequest) {
        LeaveRequestDto leaveRequestDTO = new LeaveRequestDto();
        leaveRequestDTO.setStartDate(leaveRequest.getStartDate());
        leaveRequestDTO.setEndDate(leaveRequest.getEndDate());
        leaveRequestDTO.setReason(leaveRequest.getReason());
        return leaveRequestDTO;
    }




    @Override
    public LeaveRequest convertToEntity(LeaveRequestDto leaveRequestDTO) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStartDate(leaveRequestDTO.getStartDate());
        leaveRequest.setEndDate(leaveRequestDTO.getEndDate());
        leaveRequest.setReason(leaveRequestDTO.getReason());
        return leaveRequest;
    }
}
