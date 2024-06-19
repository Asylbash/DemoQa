package com.demoqa.entities_polya_objects;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class NBWalletEntity {

    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private String selectPic;
    private String password;
}
