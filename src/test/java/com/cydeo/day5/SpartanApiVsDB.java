package com.cydeo.day5;

import com.cydeo.utilities.DBUtils;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SpartanApiVsDB extends SpartanTestBase {


    @DisplayName("GET one spartan from api and database")
    @Test
    public void testDB1(){

        //get id,name,gender phone  from database
        //get same information from api
        //compare

        //1. get id,name,gender phone  from database

        String query = "select spartan_id, name, gender, phone from spartans\n" +
                "where spartan_id = 156";

        //save data inside the map
        Map<String, Object> dbMap = DBUtils.getRowMap(query);
        System.out.println("dbMap = " + dbMap);

        //2.get info from api

        Map<String,Object> apiMap = given().accept(ContentType.JSON)
                .pathParam("id",156)
                .when()
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200)
                .and().contentType("application/json")
                .extract().response().as(Map.class);
        System.out.println(apiMap);

        //3.compare database vs api --> we assume expected result is db
        assertThat(apiMap.get("id").toString(),is(dbMap.get("SPARTAN_ID").toString()));
        assertThat(apiMap.get("name"),is(dbMap.get("NAME")));
        assertThat(apiMap.get("gender"),is(dbMap.get("GENDER")));
        assertThat(apiMap.get("phone").toString(),is(dbMap.get("PHONE").toString()));




    }


}
