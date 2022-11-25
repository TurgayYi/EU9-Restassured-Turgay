package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/*
{
    "id": 156,
    "name": "John",
    "gender": "Male",
    "phone": 12334987347
}
 */

@Getter
@Setter
@ToString

@JsonIgnoreProperties(value = "id",allowSetters = true)
public class Spartan {

    private int id;
    private String name;
    private String gender;
    private long phone;




}
