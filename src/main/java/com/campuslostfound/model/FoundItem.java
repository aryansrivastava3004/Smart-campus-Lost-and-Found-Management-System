package com.campuslostfound.model;
import java.time.LocalDate;
public class FoundItem extends Item { public FoundItem(int id,int userId,String title,ItemCategory category,String location,LocalDate date,String description,ItemStatus status){super(id,userId,title,category,location,date,description,status);} public String getType(){return "FOUND";} }
