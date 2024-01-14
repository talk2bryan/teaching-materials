import java.util.Scanner;

public class FortuneCookie {
  public static void main (String [] parms) {
    double mealCost = 24.11;
    String userInput;
    
    Scanner kbd = new Scanner(System.in);
    
    System.out.println("The cost of the meal is $"
                         + mealCost
                         + ", would you like to tip?");
    userInput = kbd.nextLine();
    
    if (userInput.equalsIgnoreCase("yes")) {
      // do sth
      System.out.println("how many percent would you like to tip?");
      double tip = kbd.nextDouble();
      
      System.out.println("tip: " + tip);
      
      double finalBill = (tip/100 + 1) * mealCost;
      // TODO: round to 2 decimal places
      System.out.println("Your final bill is $" 
                           + finalBill);
      
    } else {
      // Ali is cheap af
      System.out.println("Your final bill is $" 
                           + mealCost);
    }
    
    System.out.println("Thanks Ali for eating with us");
    
  }
}