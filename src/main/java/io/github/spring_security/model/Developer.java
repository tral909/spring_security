package io.github.spring_security.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class Developer {
    private Long id;
    private String firstName;
    private String lastName;

    @ConstructorProperties({"id", "firsName", "lastName"})
    public Developer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
