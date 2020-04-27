import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**This class encapsulates a list of media items in a user's collection.
*  The list is implemented as either an ArrayList or array of type MediaItem.
*  Media items are either a book (electronic format), movie, podcast, or song. 
*  Each type of media item is represented by an instance of the Book, Movie, Podcast, or Song class.
*  These classes are subclasses of MediaItem. The list stores media items as 
*  references of type MediaItem.   
**/
public class MediaList {

 
   /*
    * Class instance variable declarations section.
    * You are required to declare at least one instance variable called itemList.
    * That variable should be either an array or an ArrayList of type MediaItem. 
    * This variable is the primary data structure that stores all of the MediaItem objects 
    * in the library.
    * You may declare other instance variables if you wish. Points will be 
    * deducted if you declare local variables here. A variable is local if
    * it is used in only one method.
   */
   private ArrayList<MediaItem> itemList;

   public MediaList(){
      itemList= new ArrayList<MediaItem>();
   }
   
  
   public void addItem(MediaItem newItem){
      
      itemList.add(newItem);
   }
   
      public boolean containsItem(String targetTitle, String targetAuthor){
    for(MediaItem find: itemList){
    if(find.getTitle().equalsIgnoreCase(targetTitle) && find.getAuthor().equalsIgnoreCase(targetAuthor))
    return true;
    }
   
      return false;  
   }
   
  
   public boolean removeItem(String targetTitle, String targetAuthor)
    {for(MediaItem search:itemList){
      if(search.getTitle().equalsIgnoreCase(targetTitle)&&search.getAuthor().equalsIgnoreCase(targetAuthor)){
      itemList.remove(search);
      return true;
    }
  }
      return false;
   }
   
    
   public String[] getItemListAsStringArray(){
    String[] arr = new String[itemList.size()];
    for(int i=0;i<itemList.size();i++){
    arr[i]=itemList.get(i).toString();
    }
      return arr;
   }

   
   public String[] getAllItemsByTitle(String targetTitle){
   int cnt=0;
   for(MediaItem search: itemList){
   if (search.getTitle().equalsIgnoreCase(targetTitle))
   cnt++;
   }
   String[] item= new String[cnt];
  int found=0;
  
   for(MediaItem search: itemList){
   if (search.getTitle().equalsIgnoreCase(targetTitle))
   item[found]=search.toString();
   found++;
   if(found==cnt)
   break;
  }
   
   
   
      
      return item;    
   }
   
     
   public String[] getAllItemsByAuthor(String targetAuthor){
   int cnt=0;
   for(MediaItem search: itemList){
   if (search.getAuthor().equalsIgnoreCase(targetAuthor))
   cnt++;
   }
   String[] item= new String[cnt];
  int found=0;
   for(MediaItem search: itemList){
   if (search.getAuthor().equalsIgnoreCase(targetAuthor))
   item[found]=search.toString();
   found++;
   if(found==cnt)
   break;
  }
   
   

      return item;    
   }
   
     
   public String[] getSortedListOfAuthors(){
     String[] arr = new String[itemList.size()];
     for(int i=0;i<itemList.size();i++){
     arr[i]=itemList.get(i).getAuthor();
     }
     Arrays.sort(arr);
      return arr;
   }
   
     public int getNumItems(){
   
      return itemList.size();
   }
    
     public boolean isEmpty(){
      
      return itemList.isEmpty();
   }
  
    }