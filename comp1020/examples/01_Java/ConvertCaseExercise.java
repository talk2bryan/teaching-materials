public class ConvertCaseExercise {
  
  
  public static void main(String[] args) { 
    // Test method.
    System.out.println( convertCase("CAT", true) );
    System.out.println( convertCase("chandler", false) );
    System.out.println( convertCase("hi, i am a student!", false) );
    System.out.println( convertCase("HELLO, UPPERCASE * 2", true) );
    printTerminatingMsg();
  }
  
  public static void printTerminatingMsg() {
    System.out.println("End of Processing.");
  }
  
  public static String convertCase(String str, boolean isUpperCase) {
    String result = "";
    
    if (isUpperCase) { 
      /*
       * This is the same as:
       *    if (upperCase == true) {...}
       * 
       * Always use 
       *     if (isUpperCase) or if (!isUpperCase)
       * instead of 
       *     if (upperCase == true) or if(upperCase == false)
       * 
       * because it is the correct way of checking the value 
       * of a boolean
       * 
       */   

      // str is in all caps!
      // Convert each char
      char ch;
      for (int i = 0; i < str.length(); i++) {
        ch = str.charAt(i);
        if (ch >= 'A' && ch <= 'Z') // If char is an uppercase letter
          result += (char)(ch - 'A' + 'a');
        else result += ch; // else it is a special char like white space
      }
    } else {
      // str is in lowercase.
      char ch;
      for (int i = 0; i < str.length(); i++) {
        ch = str.charAt(i);
        if (ch >= 'a' && ch <= 'z')
          result += (char)(ch - 'a' + 'A');
        else
          result += ch;
      }
    }
    return result;
  }
}
