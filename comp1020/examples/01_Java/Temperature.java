public class Temperature {
  public static void main(String [] parms) {
    final int MAX_TEMP = 20;
    final int MIN_TEMP = 10;
    
    int temp = 12; 
    boolean beachDay = false;
    boolean goingToWork = true;
    boolean t = temp > MAX_TEMP;
    
    if ( t || beachDay) {
      System.out.println("Wear shorts");
    } else if (temp > MIN_TEMP && goingToWork) {
      System.out.println("Wear pants");
    } else {
      System.out.println("Wear a jacket.");
    }
  }
}