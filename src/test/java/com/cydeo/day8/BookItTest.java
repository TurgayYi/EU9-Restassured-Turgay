package com.cydeo.day8;

import com.cydeo.utilities.BookItBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookItTest extends BookItBase {

    /*
    @BeforeAll
    public static void init(){
        baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";

    }

     */
    //save baseurl inside this variable so that we dont need to type each http method.
    String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";

    //create BookItUtil then create a method, that accepts email and password return token Bearer +yourToken as a String

    @DisplayName("GET all campuses")
    @Test
    public void testAuth1(){

        //how to pass bearer token for bookit ? use header method to give as key value header

        given()
                .header("Authorization",accessToken)
                .and().accept(ContentType.JSON)
                .when()
                .get("api/campuses")
                .then()
                .statusCode(200)
                .log().all();



    }





}
