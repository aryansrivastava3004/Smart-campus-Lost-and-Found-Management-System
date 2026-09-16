package com.campuslostfound.service;
import com.campuslostfound.model.Item; import java.time.temporal.ChronoUnit; import java.util.*;
public class MatchingService {
 public record MatchResult(Item lost,Item found,int score){}
 public List<MatchResult> findMatches(List<Item> lost,List<Item> found){List<MatchResult> out=new ArrayList<>();for(Item l:lost)for(Item f:found){if(l.getStatus().name().equals("CLOSED")||f.getStatus().name().equals("CLOSED"))continue;int s=score(l,f);if(s>=50)out.add(new MatchResult(l,f,s));}out.sort(Comparator.comparingInt(MatchResult::score).reversed());return out;}
 private int score(Item l,Item f){int s=0;if(l.getCategory()==f.getCategory())s+=30;if(l.getLocation().equalsIgnoreCase(f.getLocation()))s+=30;String ft=(f.getTitle()+" "+f.getDescription()).toLowerCase();for(String w:(l.getTitle()+" "+l.getDescription()).toLowerCase().split("[^a-z0-9]+")){if(w.length()>=4&&ft.contains(w)){s+=5;if(s>=85)break;}}long days=Math.abs(ChronoUnit.DAYS.between(l.getDate(),f.getDate()));if(days==0)s+=15;else if(days<=2)s+=10;else if(days<=7)s+=5;return Math.min(s,100);}
}
