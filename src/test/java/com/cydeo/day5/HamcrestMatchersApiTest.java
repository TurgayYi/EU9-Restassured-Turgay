package com.cydeo.day5;

import com.cydeo.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersApiTest {

       /*
       given accept type is Json
       And path param id is 15
       When user sends a get request to spartans/{id}
       Then status code is 200
       And content type is Json
       And json data has following
           "id": 156,
           "name": "John",
           "gender": "Male",
           "phone": 12334987347
        */

    @DisplayName("One Spartan with Hamcrest and chaining")
    @Test
    public void test1(){

                        given()
                                .accept(ContentType.JSON)
                                .and().pathParam("id",156)
                        .when()
                                .get("http://44.195.19.167:8000/api/spartans/{id}")
                         .then()
                                .statusCode(200)
                                .and()
                                .contentType("application/json")
                                .and()
                                .body("id",equalTo(156),
                                        "name",is("John"),
                                        "gender",is("Male"),
                                        "phone", is(12334987347L)

                                        )
                                .log().all();




    }

    @DisplayName("CBTraining Teacher request with chaining and matchers")
    @Test
    public void teacherData(){

                 given()
                    .accept(ContentType.JSON)
                    .and()
                    .pathParam("id",10)
                .when()
                    .get("https://api.training.cydeo.com/teacher/{id}")
                .then()
                    .statusCode(200)
                    .and()
                    .contentType("application/json;charset=UTF-8")
                    .and()
                    .header("server",is("envoy"))
                    .and()
                    .header("date",notNullValue())
                    .and()
                    .body("teachers[0].firstName", is("Porter"))
                    .and()
                    .body("teachers[0].lastName",is("Merbeery"))
                    .and()
                    .body("teachers[0].gender",equalTo("Male"));

    }


    @DisplayName("GET request to teacher/all and chaining")
    @Test
    public void teachersTest(){

        //verify Valter,Porter,Erik inside the all teachers
                given()
                        .accept(ContentType.JSON)
                .when()
                        .get("https://api.training.cydeo.com/teacher/all")
                .then()
                        .statusCode(200)
                        .and()
                        .body("teachers.firstName",hasItems("Valter","Porter","Erik"));



    }



}
