import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class CatchingReadWriteExceptions {

   public static void closeFileWriter(FileWriter fileName) {
      try {
         if (fileName != null) {
            System.out.println("Closing file.");
            fileName.close();
         }
      } catch (IOException closeExcpt) {
         System.out.println("Error closing file: " + closeExcpt.getMessage());
      }
   }
   

   public static void closeFileReader(FileReader fileName) {
      try {
         if (fileName != null) { 
            System.out.println("Closing file.");
            fileName.close(); 
         }
      } catch (IOException closeExcpt) {
         System.out.println("Error closing file: " + closeExcpt.getMessage());
      }
   }
   
   public static void readFileChars(FileReader file) throws IOException {
      int charRead = 0;     
      System.out.print("Reading character values: ");
      while (charRead != -1) {   // -1 means end of file has been reached
         charRead = file.read(); 
         System.out.print(charRead + " ");
      }
      System.out.println();
   }


   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      FileWriter writer = null;  
      FileReader reader = null; 
      String fileName;       // User defined file name
      boolean validFile = true;     // Ensures file opened
      
      final int NUM_CHARS_TO_WRITE = 26; // Num chars to write to file
      char charWrite = 'a'; // Char data written to file
      int countVar = 0; //Keep track of number chars written

      // Prompt user for input
      System.out.print("Enter a valid name to create a file: ");
      fileName = scnr.next();
      
      //try-catch block 1
      try {
         System.out.println("Creating file " + fileName + ".");
         writer = new FileWriter(fileName);
         System.out.print("Writing " + NUM_CHARS_TO_WRITE + " characters: ");
         while (countVar < NUM_CHARS_TO_WRITE) {
            writer.write(charWrite);
            System.out.print(charWrite);
            charWrite++; // Get next char ready
            countVar++;  // Increment number of chars written
         }
         System.out.println();
        
      } catch (IOException excpt) {
         System.out.println("Caught IOException: " + excpt.getMessage());
      } finally {
         closeFileWriter(writer); 
      }
      System.out.print("Enter a valid file name to read (or 'q' to quit): ");
fileName = scnr.next();
reader = new FileReader(fileName);
readFileChars(reader);

     /* do {
  
         System.out.print("Enter a valid file name to read (or 'q' to quit): ");
         fileName = scnr.next();

         if (fileName.equals("q")) {
            break; // Exit do-while loop
         }
         
         //try-catch block 2
         try {
            // Prompt user for input
            System.out.println("Opening file " + fileName + ".");
            reader = new FileReader(fileName); 
            validFile = true;             
            readFileChars(reader);            
          }
         catch (FileNotFoundException excpt) {
            System.out.println("Caught FileNotFoundException: " + excpt.getMessage());
            validFile = false;
         } 
         catch (IOException excpt) {
           System.out.println("Caught IOException: " + excpt.getMessage());
         }
         finally {
            closeFileReader(reader); 
         }
      } while (!validFile);
      */     
      
   }//end main
}//end class