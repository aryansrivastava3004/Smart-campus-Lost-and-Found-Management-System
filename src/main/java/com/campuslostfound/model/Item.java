package com.campuslostfound.model;
import java.time.LocalDate;
public abstract class Item {
 private final int id,userId; private final String title,location,description; private final ItemCategory category; private final LocalDate date; private ItemStatus status;
 protected Item(int id,int userId,String title,ItemCategory category,String location,LocalDate date,String description,ItemStatus status){this.id=id;this.userId=userId;this.title=title;this.category=category;this.location=location;this.date=date;this.description=description;this.status=status;}
 public int getId(){return id;} public int getUserId(){return userId;} public String getTitle(){return title;} public ItemCategory getCategory(){return category;} public String getLocation(){return location;} public LocalDate getDate(){return date;} public String getDescription(){return description;} public ItemStatus getStatus(){return status;} public void setStatus(ItemStatus s){status=s;} public abstract String getType();
 public String summary(){return "#"+id+" | "+getType()+" | "+title+" | "+category+" | "+location+" | "+date+" | "+status;}
}
