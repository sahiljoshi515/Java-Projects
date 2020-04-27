/**
 * This class encapsulates the data required to represent a book in electronic format
 * in a collection of MediaItems. It derives from MediaItem.
 * In addition to its superclass attributes, the attributes of a book are: 
 *       number of pages and font size.
 **/
 public class Book extends MediaItem {

  private int numPages;
  private double fontSize;
 

  public Book(String title, String author, String genre, 
                   int numPages, double fontSize){
    super(title,author,genre);
    this.numPages=numPages;
    this.fontSize=fontSize;



  }
  
  // get method for the number of pages
  public int getNumPages(){
     return numPages;
  }
  
  // get method for the font size
  public double getFontSize(){
     return fontSize;
  }
  
  @Override
  public String toString(){
     return "Book: " + super.toString() + ", " + numPages + ", " + fontSize;
  }
}