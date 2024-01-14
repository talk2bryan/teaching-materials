public class ThrowingExceptions {
  
  public static void main(String [] parms) throws Exception{
    int x = methodA();
    System.out.println(" X contains " + x);
    
  }
  
  public static int methodA() throws Exception {
    Exception e = new Exception("My Exception");
    
    int x = 50;
    
    if (x < 100)
      throw e;
    
    return x;
  }
  
  
}