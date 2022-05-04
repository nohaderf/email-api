package com.project1.emailapi.dtos;

import lombok.*;

import java.time.chrono.Chronology;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDTO {

    private String date;
    private String recipient;
    private String sender;
    private String subject;
    private String content;

}
