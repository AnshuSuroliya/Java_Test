package com.gangawing.ucount.creditworthiness.service;

import com.gangawing.ucount.creditworthiness.dto.EmailNotificationRequestDTO;
import com.gangawing.ucount.creditworthiness.dto.EmailNotificationResponseDTO;

public class EmailNotificationService {

    public static EmailNotificationResponseDTO send(EmailNotificationRequestDTO emailNotificationRequestDTO) {
        EmailNotificationResponseDTO emailNotificationResponseDTO = new EmailNotificationResponseDTO();
        emailNotificationResponseDTO.setSent(true);
        return emailNotificationResponseDTO;
    }
}
