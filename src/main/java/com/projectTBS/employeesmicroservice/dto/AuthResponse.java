package com.projectTBS.employeesmicroservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data

@NoArgsConstructor
public class AuthResponse {

        private String message;
         private String token;
         private String email;


        public AuthResponse(String message, String token,String email) {
            this.message = message;
            this.token = token;
            this.email=email;

        }

        // Getters and setters
    }

