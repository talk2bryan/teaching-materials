public class DataTypesExamples {
  
  public static void main(String [] parms) {
    // Multi-line Strings
    System.out.println("The quick brown fox " +
                       "jumps over " +
                       "the lazy dog."
                      );
    // Printing the special char " in a String
    System.out.println("\"");
    
    // String to Integer
    String num = "20";
    int numInt = Integer.parseInt(num);
    numInt++;
    
    // Integer to String, and concatenation
    String numToString = Integer.toString(numInt);
    numToString = numToString + " this is a string";
    
    System.out.println(numToString);
    
    
    // Casting from small to big
    int numInt2 = 60;
    double numDouble = (double)numInt2;
    System.out.println(numDouble);
    // Casting from big to small 
    double numDouble2 = 12.9999;
    int numInt3 = (int)numDouble2;
    System.out.println(numInt3);
    
    // Integer to String, shortcut.
    String str = "" + numInt3;
    System.out.println("" + numInt3);
  }
}
