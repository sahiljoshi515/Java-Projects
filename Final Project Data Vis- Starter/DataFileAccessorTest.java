import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.lang.reflect.*;

import java.io.*;

public class DataFileAccessorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Test TempData Constructor. **/
   @Test 
   public void tempDataConstructorGetterTest() {
      String time = "February"; int t1=200, t2=300;
      TempData td = new TempData(time, t1, t2); 
      String obsTime = td.getTime();    
      int obsT1 = td.getTempOne();
      int obsT2 = td.getTempTwo();
      Assert.assertEquals("Time is initialized.", obsTime, time);
      Assert.assertEquals("Temp1 is initialized.", obsT1, t1);
      Assert.assertEquals("Temp2 is initialized.", obsT2, t2);
   }
   
   @Test 
   public void dataFileAccessorInitFileTest() {
     DataFileAccessor dfa = null;
     String f = "data/AmherstTempData.csv";
     boolean hasHeader = true;
     ArrayList<TempData> tempArr = null;
     String seriesOne=null, seriesTwo=null;
     try{ 
        dfa = new DataFileAccessor(f, hasHeader);
        tempArr = dfa.getData();
        seriesOne = dfa.getSeriesOneName();
        seriesTwo = dfa.getSeriesTwoName();
     }
     catch(IOException ioex){
          System.out.println("Error accessing file: "+f);
          System.out.println(ioex);
      }
      catch(Exception ex){
          System.out.println(ex);
      }
     Assert.assertEquals("TempData is initialized to an empty array.", 0, tempArr.size());
     Assert.assertEquals("seriesOne is correctly initialized to the empty String.", "", seriesOne);
     Assert.assertEquals("seriesTwo is correctly initialized to the empty String.", "", seriesTwo);
   } 
      
   @Test 
   public void dataFileAccessorProcFileTest() {
     DataFileAccessor dfa = null;
     String f = "data/AmherstTempData.csv";
     boolean hasHeader = true;
     ArrayList<TempData> tempArr = null;
     String seriesOne=null, seriesTwo=null;
     try{ 
        dfa = new DataFileAccessor(f, hasHeader);
        dfa.processFile();
        tempArr = dfa.getData();
        seriesOne = dfa.getSeriesOneName();
        seriesTwo = dfa.getSeriesTwoName();
     }
     catch(IOException ioex){
          System.out.println("Error accessing file: "+f);
          System.out.println(ioex);
      }
      catch(Exception ex){
          System.out.println(ex);
      }
     Assert.assertEquals("TempData is correctly populated.", 12, tempArr.size());
     Assert.assertEquals("seriesOne is correctly initialized.", "Avg High Temp", seriesOne);
     Assert.assertEquals("seriesTwo is correctly initialized.", "Avg Low Temp", seriesTwo);
   } 
   
   @Test 
   public void dataFileAccessorProcFileDataTest() {
     DataFileAccessor dfa = null;
     String f = "data/AmherstTempData.csv";
     boolean hasHeader = true;
     ArrayList<TempData> tempArr = null;
     String seriesOne=null, seriesTwo=null;
     boolean valid = true;
     try{ 
        dfa = new DataFileAccessor(f, hasHeader);
        dfa.processFile();
        tempArr = dfa.getData();
        valid = (valid && tempArr.get(0).getTime().equals("January") && tempArr.get(0).getTempOne()==33 && tempArr.get(0).getTempTwo()==13);
        valid = (valid && tempArr.get(1).getTime().equals("February") && tempArr.get(1).getTempOne()==37 && tempArr.get(1).getTempTwo()==16);
        valid = (valid && tempArr.get(2).getTime().equals("March") && tempArr.get(2).getTempOne()==45 && tempArr.get(2).getTempTwo()==24);
        valid = (valid && tempArr.get(3).getTime().equals("April") && tempArr.get(3).getTempOne()==58 && tempArr.get(3).getTempTwo()==35);
        valid = (valid && tempArr.get(4).getTime().equals("May") && tempArr.get(4).getTempOne()==69 && tempArr.get(4).getTempTwo()==45);
        valid = (valid && tempArr.get(5).getTime().equals("June") && tempArr.get(5).getTempOne()==78 && tempArr.get(5).getTempTwo()==55);
        valid = (valid && tempArr.get(6).getTime().equals("July") && tempArr.get(6).getTempOne()==82 && tempArr.get(6).getTempTwo()==59);
        valid = (valid && tempArr.get(7).getTime().equals("August") && tempArr.get(7).getTempOne()==81 && tempArr.get(7).getTempTwo()==58);
        valid = (valid && tempArr.get(8).getTime().equals("September") && tempArr.get(8).getTempOne()==73 && tempArr.get(8).getTempTwo()==49);
        valid = (valid && tempArr.get(9).getTime().equals("October") && tempArr.get(9).getTempOne()==62 && tempArr.get(9).getTempTwo()==38);
        valid = (valid && tempArr.get(10).getTime().equals("November") && tempArr.get(10).getTempOne()==49 && tempArr.get(10).getTempTwo()==30);
        valid = (valid && tempArr.get(11).getTime().equals("December") && tempArr.get(11).getTempOne()==38 && tempArr.get(11).getTempTwo()==20);
     }
     catch(IOException ioex){
          System.out.println("Error accessing file: "+f);
          System.out.println(ioex);
      }
      catch(Exception ex){
          System.out.println(ex);
      }
     Assert.assertEquals("TempData is contains correct data from file.", true, valid);
   }   
   
   @Test 
   public void dataFileAccessorFile1InitTest() {
     DataFileAccessor dfa = null;
     String f = "data/test1.csv";
     boolean hasHeader = true;
     ArrayList<TempData> tempArr = null;
     String seriesOne=null, seriesTwo=null;
     try{ 
        dfa = new DataFileAccessor(f, hasHeader);
        dfa.processFile();
        tempArr = dfa.getData();
        seriesOne = dfa.getSeriesOneName();
        seriesTwo = dfa.getSeriesTwoName();
     }
     catch(IOException ioex){
          System.out.println("Error accessing file: "+f);
          System.out.println(ioex);
      }
      catch(Exception ex){
          System.out.println(ex);
      }
     Assert.assertEquals("TempData is initialized to an empty array.", 2, tempArr.size());
     Assert.assertEquals("seriesOne is initialized to the empty String.", "Col1", seriesOne);
     Assert.assertEquals("seriesTwo is initialized to the empty String.", "Col2", seriesTwo);
   }  
   
   @Test 
   public void dataFileAccessorFile1DataTest() {
     DataFileAccessor dfa = null;
     String f = "data/test1.csv";
     boolean hasHeader = true;
     ArrayList<TempData> tempArr = null;
     String seriesOne=null, seriesTwo=null;
     boolean valid = true;
     try{ 
        dfa = new DataFileAccessor(f, hasHeader);
        dfa.processFile();
        tempArr = dfa.getData();
        valid = (valid && tempArr.get(0).getTime().equals("One") && tempArr.get(0).getTempOne()==1 && tempArr.get(0).getTempTwo()==2);
        valid = (valid && tempArr.get(1).getTime().equals("Two") && tempArr.get(1).getTempOne()==3 && tempArr.get(1).getTempTwo()==4);
     }
     catch(IOException ioex){
          System.out.println("Error accessing file: "+f);
          System.out.println(ioex);
      }
      catch(Exception ex){
          System.out.println(ex);
      }
     Assert.assertEquals("TempData is contains correct data from file.", true, valid); 
   }  
   
   @Test 
   public void dataFileAccessorFile2Test() {
     DataFileAccessor dfa = null;
     String f = "data/test2.csv";
     boolean hasHeader = false;
     ArrayList<TempData> tempArr = null;
     String seriesOne=null, seriesTwo=null;
     try{ 
        dfa = new DataFileAccessor(f, hasHeader);
        dfa.processFile();
        tempArr = dfa.getData();
        seriesOne = dfa.getSeriesOneName();
        seriesTwo = dfa.getSeriesTwoName();
     }
     catch(IOException ioex){
          System.out.println("Error accessing file: "+f);
          System.out.println(ioex);
      }
      catch(Exception ex){
          System.out.println(ex);
      }
     Assert.assertEquals("TempData is initialized to an empty array.", 3, tempArr.size());
     Assert.assertEquals("seriesOne is initialized to the empty String.", "", seriesOne);
     Assert.assertEquals("seriesTwo is initialized to the empty String.", "", seriesTwo);
   }
   
   @Test 
   public void dataFileAccessorFile2DataTest() {
     DataFileAccessor dfa = null;
     String f = "data/test2.csv";
     boolean hasHeader = false;
     ArrayList<TempData> tempArr = null;
     String seriesOne=null, seriesTwo=null;
     boolean valid = true;
     try{ 
        dfa = new DataFileAccessor(f, hasHeader);
        dfa.processFile();
        tempArr = dfa.getData();
        valid = (valid && tempArr.get(0).getTime().equals("Zero") && tempArr.get(0).getTempOne()==-1 && tempArr.get(0).getTempTwo()==0);
        valid = (valid && tempArr.get(1).getTime().equals("One") && tempArr.get(1).getTempOne()==1 && tempArr.get(1).getTempTwo()==2);
        valid = (valid && tempArr.get(2).getTime().equals("Two") && tempArr.get(2).getTempOne()==3 && tempArr.get(2).getTempTwo()==4);
     }
     catch(IOException ioex){
          System.out.println("Error accessing file: "+f);
          System.out.println(ioex);
      }
      catch(Exception ex){
          System.out.println(ex);
      }
     Assert.assertEquals("TempData is contains correct data from file.", true, valid); 
   }   

   @Test 
   public void subclassTest1() {
      Class aClass = DataFileAccessor.class;

      Method[] methods = aClass.getDeclaredMethods();
      Boolean ok = null;
      for (Method method : methods){
         ok = true;
         if( method.getName().equals("processFile") || method.getName().equals("writeToFile")){
            ok = false;
         }
      }
      Assert.assertEquals("DataFileProcessor does not override superclass methods", true, ok);
   }
   
   @Test 
   public void subclassTest2() {
      Boolean ok = null;
// String fileName = "../submission/DataFileAccessor.java";
      String fileName = "DataFileAccessor.java";
      File file = new File(fileName);
      try{
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         String line;
         ok = true;
         while((line = br.readLine()) != null){
            if(line.contains("java.util.Scanner")){
               ok = false;
            }
         }
      } catch(Exception ex){
         System.out.println("Couldn't find file");
         ex.printStackTrace();
      }
      Assert.assertEquals("DataFileProcessor does not import io or Scanner.", true, ok);
   }
   
//Test Exceptions thrown by processLine

  @Test
  public void checkDataFileProcessingExceptionThrownTest1() throws DataFileProcessingException{ 
    //should not throw a DataFileProcessingException.
    String file = "data/AmherstTempData.csv";
    try{
       DataFileAccessor dfa = new DataFileAccessor(file, true);
       dfa.processFile();
    }catch(IOException ex){;}
  }
  
  @Test(expected = DataFileProcessingException.class)
  public void checkDataFileProcessingExceptionThrownTest2() throws DataFileProcessingException{
    //should throw a DataFileProcessingException as third row missing a data value.
    String file = "data/test3.csv";
    try{
       DataFileAccessor dfa = new DataFileAccessor(file, true);
       dfa.processFile();
    }catch(IOException ex){;}
  }
  
  @Test(expected = DataFileProcessingException.class)
  public void checkDataFileProcessingExceptionThrownTest3() throws DataFileProcessingException{
    //should throw a DataFileProcessingException as fourth row has non-numeric data value.
    String file = "data/test4.csv";
    try{
       DataFileAccessor dfa = new DataFileAccessor(file, true);
       dfa.processFile();
    }catch(IOException ex){;}
  }
}
