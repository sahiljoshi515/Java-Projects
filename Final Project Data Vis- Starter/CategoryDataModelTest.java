import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.List;
import java.util.ArrayList;

public class CategoryDataModelTest {

   private ArrayList<TempData> td;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      td = new ArrayList<TempData>();
      td.add(new TempData("One", 50, 100));
   }


   /** Test CategoryDataModel Constructors. **/
   @Test 
   public void constructor1Test() {
      CategoryDataModel cdm = new CategoryDataModel(td);
      Assert.assertNotEquals("CategoryDataModel is initialized.", null, cdm);
   }
   
      @Test 
   public void constructor2Test() { 
      CategoryDataModel cdm = new CategoryDataModel(td, "Series1", "Series2");
      Assert.assertNotEquals("CategoryDataModel is initialized.", null, cdm);
   }
   
   /** Test CategoryDataModel contents. **/
   @Test 
   public void dataModelContentsTest() {
      CategoryDataModel cdm = new CategoryDataModel(td, "Series1", "Series2");
      CategoryDataset cds = cdm.createCategoryDataset();
      Assert.assertNotEquals("CategoryDataset is initialized.", null, cds);
       	int colCt = cds.getColumnCount();
         int rowCt = cds.getRowCount();
         List colKeys = cds.getColumnKeys(); 
         List rowKeys = cds.getRowKeys();
         int val1 = cds.getValue(0, 0).intValue();
         int val2 = cds.getValue(1, 0).intValue();
      Assert.assertEquals("Column count is correct.", 1, colCt);
      Assert.assertEquals("Row count is correct.", 2, rowCt);
      Assert.assertEquals("Column key is correct.", "One", colKeys.get(0));
      Assert.assertEquals("Row key one is correct.", "Series1", rowKeys.get(0));
      Assert.assertEquals("Row key two is correct.", "Series2", rowKeys.get(1));
      Assert.assertEquals("Value at row 0, col 0 is correct.", 50, val1);
      Assert.assertEquals("Value at row 1, col 0 is correct.", 100, val2);
      
   }
   
   /** Test getLineChart in main. **/
   @Test 
   public void lineChartTest() {  
      String title="Title", hAxis="xAxis", vAxis="yAxis"; 
      CategoryDataModel cdm = new CategoryDataModel(td, "Series1", "Series2");
      CategoryDataset cds = cdm.createCategoryDataset(); 
      LineChart chart = TempDataMain.getLineChart(title, hAxis, vAxis, cds);
      Assert.assertNotEquals("LineChart object is returned.", null, chart);
      Assert.assertEquals("LineChart object is returned.", true, chart instanceof LineChart);
   }
}
