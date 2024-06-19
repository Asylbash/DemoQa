package com.demoqa.entities_polya_objects;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Employee {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private long salary;
    private String department;

}
