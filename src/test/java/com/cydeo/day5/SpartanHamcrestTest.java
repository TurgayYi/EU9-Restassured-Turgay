package com.cydeo.day5;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class SpartanHamcrestTest extends SpartanTestBase {


    @DisplayName("GET spartan/search and chaining together")
    @Test
    public void test1(){

        //along with this statement, I want to save names inside List<String>

                            List<String> names = given().accept(ContentType.JSON)
                                    .and().queryParams("nameContains","j",
                            "gender","Male")

                            .when()
                                    .get("/api/spartans/search")
                            .then()
                                    .statusCode(200)
                                    .and()
                                    .body("totalElement",greaterThan(3))
                                     .extract().response().jsonPath().getList("content.name");




         //save statusCode

                 int statusCode =    given().accept(ContentType.JSON)
                             .and().queryParams("nameContains","j",
                             "gender","Male")
                             .when()
                             .get("/api/spartans/search")
                             .then()
                             .statusCode(200)
                             .extract().response().statusCode();

        System.out.println("statusCode = " + statusCode);


    }



}
