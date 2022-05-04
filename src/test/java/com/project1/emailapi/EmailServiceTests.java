package com.project1.emailapi;

import com.project1.emailapi.dtos.EmailDTO;
import com.project1.emailapi.models.Email;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTests {

    private EmailDTO dto = EmailDTO.builder()
            .date("2022-05-01 21:00:41")
            .sender("freda@freda.com")
            .recipient("snape@hogwarts.com")
            .subject("New reimbursement request")
            .content("A new reimbursement request has been submitted. Please review teh reimbursement request.")
            .build();

    private Email email;

    @Test
    void shouldConvertToEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = formatter.format(now);

        String subject = dto.getSubject();
        String content = dto.getContent();

        String recipient = dto.getRecipient();
        String sender = dto.getSender();

        email = new Email();
        email.setDate(dateTime);
        email.setRecipient(recipient);
        email.setSender(sender);
        email.setSubject(subject);
        email.setContent(content);

        assertEquals("snape@hogwarts.com", email.getRecipient());
    }

    @Test
    void setEmailRepository() {
    }

}