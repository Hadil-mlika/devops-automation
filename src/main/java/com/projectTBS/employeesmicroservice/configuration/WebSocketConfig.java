package com.projectTBS.employeesmicroservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Active le courtage basé sur les messages avec un préfixe "/topic" pour les messages destinés aux clients
        config.enableSimpleBroker("/topic");

        // Définit le préfixe à utiliser pour les messages qui vont du client vers le serveur
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Configure un point d'extrémité STOMP accessible via "/ws"
        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:4200").withSockJS();
    }
}