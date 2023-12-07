package com.projectTBS.employeesmicroservice.service.Implementation;

import com.projectTBS.employeesmicroservice.dto.LeaveRequestDto;
import com.projectTBS.employeesmicroservice.dto.NotificationDTO;
import com.projectTBS.employeesmicroservice.entity.EmployeeInfo;
import com.projectTBS.employeesmicroservice.entity.LeaveRequest;
import com.projectTBS.employeesmicroservice.mapper.LeaveRequestMapper;
import com.projectTBS.employeesmicroservice.repo.EmployeeRepository;
import com.projectTBS.employeesmicroservice.repo.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveRequestService {

    private final NotificationService notificationService;
    private final EmployeeRepository employeeRepository;

    private  final LeaveRequestRepository leaveRequestRepository;
    private final LeaveRequestMapper leaveRequestMapper;

    @Autowired
    public LeaveRequestService(NotificationService notificationService,LeaveRequestMapper leaveRequestMapper, EmployeeRepository employeeRepository,LeaveRequestRepository leaveRequestRepository) {
        this.notificationService = notificationService;
        this.employeeRepository = employeeRepository;
        this.leaveRequestRepository=leaveRequestRepository;
        this.leaveRequestMapper=leaveRequestMapper;
    }

    // Méthode pour soumettre une demande de congé
    public LeaveRequestDto submitLeaveRequest(LeaveRequestDto leaveRequestDTO) {
        // Logique pour enregistrer la demande de congé dans la base de données
        LeaveRequest leaveRequest = leaveRequestMapper.convertToEntity(leaveRequestDTO);
        leaveRequest = leaveRequestRepository.save(leaveRequest);

        // Envoyer une notification en temps réel à tous les administrateurs
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setBody("Nouvelle demande de congé soumise");
        notificationService.sendNotificationToAdmin(notificationDTO);

        return leaveRequestMapper.convertToDTO(leaveRequest);
    }




}
