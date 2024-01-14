/** Demonstrating (Binary) Search using Recursion
  */
public class Recursion1 {
  public static void main(String[] args) {
    // A sorted list
    int [] data = new int[] {2, 3, 4, 7, 9, 13, 16, 17, 18, 22, 26};
    // Test the iterative search...
    System.out.format("Does %d exist? -> %d%n", 100, search(data, 100));
    // Test recursive (binary) search...
    System.out.format("Does %d exist? -> %d%n", 13, search2(data, 13));
    System.out.format("Does %d exist? -> %d%n", 100, search2(data, 100));
    System.out.format("Does %d exist? -> %d%n", 2, search2(data, 2));
  }
  /**
   * Iterative search:
   *     Search for key (x) within list 
   * Returns:
   *     -1 if x is not on the list
   *     its index if x is on the list
   */
  public static int search(int [] data, int x) {
    int result = -1;
    for(int i = 0; i < data.length; i++) {
      if (data[i] == x)
        return i;
    }
    return result;
  }
  
  /**Recursive search. Same return as above 
    * 
    * We have the same signature as the previous 
    * as we would like to provide the user with
    * a simpler interface for a search.
    * They do not need to know how the search is
    * being done.
    */
  public static int search2(int [] data, int x) {
    // We need a range to search. We start with 
    // the entire length of the list.
    int start = 0;
    int end = data.length -1;
    
    // Perform a binary search!
    return binarySearch(data, x, start, end);
  }
  
  /*Binary search:
   * Search data for the key x between startIndex and endIndex
   */
  public static int binarySearch(int [] data, int x, int startIndex, int endIndex) {
    
    /* Alternatively:
     * We could rewrite this by having the base case come first:
     * if(endIndex  > startIndex) {
     *     return -1; // Base case
     * } else { // Recursive case
     *     int midIndex =  ....
     *     ....
     * }
     * 
     * Would give you the same result...
     */
    
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
        return binarySearch(data, x, startIndex, midIndex-1); // Search lower half
      else // x is greater so x must be on the right half of the list 
        return binarySearch(data, x, midIndex+1, endIndex);      
    }
    return -1; // Base case (endIndex  > startIndex)
  }
  
  
}