package entity;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
}
