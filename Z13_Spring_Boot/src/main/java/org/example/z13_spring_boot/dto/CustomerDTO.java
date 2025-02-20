package org.example.z13_spring_boot.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private int id;        // Include ID for updating
    private String name;
    private String address;
}
