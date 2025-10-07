package com.juaracoding.labs.service;

import org.json.JSONObject;

import com.juaracoding.labs.model.Group;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GroupService {
  Response response;
  RequestSpecification requestSpecification;
  
  public GroupService() {
     RestAssured.baseURI = "http://127.0.0.1:8000";
     requestSpecification = RestAssured.given()
       .header("Authorization", "Token 14f64911a86f634c5b4ddce3e7d75fe42b46e735"); 
  }

  public Response all() {
    return requestSpecification.get("/catalogs/groups/");
  }

  public Group create(Group group) {
    JSONObject body = new JSONObject();
    body.put("title", group.getTitle());
    body.put("origin", group.getOrigin());
   
    requestSpecification.contentType(ContentType.JSON).body(body.toString());
    return requestSpecification.post("/catalogs/groups/").as(Group.class);
    
  }

  public Group update(Group group) {
    JSONObject body = new JSONObject();
    body.put("title", group.getTitle());
    body.put("origin", group.getOrigin());

    requestSpecification.contentType(ContentType.JSON).body(body.toString());
    return requestSpecification.put("/catalogs/groups/" + group.getId() + "/").as(Group.class);
  }

  public int remove(int id) {
    return requestSpecification.delete("/catalogs/groups/" + id + "/").getStatusCode();
  }
}
