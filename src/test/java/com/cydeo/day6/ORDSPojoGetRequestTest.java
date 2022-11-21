package com.cydeo.day6;

import com.cydeo.pojo.*;
import com.cydeo.utilities.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class ORDSPojoGetRequestTest extends HrTestBase {


    @Test
    public void regionTest(){

        JsonPath jsonPath = given().accept(ContentType.JSON)
                .when().get("/regions")
                .then()
                .statusCode(200)
                .extract().jsonPath();


        Region region1 = jsonPath.getObject("items[0]", Region.class);
        System.out.println(region1);

        System.out.println("region1.getRegion_id() = " + region1.getRegion_id());
        System.out.println("region1.getRegion_name() = " + region1.getRegion_name());
        System.out.println("region1.getLinks().get(0).getHref() = " + region1.getLinks().get(0).getHref());



    }







}
