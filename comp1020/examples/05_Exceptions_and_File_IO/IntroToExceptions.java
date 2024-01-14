public class IntroToExceptions {
  public static void main(String [] parms) {
    Exception e = new Exception();
    System.out.println(e);
    
    NullPointerException myE = new NullPointerException();
    System.out.println(myE);
    
    Exception what = methodA();
    System.out.println("Something happened");
    
    if (what != null) {
      System.out.println("The message is " + what.getMessage());
      System.out.println("Where did this happen?");
      
      what.printStackTrace();
    }

  }
  
  
  public static Exception methodA() {
    Exception e = new Exception("Big Oof!");
    return e;
  }
}