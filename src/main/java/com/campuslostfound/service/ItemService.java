package com.campuslostfound.service;
import java.sql.Connection;
 import java.sql.Date;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.campuslostfound.db.DatabaseManager;
import com.campuslostfound.exception.ValidationException;
import com.campuslostfound.model.FoundItem;
import com.campuslostfound.model.Item;
import com.campuslostfound.model.ItemCategory;
import com.campuslostfound.model.ItemStatus;
import com.campuslostfound.model.LostItem;
public class ItemService {
 private final UserService users; public ItemService(UserService u){users=u;}
 public int addItem(int userId,String type,String title,ItemCategory cat,String location,LocalDate date,String desc)throws SQLException,ValidationException{if(!users.exists(userId))throw new ValidationException("User ID does not exist.");if(title==null||title.isBlank())throw new ValidationException("Title is required.");if(location==null||location.isBlank())throw new ValidationException("Location is required.");if(date==null)throw new ValidationException("Date is required.");if(!type.equalsIgnoreCase("LOST")&&!type.equalsIgnoreCase("FOUND"))throw new ValidationException("Type must be LOST or FOUND.");String q="INSERT INTO items(user_id,type,title,category,location,item_date,description,status) VALUES(?,?,?,?,?,?,?,?)";try(Connection c=DatabaseManager.getConnection();PreparedStatement p=c.prepareStatement(q,Statement.RETURN_GENERATED_KEYS)){p.setInt(1,userId);p.setString(2,type.toUpperCase());p.setString(3,title.trim());p.setString(4,cat.name());p.setString(5,location.trim());p.setDate(6,Date.valueOf(date));p.setString(7,desc==null?"":desc.trim());p.setString(8,"ACTIVE");p.executeUpdate();try(ResultSet r=p.getGeneratedKeys()){if(r.next())return r.getInt(1);}}throw new SQLException("Could not create item.");}
 public List<Item> getItems(String type)throws SQLException{List<Item>a=new ArrayList<>();try(Connection c=DatabaseManager.getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM items WHERE type=? ORDER BY item_date DESC,id DESC")){p.setString(1,type.toUpperCase());try(ResultSet r=p.executeQuery()){while(r.next())a.add(map(r));}}return a;}
 public List<Item> search(String k)throws SQLException{List<Item>a=new ArrayList<>();String q="SELECT * FROM items WHERE LOWER(title) LIKE ? OR LOWER(description) LIKE ? OR LOWER(location) LIKE ? OR LOWER(category) LIKE ? ORDER BY item_date DESC";String x="%"+k.toLowerCase()+"%";try(Connection c=DatabaseManager.getConnection();PreparedStatement p=c.prepareStatement(q)){for(int i=1;i<=4;i++)p.setString(i,x);try(ResultSet r=p.executeQuery()){while(r.next())a.add(map(r));}}return a;}
 public Item findById(int id)throws SQLException{try(Connection c=DatabaseManager.getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM items WHERE id=?")){p.setInt(1,id);try(ResultSet r=p.executeQuery()){return r.next()?map(r):null;}}}
 public void updateStatus(int id,ItemStatus s)throws SQLException,ValidationException{if(findById(id)==null)throw new ValidationException("Item not found.");try(Connection c=DatabaseManager.getConnection();PreparedStatement p=c.prepareStatement("UPDATE items SET status=? WHERE id=?")){p.setString(1,s.name());p.setInt(2,id);p.executeUpdate();}}
 private Item map(ResultSet r)throws SQLException{int id=r.getInt("id"),uid=r.getInt("user_id");String title=r.getString("title"),loc=r.getString("location"),desc=r.getString("description"),type=r.getString("type");ItemCategory cat=ItemCategory.valueOf(r.getString("category"));LocalDate d=r.getDate("item_date").toLocalDate();ItemStatus st=ItemStatus.valueOf(r.getString("status"));return type.equals("LOST")?new LostItem(id,uid,title,cat,loc,d,desc,st):new FoundItem(id,uid,title,cat,loc,d,desc,st);}
}
