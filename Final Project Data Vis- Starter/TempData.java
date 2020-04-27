/* 
 * This class encapsulates the data recorded for a time series of high and low 
 * temperature readings.
 * The interval unit and two related data points are modeled by this object and 
 * are represented as a String and two integers.
 * For example, if the time interval is monthly: "January", 33, 13.
*/
public class TempData {
  String timeUnit;
  int tempOne;
  int tempTwo;

   /* 
    * Declare three instance variables: timeUnit, tempOne and tempTwo.
    */ 
    // TODO: write the instance variable declarations

    /* 
    * Initialize the three values.
    */ 
    public TempData(String time, int t1, int t2){
    timeUnit=time;
    tempOne=t1;
    tempTwo=t2;
        // TODO: implement this method
    }

    /* Returns the name of this unit of time.
    */     
    public String getTime(){
       // TODO: implement this method
        return timeUnit;
    }

    /* Returns the first observation.
    */     
    public int getTempOne(){
    // TODO: implement this method
        return tempOne;
    }

    /* Returns the second observation.
    */    
    public int getTempTwo(){
    // TODO: implement this method
        return tempTwo;
    }
    
    /* Returns a String representation of this object.
     * Used for debug/testing.
    */
    public String toString(){
        return timeUnit+", "+tempOne+", "+tempTwo;
    }
}