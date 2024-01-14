import java.util.Scanner;

public class FortuneCookieV2 {
  
  // Global costant variable
  final static double MEAL_COST = 24.11;
  
  public static void main (String [] parms) {
    
    String userInput;
    
    Scanner kbd = new Scanner(System.in);
    
    System.out.println("The cost of the meal is $"
                         + MEAL_COST
                         + ", would you like to tip?");
    userInput = kbd.nextLine();
    
    if (userInput.equalsIgnoreCase("yes")) {
      // do sth
      System.out.println("how many percent would you like to tip?");
      double tip = kbd.nextDouble();
      
      System.out.println("tip: " + tip);
      
      double finalBill = addTip(tip);
      // TODO: round to 2 decimal places
      System.out.println("Your final bill is $" 
                           + finalBill);
      
    } else {
      // Ali is cheap af
      System.out.println("Your final bill is $" 
                           + MEAL_COST);
    }
    
    printMsg();
  }
  public static void printMsg() {
    if (true)
      return; // early exit
    System.out.println("Thanks Ali for eating with us");
  }
  public static double addTip(double tip) {
    return (tip/100 + 1) * MEAL_COST;
  }
}