package com.cydeo.day4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

public class CBTrainingApiWithJasonPath {

    @BeforeAll
    public static void init(){

        baseURI = "https://api.training.cydeo.com";

    }

    @Test
    public void test1(){

        //send a get request to student id 23401 as a path parameter and accept header application/json
        //verify status code=200 /content type=application/json;charset=UTF-8 /Content-Encoding = gzip
        //verify Date header exists
        //assert that
            /*
                firstName Vera
                batch 14
                section 12
                emailAddress aaa@gmail.com
                companyName Cybertek
                state IL
                zipCode 60606

                using JsonPath
             */



    }

}
