package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class CydeoApiTestBase {

    @BeforeAll
    public static void init(){

        baseURI = "https://api.training.cydeo.com";

    }


}
