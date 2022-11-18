package com.cydeo.day4;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestWithPath extends HrTestBase {


    @DisplayName("GET request to countries with Path method")
    @Test()
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                                .and().queryParam("q", "{\"region_id\":2}")
                                .log().all()
                            .when()
                                .get("/countries");


        assertEquals(200,response.statusCode());

        //print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        //print hasMore
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //print first country id
       String countryId = response.path("items[0].country_id");
        System.out.println("countryId = " + countryId);

        //print second country name
        String secondCountryName=response.path("items[1].\"country_name\"");
        System.out.println("secondCountryName = " + secondCountryName);


        //print "http://44.195.19.167:1000/ords/hr/countries/CA"
        String hrefCanada=response.path("items[2].links[0].href");
        System.out.println("hrefCanada = " + hrefCanada);

        //get all country names
        List<String> allCountryNames = response.path("items.country_name");
        System.out.println("allCountryNames = " + allCountryNames);

       //assert that all region ids are equal to 2

        List<Integer> allRegionIds = response.path("items.region_id");

        for (Integer regionId : allRegionIds) {
            System.out.println("regionId = " + regionId);
            assertEquals(2,regionId);

        }


    }

   /*
        Send a GET request to employees and get only employees who works as a IT_PROG

     */

    @DisplayName("GET request to /employees with Query Param")
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"job_id\": \"IT_PROG\"}")
                .log().all()
                .when()
                .get("/employees");


        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.header("Content-Type"));
        assertEquals("chunked",response.header("Transfer-Encoding"));


        //make sure we have only IT_PROG as a job_id
        List<String> allJobIDs = response.path("items.job_id");

        for(String eachJobID : allJobIDs){
            System.out.println("eachJobID = " + eachJobID);
            assertEquals("IT_PROG",eachJobID);
        }








    }





}
