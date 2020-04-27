import java.util.Scanner;
import java.io.*;

public class DisplayFile{
  public static void main(String[] args)  throws IOException
  {
    String fileName;
    Scanner nameReader = new Scanner(System.in);
    System.out.println("Enter a file name");
    fileName = nameReader.nextLine();
    Scanner scan = new Scanner(new FileReader(fileName));
    while(scan.hasNext()){
      System.out.println(scan.nextLine());
    }
    scan.close();
  }
}

