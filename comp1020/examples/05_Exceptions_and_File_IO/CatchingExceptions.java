public class CatchingExceptions {
  public static void main(String [] parms) throws Exception {
    
    try {
      int x = methodA();
      System.out.println(" X contains " + x);
    } catch(ArithmeticException ae) {
      System.out.println("We had an ArithmeticException: " + ae.getMessage());
    } catch(NullPointerException npe) {
      System.out.println("We had a NullPointerException");
    }
    
    System.out.println("Continue with main method...");
  }
  
  public static int methodA() throws Exception {
    // Swap both lines and see what happens
    try{
      
      int y = methodB();
    } catch(Exception e) {
      System.out.println("Caught an exception in methodA: " + e.getMessage());
    }
    int x = 5/0; // Try a non-zero denominator and see what happens
    
    System.out.println("Continue with methodA method...");
    
    return x;
  }
  
  public static int methodB() throws Exception {
    int x = 11;
    if(x > 10) //Try both true and false conditions here
      throw new NullPointerException();
    
    System.out.println("Continue with methodB method...");
    return 0;
  }
}