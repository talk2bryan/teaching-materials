import java.util.Scanner;

public class Input {
  public static void main(String [] parms) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter sth: ");
    String input = keyboard.next(); 
    
//    double doubleNum = keyboard.nextDouble();
//    doubleNum++;
    System.out.println(input);
  }
}
