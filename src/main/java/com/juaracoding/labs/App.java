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
            .header("Authorization", "Token 14f64911a86f634c5b4ddce3e7d75fe42b46e735");

        Response response = requestSpecification.get("/catalogs/groups/");

        System.out.println(response.getBody().asPrettyString());
    }
}
