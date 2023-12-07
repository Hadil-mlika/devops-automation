package com.projectTBS.employeesmicroservice.controller;

import com.projectTBS.employeesmicroservice.dto.LeaveRequestDto;
import com.projectTBS.employeesmicroservice.dto.NotificationDTO;
import com.projectTBS.employeesmicroservice.entity.LeaveRequest;
import com.projectTBS.employeesmicroservice.service.Implementation.LeaveRequestService;
import com.projectTBS.employeesmicroservice.service.Implementation.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leave-requests")
@CrossOrigin
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @Autowired
    private NotificationService notificationService;



    @PostMapping("/submit")
    public ResponseEntity<LeaveRequestDto> submitLeaveRequest(@RequestBody LeaveRequestDto leaveRequestDTO) {
        LeaveRequestDto submittedLeaveRequest = leaveRequestService.submitLeaveRequest(leaveRequestDTO);

        // Envoyer une notification en temps réel à tous les administrateurs
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setBody("Nouvelle demande de congé soumise");
        notificationService.sendNotificationToAdmin(notificationDTO);

        return new ResponseEntity<>(submittedLeaveRequest, HttpStatus.CREATED);
    }




}
