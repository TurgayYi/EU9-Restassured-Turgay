package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanAuthTestBase {



    @BeforeAll
    public static void init(){
        baseURI = "http://44.195.19.167:7000";



    }



}
