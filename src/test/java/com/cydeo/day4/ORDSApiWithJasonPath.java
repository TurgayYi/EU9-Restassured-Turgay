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


    }

}
