package com.project1.emailapi;

import com.project1.emailapi.models.Email;
import com.project1.emailapi.repositories.EmailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EmailRepositoryTests {

    @Autowired
    private EmailRepository emailRepository;

    private Email email;

    @Test
    public void shouldGetAllEmails() {

        List<Email> emails = emailRepository.findAll();

        assertTrue(emails.size() > 0);
    }

    @Test
    public void shouldGetEmailWithId() {

        Email email = emailRepository.findById(1).get();

        Assertions.assertEquals(1, email.getId());
    }

    @Test
    public void shouldCreateNewEmail() {

        Email email = Email.builder()
                .id(1)
                .date("2022-05-02 21:00:41")
                .sender("freda@freda.com")
                .recipient("snape@hogwarts.com")
                .subject("New reimbursement request")
                .content("A new reimbursement request has been submitted. Please review the reimbursement request.")
                .build();

        emailRepository.save(email);

        assertTrue(email.getId() > 0);
    }
}