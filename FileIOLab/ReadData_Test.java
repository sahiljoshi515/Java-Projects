import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadData_Test {

   public static void main(String args[]) {
  
FileReader fr = null; 
try{
      //FileReader fr = null;     
      File file = new File("whitmanpoem.txt");
      fr = new FileReader(file); 
      char [] arr = new char[50];
      fr.read(arr);   // reads the content to the array
      
for(char charLetter : arr){
      System.out.print(charLetter);
      }
}

catch (IOException e) {
         e.printStackTrace();
      }
      finally {
         try {
            fr.close();
         } catch (IOException ex) {   
            ex.printStackTrace();
         }
}

      
  // prints the characters one by one
  }
 }   
 
 
 
 
 