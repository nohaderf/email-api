package com.project1.emailapi.controllers;

import com.project1.emailapi.dtos.EmailDTO;
import com.project1.emailapi.models.Email;
import com.project1.emailapi.repositories.EmailRepository;
import com.project1.emailapi.services.EmailService;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emails")
public class EmailController {

    final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Setter(onMethod =@__({@Autowired}))
    private EmailRepository emailRepository;

    @Autowired
    private EmailService emailService;

    /**
     * Get all emails
     * @return all email instances
     */
    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        logger.debug("Get all emails: {}", emailRepository.findAll());
        return ResponseEntity.ok(emailRepository.findAll());
    }

    /**
     * Get email by id
     * @param id - email id
     * @return email instance
     */
    @GetMapping(path="{id}")
    public ResponseEntity getEmailWithId(@PathVariable Integer id) {
        logger.debug("Get email with id: ", emailRepository.findById(id));
        return ResponseEntity.ok(emailRepository.findById(id));
    }

    /**
     * Get all emails with email address
     * @param email - email address
     * @return email instances
     */
    @GetMapping("address")
    public ResponseEntity getAllByEmail(@RequestParam String email) {
        System.out.println(email);
        logger.debug("Get all emails with email address: {}", emailRepository.findAllByEmailAddress(email));
        return ResponseEntity.ok(emailRepository.findAllByEmailAddress(email));
    }

    /**
     * Create new email
     * @param dto - email data transfer object
     */
    @PostMapping("new")
    public void newEmail(@RequestBody EmailDTO dto) {
        emailService.convertToEntity(dto);
    }
}
