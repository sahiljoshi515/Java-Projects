import java.io.*;
import java.util.*;

public class WriteFile{
  public static void main(String[] args)  throws IOException
  {
    String fileName;
    System.out.println("Enter a file name. It will hold output.");
    Scanner nameReader = new Scanner(System.in);
    fileName = nameReader.nextLine();
    PrintWriter writer = new PrintWriter(fileName);
    Scanner scan = new Scanner(System.in);
    String str = " "; // a String of length 1
    System.out.println("Enter text, end with 2 returns");
    while(str.length() > 0){
      str = scan.nextLine();
      writer.println(str);
    }
    writer.close();
   }
}
