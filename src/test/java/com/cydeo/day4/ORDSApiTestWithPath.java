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


    }







}
