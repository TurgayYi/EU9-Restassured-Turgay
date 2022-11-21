package com.cydeo.day6;

import com.cydeo.pojo.*;
import com.cydeo.utilities.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.lang.reflect.Type;
import java.util.*;

import static io.restassured.RestAssured.*;
public class SpartanPojoGetRequestTest extends SpartanTestBase {

    @DisplayName("GET one spartan and convert it to Spartan Object")
    @Test
    public void oneSpartanPojo(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 156)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .log().all()
                .extract().response();

        //De serialize --> JSON to POJO (java custom class)
        //2 different way to do this
        //1.using as() method
        //we convert json response to spartan object with the help of jackson
        //as() method uses jackson to de serialize(converting JSON to Java class)

        Spartan spartan156 = response.as(Spartan.class);

        System.out.println(spartan156);
        System.out.println("spartan156.getId() = " + spartan156.getId());
        System.out.println("spartan156.getName() = " + spartan156.getName());
        System.out.println("spartan156.getGender() = " + spartan156.getGender());
        System.out.println("spartan156.getPhone() = " + spartan156.getPhone());


        //second way of deserialize json to java
        //2.using JsonPath to deserialize to custom class
        JsonPath jsonPath = response.jsonPath();

        Spartan s156 = jsonPath.getObject("",Spartan.class);
        System.out.println("s156 = " + s156);
        System.out.println("s156.getName() = " + s156.getName());
        System.out.println("s156.getPhone() = " + s156.getPhone());



    }

    @DisplayName("Get one spartan from search endpoint and save first object with type Spartan POJO")
    @Test
    public void spartanSearchWithPojo(){

        ///spartans/search?nameContains=a&gender=Male
        // send get request to above endpoint and save first object with type Spartan POJO

        JsonPath jsonPath = given().accept(ContentType.JSON).and().queryParams("nameContains", "j",
                        "gender", "Male")
                .when()
                .get("/api/spartans/search")
                .then().statusCode(200)
                .extract().jsonPath();

        //get the first spartan from content list and put inside spartan object
        Spartan s1 = jsonPath.getObject("content[0]",Spartan.class);

        System.out.println("s1.getName() = " + s1.getName());
        System.out.println("s1.getId() = " + s1.getId());
        System.out.println("s1.getGender() = " + s1.getGender());
        System.out.println("s1.getPhone() = " + s1.getPhone());


    }


    @Test
    public void test3(){

        Response response = given().accept(ContentType.JSON).and().queryParams("nameContains", "j",
                        "gender", "Male")
                .when()
                .get("/api/spartans/search")
                .then().statusCode(200)
                .extract().response();

        Search searchResult = response.as(Search.class);

        System.out.println(searchResult.getContent().get(0).getName());


    }


}
