package com.juaracoding.labs.model;

public class Group {
  private int id;
  private String title;
  private String origin;
  private int owner;
  private String created_at;
  private String updated_at;

  public Group(int id, String title, String origin, int owner, String created_at, String updated_at) {
    this.id = id;
    this.title = title;
    this.origin = origin;
    this.owner = owner;
    this.created_at = created_at;
    this.updated_at = updated_at;
  }

  public Group(String title, String origin) {
    this.title = title;
    this.origin = origin;
  }

  public Group() {
  }

  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }

  public String getOrigin() {
    return origin;
  }
  
  public void setOrigin(String origin) {
    this.origin = origin;
  }
  
  public int getOwner() {
    return owner;
  }

  public void setOwner(int owner) {
    this.owner = owner;
  }

}
