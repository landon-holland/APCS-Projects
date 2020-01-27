/* PayrollSystemInterface.java
1. Requrest employee name, type, pay rate, and hours.
2. Print employee name and pay.
3. Repeat until the name is blank.
4. Print the total pay. */

import java.util.Scanner;

public class PayrollSystemInterface {

   public static void main (String [] args) {

      Scanner reader = new Scanner(System.in);
      Employee emp;    // employee
      String name;     //   name     
      int    type;     //   type 
      double rate;     //   hourly pay rate
      int    hours;    //   hours worked    
      String prompt;   // user prompt;
      
      while (true){
      
         // Get the name and break if blank
         System.out.println("Enter employee data");
         System.out.println("  Name (or blank to quit): ");
         name = reader.nextLine();
         name = name.trim(); // Trim off leading and trailing spaces
         if (name.length() == 0) break;
         
         // Get the type until valid
         while (true){
            prompt = "  Type (" + Employee.getTypeRules() + "): ";
            System.out.println(prompt);
            type = Integer.parseInt(reader.nextLine());
            if (Employee.typeOK(type)) break;
         }
         // Instantiate an employee of the correct type and set the name
         if (type == 1)
            emp = new FullTimeEmployee();
         else
            emp = new PartTimeEmployee();
         emp.setName(name);
         
         // Get the hourly pay rate until valid
         while (true){
            prompt = "  Hourly rate (" + Employee.getRateRules() + "): ";
            System.out.println(prompt);
            rate = Double.parseDouble(reader.nextLine());
            if (emp.setRate(rate)) break;
         }
            
         // Get the hours worked until valid
         //   To illustrate the possibilities we compress this code 
         //   into a single unreadable statement.
         System.out.println("  Hours worked (" + Employee.getHoursRules() + "): ");
         while (!emp.setHours(Integer.parseInt(reader.nextLine())));
         
         // Print the name and pay
         System.out.println
            ("  The weekly pay for " + emp.getName() + 
             " is $" + emp.getPay());
      }
      
      // Print the total pay
      System.out.println  ("\nTotal pay: " + Employee.getTotalPay());
   }
}   
         

