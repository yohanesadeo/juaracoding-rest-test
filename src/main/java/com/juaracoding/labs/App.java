package com.juaracoding.labs;

import io.restassured.RestAssured;

public class App 
{
    public static void main( String[] args )
    {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
    }
}
