import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.ArrayList;

/* This class converts an array of TempData objects into a DefaultCategoryDataset object
 * that is used to produce a graph or chart from the JFreeChart library.
*/
public class CategoryDataModel {
   
   ArrayList<TempData> dataList;
   // series labels
   String seriesOneName;
   String seriesTwoName;

   /* 
    * Assigns the array list passed in to the instance variable dataList.
    * Initializes the names of the series to the empty String. 
   */
   public CategoryDataModel(ArrayList<TempData> data){
     dataList=data;
     seriesOneName="";
     seriesTwoName="";
      
   } 
     
   /* 
   * Assigns the array passed in to the instance variable dataList. 
   * Initializes the names of the series.
   */
   public CategoryDataModel(ArrayList<TempData> data, String sOneName, String sTwoName){
    dataList=data;
    seriesOneName=sOneName;
    seriesTwoName=sTwoName;
         }
    /**
     * Creates and populates a CategoryDataset object
     * for the temperature data. This class is required by the BarChart object.
     */
    public CategoryDataset createCategoryDataset() {
        
        /* Create and populate the dataset object.
         * There are two series: series1 and series2. 
         * For each entry in dataArray you have two observed values: a high and a low 
         * temperature. The high temperatures are series1, the low temperatures 
         * are series 2.
         * The addValue method takes three argumants: 
         *     1- the observed value, a high or low temperatur.
         *     2- the series it belongs to, either series1 or series2 in this case.
         *     3- the label associated with that observation. This is the month.
         * For example, for each TempData object, you have two addValue calls. 
         * The calls would have these parameter values:  
         *      33, series1, "January" and 13, series2, "January".
         * Of course you have to get the temp and month data above from the TempData object.
         */
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(TempData curData: dataList){
            dataset.addValue(curData.getTempOne(), seriesOneName, curData.getTime());
            dataset.addValue(curData.getTempTwo(), seriesTwoName, curData.getTime());
        }  
        return dataset; 
    }
}