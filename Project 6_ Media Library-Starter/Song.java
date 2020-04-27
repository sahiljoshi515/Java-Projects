/**
 * This class encapsulates the data required to represent a song in a collection
 * of MediaItems. It derives from MediaItem.
 * In addition to its superclass attributes, the attributes of a song are: 
 *       playing time, album, and label.
 **/
 public class Song extends MediaItem {

  private double playTime;//minutes
  private String album;
  private String label;
 

  public Song(String title, String author, String genre, 
     double playTime, String album, String label){
     super(title,author,genre);
     this.playTime=playTime;
     this.album=album;
     this.label=label;
     



  }
  
 // get method for the play time
  public double getPlayTime(){
     return playTime;
  }
  
   // get method for the album 
  public String getAlbum(){
     return album;
  }
  
   // get method for the label
  public String getLabel(){
     return label;
  }
  
     @Override
  public String toString(){
    super.toString();
    return "Song: " + super.toString() + ", "+ playTime +", " + album + ", " + label;
  }
}