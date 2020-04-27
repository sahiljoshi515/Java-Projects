import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.IOException;

/*
 * This class extends FileAccessor. It parses temperature data from a file
 * that is formatted in a comma-seperated values (.csv) format. This class also 
 * handles data file with or without headers.
*/
public class DataFileAccessor extends FileAccessor{

   //Instance variable declarations.
   ArrayList<TempData> dataList;
   boolean firstLine;// used so if the data file has a header the first line is not parsed.
   String seriesOneName; // the name of the second column (in the file header).
   String seriesTwoName; // the name of the third column (in the file header).

  /*
   * Initialize dataList.
   * The firstLine variable is assigned to the hasHeader parameter.
   * Initialize the two series Strings to the empty String.
  */
  public DataFileAccessor(String f, boolean hasHeader) throws IOException{
  super(f);
  dataList= new ArrayList<TempData>();
  firstLine=hasHeader;
  seriesOneName="";
  seriesTwoName="";
       }
  
  /* 
   * This method parses one line from the data file. 
   * The line is tokenized using the String class split method. The split method returns an array of Strings.
   * These Strings are called "tokens".
   * Since the file is comma-delimited (.csv file), the split method uses the comma as a delimiter.
   * Each line (not including a header) is of the form: Month, high temp, low temp.  For example: January,33,13.
   * For example, the first token is "January", the second token is "33", and the third token is "13".
   * The second and third tokens are Strings and have to be converted to integers by the Integer.parseInt method.
   * Then the converted tokens, a String and two int values are passed to a call to the TempData constructor.
   * This new TempData object is then placed on dataList.

   * If the data file has a header- i.e. column names in the first row, seriesOneName is assigned 
   * to the second token (the second column name), and seriesTwoName is assigned to the third token.
   * The firstLine variable is used to detect when processLine is called on the first line. It should
   * be set to false after the first line has been processed. If the data file has no header, firstLine 
   * will be false.

   * This method throws a DataFileProcessingException if:
   * 1) A row in the data does not have three values. If this is the case, the message should be:
   * "Incorrect line length: "+ line (see the test file test3.csv).
   * 2) The second or third values are not numeric. You can detect this by catching a NumberFormatException,
   * which is thrown by the Integer.parseInt method if it trys to parse non-numeric data. If a NumberFormatException 
   * is caught, throw a new DataFileProcessingException.
   * The message for the DataFileProcessingException should be: "Encountered non-numeric data: "+line
   * (see the test file test4.csv).
   * (Of course, you would put the Integer.parseInt calls in a try block).
  */
  protected void processLine(String line) throws DataFileProcessingException {
     String[] parts = line.split(",");
     if(parts.length<3)
     throw new DataFileProcessingException("Incorrect line length: "+ line);
     String a = parts[1];
     String b = parts[2];
     if(firstLine)
     { 
        firstLine=false;
        seriesOneName=parts[1];
        seriesTwoName=parts[2];
        return; 
     }             
   
    try {   int select1 = Integer.parseInt(a);
            int select2 = Integer.parseInt(b);
            dataList.add(new TempData(parts[0],select1,select2));
        }
     catch(NumberFormatException e){
     throw new DataFileProcessingException("Encountered non-numeric data: "+line);
        }
          
      
        
     
  }
  
  /* 
   * Return an array that contains only TempData objects and no NULL values.
   * If the dataArray has no TempData objects, an array of zero length is returned. 
  */
   public ArrayList<TempData> getData(){
   
      return dataList;
   }
   
   // Return the first series name.  
   public String getSeriesOneName(){
   
       return seriesOneName;
   }
   
   // Return the second series name.  
   public String getSeriesTwoName(){
  
       return seriesTwoName;
   }
}
