package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class BookItBase {

    @BeforeAll
    public static void init(){
        baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";


    }

    @AfterAll
    public static void tearDown(){

        // DBUtils.destroy();

    }
}
