/**
 * This class encapsulates the data required to represent a movie in a collection
 * of MediaItems. It derives from MediaItem.
 * In addition to its superclass attributes, the attributes of a movie are: 
 *       int: playing time (minutes), String; lead actor, and String: year of release.
 **/
 public class Movie extends MediaItem {
  
  private int playTime;
  private String leadActor;
  private String releaseYear;
  
   
  public Movie(String title, String author, String genre, 
                   int playTime, String leadActor, String releaseYear){
   
   super(title,author,genre);
   this.playTime=playTime;
   this.leadActor=leadActor;
   this.releaseYear=releaseYear;
   

  }
  
 
  public int getPlayTime(){
  return playTime;
 }
 
 public String getLeadActor(){
 return leadActor;
}

 public String getReleaseYear(){
 return releaseYear;
}





  
  @Override
  public String toString(){
     return "Movie: " + super.toString()+ ", " + playTime+ ", " + leadActor + ", " + releaseYear;
  }
}