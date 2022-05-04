package com.project1.emailapi.services;

import com.project1.emailapi.dtos.EmailDTO;
import com.project1.emailapi.models.Email;
import com.project1.emailapi.repositories.EmailRepository;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmailService {

    final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Setter(onMethod =@__({@Autowired}) )
    private EmailRepository emailRepository;

    /**
     * Creates a new email instance
     * Converts the email data transfer object into an email instance
     * @param dto - email data transfer object
     */
    public void convertToEntity(EmailDTO dto) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = formatter.format(now);

        logger.debug("Current date and time: ", dateTime);

        String subject = dto.getSubject();
        String content = dto.getContent();

        String recipient = dto.getRecipient();
        String sender = dto.getSender();

        Email email = new Email();
        email.setDate(dateTime);
        email.setRecipient(recipient);
        email.setSender(sender);
        email.setSubject(subject);
        email.setContent(content);

        logger.debug("New email object: {}", email);

        emailRepository.save(email);

    }
}
