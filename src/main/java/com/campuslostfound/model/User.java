package com.campuslostfound.model;
public abstract class User {
 private final int id; private final String name; private final String email;
 protected User(int id,String name,String email){this.id=id;this.name=name;this.email=email;}
 public int getId(){return id;} public String getName(){return name;} public String getEmail(){return email;}
 public abstract String getRole();
 public String toString(){return id+" | "+name+" | "+email+" | "+getRole();}
}
