/* This class provides calculations that convert temperature and length
   measurements from metric to English and vice-versa.
 */
 
public class Calculator {
   private double tempC;
   private double tempF;
   private double inches;
   private double centimeters;
 
   public Calculator(){
      tempC = 0.0;
      tempF = 0.0;
      inches = 0.0;
      centimeters = 0.0;
 
   }
    /* This method converts degrees Fahrenheit to degrees Celsius
       according to this formula:  C = ( F-32 ) x 5/9
     */
    public double fahrenheitToCelsius(double tempF) {
        tempC = (tempF - 32)*(5.0/9.0);
        return tempC;
    }
    
    /* This method converts degrees Celsius to degrees Fahrenheit
       according to this formula:  F = C x 9/5 + 32
     */
    public double celsiusToFahrenheit(double tempC) {
        tempF = tempC*(9.0 + 5.0) + 32;
        return tempF;    }
 
    /* This method converts inches to centimeters
       according to this formula:  cm = inches x 2.54
     */
    public double inchesToCentimeters(double inches) {
        centimeters = inches * 2.54;
        return centimeters;
    }
 
    /* This method converts centimeters to inches
       according to this formula:  inches = cm / 2.54
     */
    public double centimetersToInches(double centimeters) {
        return 0.0;
    }
}