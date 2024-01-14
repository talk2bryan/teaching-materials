import java.io.*;

public class CheckedExceptions {
  public static void main (String [] parms) /* throws FileNotFoundException */ {
    // We can afoord to do this methodA calls
    // methodB and they both did not indicate
    // an exception might be thrown. So we do
    // not need a try/catch.
    // If an exception occurs in those methods,
    // that would be classified as an unchecked
    // Exception. e.g. a NullPointerException
    methodA();
    
    // A FileNotFoundException is a type of 
    // IOException which happens when we are
    // performing any type of IO operations.
    // These are checked Exceptions and would
    // cause a compile-time error if we do not
    // use a try/catch or throw an Exception from
    // this method as you can see up there as
    // /* throws FileNotFoundException */
    try {
      throwIOException();
    } catch (FileNotFoundException fnf) {
      System.out.println("fnfException in main");
    }
    
    System.out.println("Program ended gracefully");
  }
  
  public static void methodA() {
    // Innocent methodA calls methodB() to do
    // some work.
    //
    // methodA does not need to worry about any kinds of
    // exception because the method signature of
    // methodB does not indicate that it may 
    // throw any Exception.
    methodB();
    
    System.out.println("methodA ended gracefully");
  }
  
  // Do not need to add "throws ArithmeticException" because
  // it is an "unchecked" Exception
  public static void methodB() {
    // Do something sketchy. If I die, we all die 
    int x = 5/0;
    
    // If I survive, let them (my haters) know
    System.out.println("methodB ended gracefully");
  }
  
  // This method indicates to any method that calls it that
  // it may throw a FileNotFoundException. 
  // This would tell the programmer who intends to use this method
  // to guard for that Exception.
  // The programmer can either place the call to this method in 
  // a try/catch block, or modify its method signature to 
  // throw a FileNotFoundException.
  public static void throwIOException() throws FileNotFoundException {
    int x = 6;
    
    if (x > 5)
      throw new FileNotFoundException("the file does not exist");
    
    System.out.println("throwIOException ended gracefully");
  }
  
  
}