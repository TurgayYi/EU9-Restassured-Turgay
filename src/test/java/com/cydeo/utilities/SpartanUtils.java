package com.cydeo.utilities;

import com.github.javafaker.Faker;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpartanUtils {

    public static Map<String,Object> crateANewSpartan(){

        Faker faker = new Faker();
        String name = faker.name().firstName();
        long phone = Long.parseLong(faker.number().digits(11));

        String gender;
        if (name.contains("t")) {
            gender = "Male";

            }else {
              gender = "Female";
        }
        Map<String, Object> spartan1 = new LinkedHashMap<>();

        spartan1.put("gender",gender);
        spartan1.put("name",name);
        spartan1.put("phone",phone);

        return spartan1;




    }


}
