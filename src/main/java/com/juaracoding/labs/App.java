package com.juaracoding.labs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class App 
{
    public static void main( String[] args )
    {
        	
        RestAssured.baseURI = "http://127.0.0.1:8000";

        RequestSpecification requestSpecification = RestAssured.given()
            .header("Authorization", "Token fc2fa49b76bbf28c084a44e8ffc7452399417a82");

        Response response = requestSpecification.get("/catalogs/groups/");

        System.out.println(response.getBody().asPrettyString());
    }
}
