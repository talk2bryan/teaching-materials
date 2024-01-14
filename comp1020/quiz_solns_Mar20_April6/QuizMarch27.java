public class QuizMarch27 {
  public static void main(String [] parms) {
    
    System.out.format("%s%n", divisibleByN(20, 2));
    System.out.format("%s%n", divisibleByN(31, 4));
    System.out.format("isPal(abba) is %b%n", isPal("abba"));
    System.out.format("isPal(Madam I'm Adam) is %b%n", isPalindrome("Madam I'm Adam"));
    System.out.format("isPal(sandwhich) is %b%n", isPal("sandwich"));
    System.out.format("RecSum of %d is %d%n", 123, recSumOfDigits(123));
    
    LinkedList2 list = new LinkedList2();
    list.add(25);
    list.add(5);
    list.add(1);
    list.add(3);
    System.out.print("LinkedList: ");
    list.printList();
  }
  
  /** Removes spaces and punctuation and changes s to lowercase **/
  private static String cleanString(String s) {
    s = s.replaceAll("[^a-zA-Z]", ""); // Gots to love Regular Expressions! Replace everything not in that range with ""
    return s.toLowerCase();
  }
  
  /** Tells me whether or not s is a palindrome (recursively) **/
  // Assumption: s is not null and we can be passed an empty string
  public static boolean isPalindrome(String s) {
    s = cleanString(s); 
    return isPal(s);
  }
  
  private static boolean isPal(String s) {
    boolean result = false;
    if (s.length() == 0 || s.length() == 1) // base case(s).
      result = true;
    
    int firstChar = 0;
    int lastChar = s.length() - 1;
    
    // Are firstChar and lastChar the same?
    if (!result && s.charAt(firstChar) == s.charAt(lastChar)) 
      result = isPal(s.substring(firstChar+1, lastChar)); // Yes! Check rest of the string w/o the first and last chars
    return result; // if first and last are not the same then it is not a palindrome!
  }
  /* Tell me how many times num is evenly divisible by n */
  private static String divisibleByN(int num, int n) {
    int x = div(num, n);
    String result = String.format("%d is divisible by %d, %d times.", num, n, x);
    return result;
  }
  
  // Recursively perform long division
  // returns how many times num is evenly 
  // divisible by n.
  private static int div(int num, int n) {
    int result = 0;
    int division = num/n;
    int remainder = num%n;
    
    if (remainder == 0) // If it divides evenly, count it
      result = 1 + div(division, n); 
    return result; // base case, if it doesn't just don't count it
  }
  
  /** Recursively calculates the sum of digits
    * 123 = 1 + 2 + 3 = 6.
    * 
    * Strategy:
    * Extract 3 as 123 %10 = 3 (12 rem 3)
    * Remains 12 as 123/10 = 12 (int division discards remainder)
    * Same for 2..
    * 
    * Base case? one digit! 
    *   In this case: 1
    *   1 % 10 = 1 (0 rem 1).
    *   so if x%x == x, we are looking at one digit (or the last digit left)
    */
  private static int recSumOfDigits(int x) {
    int result = 0;
    if (x % 10 == x) // last digit standing 
      result = x;
    else
      result = x%10 + recSumOfDigits(x/10); // grab one digit, recurse the rest
    
    return result;
  }
}

/** For the 1 LinkedList question **/
/** Appended "2" as they conflict w/last week's solution (same folder problems) **/
class LinkedList2 {
  private Node2 start;
  
  public LinkedList2() {
    start = null;
  }
  public void add (int datum) {
    start = new Node2(datum, start);
  }
  
  public void printList() {
    System.out.print("[");
    printList(start);
    System.out.println("]");
  }
  
  private void printList(Node2 node) {
    if (node == null) // Base case, we are done; 
      return;
    
    System.out.print(node.getDatum());
    if (node.getNext() != null)
      System.out.print(", ");
    
    printList(node.getNext()); // Recursive case
  }
}

class Node2 {
  private Node2 next;
  private int datum;
  
  public Node2 (int datum) {
    this.datum = datum;
  }
  
  public Node2 (int datum, Node2 next) {
    this.datum = datum;
    this.next = next;
  }
  
  public Node2 getNext() {
    return next;
  }
  public void setNext(Node2 next) {
    this.next = next;
  }
  public int getDatum() {
    return datum;
  }
  public void setDatum(int datum) {
    this.datum = datum;
  }
}
