package com.campuslostfound.util;
import com.campuslostfound.exception.ValidationException; import com.campuslostfound.model.ItemCategory; import java.time.*; import java.time.format.*; import java.util.Scanner;
public class InputValidator {
 public static int readInt(Scanner s,String p)throws ValidationException{System.out.print(p);try{return Integer.parseInt(s.nextLine().trim());}catch(NumberFormatException e){throw new ValidationException("Enter a valid whole number.");}}
 public static String readRequired(Scanner s,String p)throws ValidationException{System.out.print(p);String v=s.nextLine().trim();if(v.isBlank())throw new ValidationException("This field cannot be empty.");return v;}
 public static LocalDate readDate(Scanner s,String p)throws ValidationException{String v=readRequired(s,p+" (YYYY-MM-DD): ");try{return LocalDate.parse(v);}catch(DateTimeParseException e){throw new ValidationException("Use date format YYYY-MM-DD.");}}
 public static ItemCategory readCategory(Scanner s)throws ValidationException{System.out.println("1-ELECTRONICS 2-ID_CARD 3-BOOK 4-CLOTHING 5-ACCESSORY 6-STATIONERY 7-OTHER");int n=readInt(s,"Choose category: ");if(n<1||n>ItemCategory.values().length)throw new ValidationException("Invalid category.");return ItemCategory.values()[n-1];}
}
