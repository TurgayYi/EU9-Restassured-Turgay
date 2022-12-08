package com.cydeo.day11;

import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CsvFileSourceParametrizedTest {

    // Write a parameterized test for this request
    // Get the data from csv source
    // GET https://api.zippopotam.us/us/{state}/{city}

    @ParameterizedTest
    @CsvFileSource(resources = "/postalcode.csv",numLinesToSkip = 1)
    public void zipCodeTestWithFile(String stateArg, String cityArg, int countArg){

        System.out.println("stateArg = " + stateArg);
        System.out.println("cityArg = " + cityArg);
        System.out.println("countArg = " + countArg);

        //send a request and verify place number matches with zipCount
        given().accept(ContentType.JSON)
                .pathParam("state",stateArg)
                .pathParam("city",cityArg)
                .when()
                .get("https://api.zippopotam.us/us/{state}/{city}")
                .then()
                .statusCode(200)
                .body("places",hasSize(countArg));





    }





}



