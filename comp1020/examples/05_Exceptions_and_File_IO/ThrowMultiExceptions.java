import java.io.*;
import java.util.Arrays;

public class ThrowMultiExceptions {
  public static void main (String [] parms) {
    
    
    int [] arr = new int [10];
    
    try {
      for (int i = 0; i< 50000; i++)
        arr[i] = i;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("We encountered an ArrayIndexOutOfBoundsException, I guess the loop is over.");
    }
    
    System.out.println(Arrays.toString(arr));
    
    
    try {
      methodA();
    } catch (FileNotFoundException fnf) {
System.out.println("We got a FileNotFoundException with the message: " +
                         fnf.getMessage());
    } catch (ArithmeticException ae) {
      System.out.println("We got an ArithmeticException with the message: " +
                         ae.getMessage());
    }
    
    System.out.println("Program ended gracefully");
  }
  
  
  public static void methodA() throws FileNotFoundException, ArithmeticException, NullPointerException {
    int x = 0;
    if (x < 0)
      throw new FileNotFoundException("FileNotFoundException in methodA");
    
    throw new ArithmeticException("ArithmeticException in methodA");
  }
  
  
  public static void methodB() {
    int x = 5/0;
    
    System.out.println("methodB ended gracefully");
  }
}