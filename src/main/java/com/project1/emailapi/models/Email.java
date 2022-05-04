package com.project1.emailapi.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Emails")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {

    @Id
    @Column(name = "id", columnDefinition = "AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;
    private String recipient;
    private String sender;
    private String subject;
    private String content;

}
