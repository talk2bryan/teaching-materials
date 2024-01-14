import java.util.Scanner;
/** 
 * For your convenience, test this using what
 * Read in a string from the user, and 
 * determine whether or not it's a palindrome 
 * (reads the String in both directions). 
 * 
 * Only letters are processed, and letter cases. 
 * Leading/trailing whitespaces are ignored. 
 */

public class Palindrome {
  public static void main(String [] parms) {
    
    Scanner kbd = new Scanner(System.in);
    String prompt = "Enter a possible palindrome: ";
    String input = "";
    
    do {
      System.out.format("%n%s%n",prompt);
      input = kbd.nextLine();
      
      // check if input is a palindrome
      boolean isPalindrome = isPalindrome(input);
      
      // Give the verdict
      if (isPalindrome)
        System.out.format("The word %s is a palindrome%n", input);
      else
        System.out.format("Word: %s is not a palindrome%n", input);
    } while (!input.equalsIgnoreCase("Q"));
    
    kbd.close();
    System.out.println("End of processing");
  }
  
  /** 
   * 
   * @param word
   * @return true/false if word is a Palindrome
   */
  public static boolean isPalindrome(String word) {
    String compressed = "";  // A copy, with all the non-letters removed
    
    word = word.toUpperCase().trim(); // Make all chars same case, remove (leading/trailing) whitespaces too.
    
    // Go through everything, find only letters and add them to compressed string
    for (int i = 0; i < word.length(); i++) {
      if (Character.isLetter(word.charAt(i)))
        compressed += word.charAt(i);
    }
    
    // Let's see what that string is without those extra characters
    System.out.format("Compressed: %s%n", compressed);
    
    // Now let's see if it is a Palindrome!
    boolean isPalindrome = true;
    int n = compressed.length(); // Just for convenience because n is shorter
    
    // Note the boolean in the for-loop. It means, continue if all is good so far
    for (int i = 0; isPalindrome && i < n/2; i++) {
      if (compressed.charAt(i) != compressed.charAt(n-1-i))
        isPalindrome = false;
    }
    
    return isPalindrome;
  }
}