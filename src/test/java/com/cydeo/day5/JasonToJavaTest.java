package com.cydeo.day5;

import com.cydeo.utilities.SpartanTestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

        //after we got the map, we can use hamcrest or junit assertions to do assertion
        String actualName = (String) jsonMap.get("name");
        assertThat(actualName,is("John"));



    }

    @DisplayName("GET all spartans to JAVA data structure")
    @Test
    public void getAllSpartan(){

        Response response = get("/api/spartans").then().statusCode(200)
                .extract().response();

        //we need to convert json to java which is deserialize

       List<Map<String,Object>> jsonList =  response.as(List.class);

        System.out.println("jsonList.get(1).get(\"name\") = " + jsonList.get(1).get("name"));


        Map<String,Object> spartan3 = jsonList.get(2);
        System.out.println("spartan3 = " + spartan3);


    }



}