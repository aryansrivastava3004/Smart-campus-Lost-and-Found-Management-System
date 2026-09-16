package com.campuslostfound.model;
public class Student extends User {
 private final String studentId;
 public Student(int id,String name,String email,String studentId){super(id,name,email);this.studentId=studentId;}
 public String getStudentId(){return studentId;} public String getRole(){return "STUDENT";}
}
