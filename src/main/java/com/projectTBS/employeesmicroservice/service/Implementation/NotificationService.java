package com.projectTBS.employeesmicroservice.service.Implementation;

import com.projectTBS.employeesmicroservice.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendNotificationToAdmin(NotificationDTO notification) {
        // Envoyer une notification à tous les administrateurs
        messagingTemplate.convertAndSendToUser("admin", "/topic/notifications", notification);
    }
}
