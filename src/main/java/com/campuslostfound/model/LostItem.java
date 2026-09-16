package com.campuslostfound.model;
import java.time.LocalDate;
public class LostItem extends Item { public LostItem(int id,int userId,String title,ItemCategory category,String location,LocalDate date,String description,ItemStatus status){super(id,userId,title,category,location,date,description,status);} public String getType(){return "LOST";} }
