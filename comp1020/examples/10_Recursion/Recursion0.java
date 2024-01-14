/**
 * Demonstrating Recursion
 */
public class Recursion0 {
  public static void main(String [] parms) {
    int n = 5;
    int fact = factIter(n);
    
    System.out.format("fact (iterative): %d %n", fact);
    System.out.format("fact (recursive): %d %n", fact(n));
    System.out.format("sum (recursive): %d %n", sum(200));
    System.out.format("pow (recursive): %d %n", powerOfTwo(n));
    
    recursionOnLinkedLists();
  }
  
  // Iterative version of Factorial 
  public static int factIter(int n) {
    int fact = 1;
    for (int i = n; i > 0; i--) {
      fact *= i;
    }
    return fact;
  }
  
  /** Finding factorial of n using resursion.
    * See the factorial sequence here:
    * https://en.wikipedia.org/wiki/Factorial
    * You can test for correctness by passing in any value of n
    */
  public static int fact(int n) {
    if (n <= 1) // Base case
      return 1;
    return n * fact(n-1); // Recursive case
  }
  
  /** Summation from i = 0 to n using Recursion **/
  public static int sum(int n) {
    if (n == 0)
      return 0;
    return n + sum(n-1);
  }
  /** Solving 2^n using Recursion **/
  public static int powerOfTwo(int n) {
    if (n == 0)
      return 1;
    return 2 * powerOfTwo(n-1);
  }
  
  /** Seeing how we can do things recursively while working with LinkedLists **/
  public static void recursionOnLinkedLists() {
    LinkedList list = new LinkedList();
    list.add(5);
    list.add(30);
    list.add(33);
    list.add(2);
    System.out.println(list);
    
    System.out.format("search (5): %d %n", list.search(5));
    System.out.format("search (33): %d %n", list.search(33));
    System.out.format("search (10): %d %n", list.search(10));
  } // recursionOnLinkedLists
} // Recursion0 class
