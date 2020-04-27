import java.util.Scanner;
/* This class runs a console interface between a user and 
 * a Calculator that converts metric to English units and vice-versa.
*/
public class CalculatorMain {
       
    public static void main(String[] args){
       
         System.out.println("Calculator");
         Scanner scan = new Scanner(System.in);
         Calculator calc = new Calculator();
         
         boolean keepGoing = true;
         String inputStr = "";
         double result = 0.00;
         
         while(keepGoing) {
              System.out.println("Main Menu:");
              System.out.println("Enter F to convert Fahrenheit to Celsius."); 
              System.out.println("Enter C to convert Celsius to Fahrenheit."); 
              System.out.println("Enter I to convert inches to centimeters."); 
              System.out.println("Enter E to convert centimeters to inches."); 
              System.out.println("Enter X to quit.");
              System.out.println("");
              inputStr = scan.nextLine();
              
              if (inputStr.equalsIgnoreCase("F")){
                 System.out.println("Enter the temp in degrees F: ");
                 inputStr = scan.nextLine();
                 result = calc.fahrenheitToCelsius(Double.parseDouble(inputStr));
                 System.out.println(inputStr+" deg Fahrenheit = "+result+" deg Celsius.");
              }
              else if (inputStr.equalsIgnoreCase("C")){
                 System.out.println("Enter the temp in degrees C: ");
                 inputStr = scan.nextLine();
                 result = calc.celsiusToFahrenheit(Double.parseDouble(inputStr));
                 System.out.println(inputStr+" deg Celsius = "+result+" deg Fahrenheit.");
              }              
              else if (inputStr.equalsIgnoreCase("I")){
                 System.out.println("Enter the length in inches: ");
                 inputStr = scan.nextLine();
                 result = calc.inchesToCentimeters(Double.parseDouble(inputStr));
                 System.out.println(inputStr+" inches = "+result+" centimeters.");
              }
              else if (inputStr.equalsIgnoreCase("E")){
                 System.out.println("Enter the length in centimeters: ");
                 inputStr = scan.nextLine();
                 result = calc.centimetersToInches(Double.parseDouble(inputStr));
                 System.out.println(inputStr+" centimeters = "+result+" inches.");
              }              
              else if(inputStr.equalsIgnoreCase("X")){
                 keepGoing = false;
              }
              else
                 System.out.println("Unrecognized input.");
              System.out.println("");               
         }
         System.out.println("Bye for now.");
         scan.close();
    } 
}