import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.jfree.data.category.CategoryDataset;

/* This class runs the application that reads average high and low temperature data observed
 * on a monthly basis, converts that data into an object that can be rendered as a BarChart.
 * The JFreeChart library is used to render the chart.
 */
public class TempDataMain {

   public static void main(String[] args)  {
      System.out.println("Data Visualizer");
      Scanner scan = new Scanner(System.in);
      DataFileAccessor dfa = null;
      boolean dataAcquired = false;

      System.out.println("Enter data file to read:");
      String fileName = scan.nextLine();  
      
      // Create object to read in and parse text data in file. Note: this file has a header,
      // so true is the second arg.
      try{
         dfa = new DataFileAccessor(fileName, true);
      }catch(IOException ioex){
         System.out.println("Error finding or opening the file: "+fileName);        
      }
      if(dfa!=null) {
                 try{
         dfa.processFile();
         dataAcquired = true;
         } catch(DataFileProcessingException e){
          System.out.println(e.getMessage());
          }
    


         if(dataAcquired) {
            // Get the data in the form of TemData objects.
            ArrayList<TempData> tempData = dfa.getData();
            // Create a data model that can be rendered by a chart in the JFreeChart library.
            CategoryDataModel cdm = new CategoryDataModel(tempData, dfa.getSeriesOneName(), dfa.getSeriesTwoName());
      
            System.out.println("Enter the chart title:");
            String title = scan.nextLine();   //"Amherst Average Temperatures"
            System.out.println("Enter the horizontal axis label:");
            String horizAxisLabel = scan.nextLine();   //"Month"
            System.out.println("Enter the vertical axis label:");
            String vertAxisLabel = scan.nextLine();    //"Temp (deg F)"

            // Get type of plot from user:
            System.out.println("Enter type of plot: B for bar chart, L for Line Chart:");
            String plotType = scan.nextLine();
            if(plotType.equalsIgnoreCase("B")){
               BarChart chart = getBarChart(title, horizAxisLabel, vertAxisLabel, cdm.createCategoryDataset());
               chart.display(); 
            }
            else if(plotType.equalsIgnoreCase("L")) { 
                LineChart line = getLineChart(title, horizAxisLabel, vertAxisLabel, cdm.createCategoryDataset());
                line.display();
                 
            }
            else 
               System.out.println("Unrecognized chart type.");
         }//end if dataAcquired
      } // end if dfa!=null 
   }//end main
   
   //This method creates and returns a BarChart object initialized to the parameters passed in.
   public static BarChart getBarChart(String title, String hAxis, String vAxis, CategoryDataset ds){
      BarChart chart = new BarChart(title, hAxis, vAxis, ds);
      return chart;
   }
   
   //This method creates and returns a LineChart object initialized to the parameters passed in.
   public static LineChart getLineChart(String title, String hAxis, String vAxis, CategoryDataset ds){
      LineChart line = new LineChart(title, hAxis, vAxis, ds);
      return line;
       
   }
}