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
       .header("Authorization", "Token fc2fa49b76bbf28c084a44e8ffc7452399417a82"); 
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
