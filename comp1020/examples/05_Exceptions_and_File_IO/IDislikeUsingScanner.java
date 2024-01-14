import java.io.*;
import java.util.Scanner;

public class IDislikeUsingScanner {
  public static void main(String [] parms) {

    readUserInput();
    performFileIO();
  }
  
  // Reading input from user
  // Try to guess the output of the following code:
  public static void readUserInput() {
    Scanner kbd = new Scanner(System.in);
    
    System.out.print("Enter an integer: "); 
    int intVal = kbd.nextInt(); 
    
    System.out.print("Enter a String: "); 
    String strVal = kbd.nextLine(); 
    
    System.out.println("You have entered the number: "
                         + intVal + " and string value: " + strVal + "."); 
    
    /* Explanation: 
     * In the Scanner class, if we call nextLine() method after any one of the nextXXX() methods (nextInt, nextDouble,
     * next, nextLong, etc), then the nextLine() doesn’t not read values from console, at least the first time.
     *
     * This is because, when we enter an integer 56 for instance, we type 56 and hit the ENTER key to send it to the 
     * program.
     * The Scanner object's buffer would contain "56\n".
     * 
     * 
     * When you use nextInt(), it grabs the first integer occurence from the buffer, which is 56.
     * Then, the buffer would only contain "\n".
     * 
     * nextLine() reads consumes the contents of the buffer until the first newline character.
     * 
     * So, when you attempt to collect user input again using nextLine(), it consumes the "\n" left in the buffer, 
     * this is why we do not get a second prompt. 
     * 
     * The only fix is to use an additional nextLine() call after performing any of the nextXXX to get rid of the 
     * "\n" character. Add:
     * 
     *               kbd.nextLine(); 
     * 
     * after the "intVal = kbd.nextInt()" line and see it works? Sigh.
     * 
     */
    kbd.close();
  } // readUserInput
  
    public static void performFileIO() {
    Scanner scan;
    
    try {
      /**
       * When a Scanner reads a line or String, it treats it as a sequence of “tokens” 
       * These are any consecutive non-blank characters.
       * 
       * Read the entire file into Scanner object, scan.
       * 
       * The file contains just one line:
       * 34.2  Fred        false  -3
       * 
       * The scanner object buffer would contain 4 items (or tokens):
       * "34.2", "Fred", "false" and "-3"
       * 
       * 
       * You can see check if there are any more tokens, and, if so, get the next one (as a String) with:
       * scan.hasNext() - gives the boolean answer - are there any more tokens?
       * scan.next() - gives the next token, as a String.
       * 
       * You can work with types like boolean, int, long, etc with:
       * scan.hasNextInt() - gives the boolean - is the next token an integer? It does not read it, just checks.
       * scan.nextInt() - reads the next token as an int
       * scan.nextLong() - reads the next token as a long; and so on.
       * 
       * The nextLine() is different, it ignores the tokens and gives you the whole line as one big String
       */
      scan = new Scanner(new File("weirdTextFile.txt"));
      
      // Let's print all numbers in the file as type double
      String junk; 
      while (scan.hasNext()) { // Buffer contains tokens.
          if (scan.hasNextDouble()) // Is the next token "convertible" to a double?
              System.out.println(scan.nextDouble()); // yes it is, print it!
          else // it is not, so get rid of it by moving to the next token
              junk = scan.next();
      }

      scan.close();
    } catch (FileNotFoundException fnf) {
      System.out.println(fnf.getMessage());
    }
  }// performFileIO()
}
