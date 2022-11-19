package com.cydeo.day4;

import com.cydeo.utilities.CydeoApiTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

public class CBTrainingApiWithJasonPath extends CydeoApiTestBase {



    @Test
    public void test1(){

        //send a get request to student id 23 as a path parameter and accept header application/json
        //verify status code=200 /content type=application/json;charset=UTF-8 /Content-Encoding = gzip
        //verify Date header exists
        //assert that
            /*
                firstName Derick
                batch 19
                section N/A
                emailAddress cpfeffel9@fema.gov
                companyName Quinu
                state Virginia
                zipCode 69807
                using JsonPath
             */

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("studentId", 23)
                .when()
                .get("/student/{studentId}");


        JsonPath jsonPath = response.jsonPath();

        String firstName = jsonPath.getString("students[0].firstName");
        int batch = jsonPath.getInt("students[0].batch");
        String section = jsonPath.getString("students[0].section");
        String emailAddress = jsonPath.getString("students[0].contact.emailAddress");
        String companyName = jsonPath.getString("students[0].company.companyName");
        String state = jsonPath.getString("students[0].company.address.state");
        int zipCode = jsonPath.getInt("students[0].company.address.zipCode");


        assertEquals("Derick",firstName);
        assertTrue(19 == batch);
        assertEquals("N/A",section);
        assertEquals("Quinu",companyName);
        assertEquals("cpfeffel9@fema.gov",emailAddress);
        assertEquals("Virginia",state);
        assertTrue(69807 == zipCode);


    }

}
