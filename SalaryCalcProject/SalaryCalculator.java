/**
  * This class contains methods that perform various calculations about 
  * an individual's salary.
**/
public class SalaryCalculator {                         
   
   private int workingWeeksPerYear;
   final int MONTHS_PER_YEAR=12;

   public SalaryCalculator (){
        workingWeeksPerYear = 50;
       //TODO1: initialize workingWeeksPerYear to 50

   }
   
   /* TODO2: Implement this method.
    * This method calculates and returns the annual (yearly) salary based on an hourly wage
    * and the hours worked per week.
    */
   public double calculateAnnualSalary(double hourlyWage, double hoursPerWeek){
       
        return hourlyWage*hoursPerWeek*workingWeeksPerYear;
   }

   /* TODO3: Implement this method.
    * This method calculates and returns the monthly salary based on an hourly wage
    * and the hours worked per week.
    */   
   public double calculateMonthlySalary(double hourlyWage, double hoursPerWeek){
       return (hourlyWage*hoursPerWeek*workingWeeksPerYear)/12;
        
   }
   
}

