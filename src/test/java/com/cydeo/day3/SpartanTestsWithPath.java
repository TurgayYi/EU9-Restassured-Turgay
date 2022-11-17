package com.cydeo.day3;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestsWithPath {

    @BeforeAll
    public static void init(){
        baseURI = "http://44.195.19.167:8000";

    }
    /*
 Given accept type is json
 And path param id is 10
 When user sends a get request to "api/spartans/{id}"
 Then status code is 200
 And content-type is "application/json"
 And response payload values match the following:
     id is 156,
    "name" is"John",
    "gender"is "Male",
    "phone"is 12334987347

     */
    @DisplayName("GET one spartan with Path Method")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",156)
                .when().get("/api/spartans/{id}");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());

        //verify each json key has specific value
        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());


        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        //assert the values
        assertEquals(156,id);
        assertEquals("John",name);
        assertEquals("Male",gender);
        assertEquals(12334987347L,phone);


    }

    @DisplayName("GET all spartans and navigate with Path()")
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

       // response.prettyPrint();


        int firstId = response.path("id[0]");
        System.out.println(firstId);

        String name = response.path("name[0]");
        System.out.println(name);

        String lastFirstName = response.path("name[-1]");
        System.out.println(lastFirstName);


        List<String> names = response.path("name");
        System.out.println(names);

        for (String eachName : names) {
            System.out.println(eachName);
        }



    }






}
