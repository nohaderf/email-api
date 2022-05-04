package com.project1.emailapi.repositories;

import com.project1.emailapi.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

    @Modifying
    @Query("SELECT e FROM Email e WHERE e.recipient=?1 OR e.sender=?1")
    List<Email> findAllByEmailAddress(String email);
}
