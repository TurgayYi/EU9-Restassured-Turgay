package com.cydeo.day4;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;



public class ORDSApiWithJasonPath extends HrTestBase {

    @DisplayName("GET request to Countries")
    @Test
    public void test1(){

        Response response = get("/countries");


        //to use JsonPath we assign response to JsonPath
        JsonPath jsonPath = response.jsonPath();

        //get the second country name with jsonPath
        String countryName = jsonPath.getString("items[1].country_name");
        System.out.println("countryName = " + countryName);

        //get all country ids

        List<String> allCountryIDs = jsonPath.getList("items.country_id");

        System.out.println(allCountryIDs);


        //get all country names where their region id is equal to 2
        List<String> countryNameWithRegionId2 = jsonPath.getList("items.findAll {it.region_id==3}.country_name");
        System.out.println(countryNameWithRegionId2);


    }

    @DisplayName("GET request /employees with query param ")
    @Test
    public void test2(){

        Response response = given().queryParam("limit", 107)
                .when().get("/employees");


        //get all email of employees who is working as IT_PROG

        JsonPath jsonPath = response.jsonPath();

        List<String> allEmails =  jsonPath.getList("items.findAll {it.job_id==\"IT_PROG\"}.email");
        System.out.println(allEmails);

        //get first name of employees who is making more than 10000

        List<String> allNames = jsonPath.getList("items.findAll {it.salary > 10000}.first_name");
        System.out.println(allNames);

        //get the max salary first_name
        String name = jsonPath.getString("items.max {it.salary}.first_name");
        System.out.println(name);


    }

}
