package com.cydeo.day5;

import com.cydeo.utilities.SpartanTestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class JasonToJavaTest extends SpartanTestBase {

    @DisplayName("GET one Spartan and deserialize to Map")
    @Test
    public void oneSpartanToMap(){

        Response response = given().accept(ContentType.JSON).and()
                .pathParam("id", 156)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .extract().response();


        //get the json and convert it to the map

        Map<String,Object> jsonMap = response.as(Map.class);

        System.out.println("jsonMap.toString() = " + jsonMap.toString());


    }

}
