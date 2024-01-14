import java.util.Arrays;

// Binary Search Using Recursion and Iteratively
public class BinarySearch {
  public static void main(String [] p) {
    // A sorted list
    int [] data = new int[] {2, 3, 4, 7, 9, 13, 16, 17, 18, 22, 26};
    
    System.out.println(Arrays.toString(data));
    System.out.format("%nRecursive Binary Search:%n");
    
    int index = binarySearchRecursion(data, 7, 0, data.length-1);
    System.out.format("7 was found at index %d%n", index);
    index = binarySearchRecursion(data, 30, 0, data.length-1);
    System.out.format("30 was found at index %d%n", index);
    
    
    System.out.format("%nIterative Binary Search:%n");
    
    index = binarySearchIterative(data, 7, 0, data.length-1);
    System.out.format("7 was found at index %d%n", index);
    index = binarySearchIterative(data, 30, 0, data.length-1);
    System.out.format("30 was found at index %d%n", index);
  } // main()
  
   /*Binary search:
   * Search data for the key x between startIndex and endIndex
   */
  
  // Recursive Binary Search
  public static int binarySearchRecursion(int [] data, int x, int startIndex, int endIndex) {    
    // Recursive case
    if (endIndex >= startIndex) {
      // Find the mid point in the list
      int midIndex = startIndex + (endIndex - startIndex)/2; 
      // Is that middle value what we're looking for?
      if (data[midIndex] == x) 
        return midIndex; // Yes it is, we're done!
      // If it's not, what direction do we search next?
      // If x is less than the middle element, x would be
      // in the lower half of the list
      if (data[midIndex] > x) 
        return binarySearchRecursion(data, x, startIndex, midIndex-1); // Search lower half
      else // x is greater so x must be on the right half of the list 
        return binarySearchRecursion(data, x, midIndex+1, endIndex);      
    }
    return -1; // Base case (endIndex < startIndex)
  } // binarySearchRecursion
  
  // Iterative Binary Search
  public static int binarySearchIterative(int [] data, int x, int startIndex, int endIndex) {
    
    while (endIndex >= startIndex) {
      int midIndex = startIndex + (endIndex - startIndex)/2;
      
      if (data[midIndex] == x)
        return midIndex; // FOund
      else if (data[midIndex] > x)
        endIndex = midIndex-1;
      else 
        startIndex = midIndex+1;
    } // while
    
    return -1; // Did not find it!
  } // binarySearchIterative
}