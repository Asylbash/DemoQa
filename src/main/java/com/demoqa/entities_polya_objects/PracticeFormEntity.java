package com.demoqa.entities_polya_objects;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class PracticeFormEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobileNumber;
    // private String subject;
    private List<String> subjects;
    private String hobby;
    private String selectPic;
    private String currentAddress;
    private String state;
    private String city;

}
