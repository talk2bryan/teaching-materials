public class FibonacciAndBinary {
  public static void main(String [] parms) {
    int n = 5;
    System.out.format("fib(%d) = %d%n", n, fib(n));
    
    bin(30);
    System.out.println();
  }
  
  /** Find the Fibonacci number recursively **/
  public static int fib(int n) {
    if (n == 0 || n ==  1)
      return 1;
    return fib(n -2) + fib(n-1);
  }
  /** Print the binary of x on the console **/
  private static  void bin(int x) {
    // Base case: x == 0, do nothing (end recursion).
    if (x > 0) {// Recursive case
      bin(x/2);
      System.out.print(x%2);
    }
  }
}
