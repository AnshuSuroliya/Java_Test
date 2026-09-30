package com.gangawing.ucount.creditworthiness.controller;

import com.gangawing.ucount.creditworthiness.dto.EmailNotificationRequestDTO;
import com.gangawing.ucount.creditworthiness.dto.EmailNotificationResponseDTO;
import com.gangawing.ucount.creditworthiness.service.EmailNotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "EmailNotification")
public class EmailNotificationController {

    @PostMapping(value = "/send", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody EmailNotificationResponseDTO sendNotification(
            @RequestBody EmailNotificationRequestDTO emailNotificationRequestDTO) {
        return EmailNotificationService.send(emailNotificationRequestDTO);
    }
}
