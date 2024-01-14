/**Utility class for sharing common behaviour across
  * files.
  */
public class ArrayUtilities {
  /**Given two sorted lists a and b,
    * merge them into a new list c
    * such that c contains a and b and c 
    * is sorted.
    * 
    * 
    * returns: int[]
    */
  public static int[] merge(int[] a, int[]b) {
    // Length of both lists combined
    int []c = new int[a.length + b.length]; 
    
    // Keep track of where we are in the 3 lists
    int indexA = 0, indexB = 0, indexC = 0;
    int numA = a.length; // numItems in a
    int numB = b.length; // numItems in b
    
    // While still copying from both lists
    while(indexA < numA && indexB < numB ) {
      if (a[indexA] < b[indexB]) // item in A is smaller
        c[indexC++] = a[indexA++];
      else // item in B is smaller
        c[indexC++] = b[indexB++];
    }
    /**At this point, we're done copying over elements from one
      * of the lists.
      * But, there might still be items in the other list we
      * still haven't copied over.
      * 
      * Note: 
      * one of a or b definitely has uncopied items BUT NOT BOTH
      */
    // Are we done copying from [a]? No? Copy over the remaining items 
    while(indexA < numA)
       c[indexC++] = a[indexA++];
    
    // Are we done copying from [b]? No? Copy over the remaining items
    while(indexB < numB)
       c[indexC++] = b[indexB++];
    
    return c;
  }
  
  // Perform a simple swap of elements in an array given 
  // the array and the two positions of the elements
  public static void swap(int [] arr, int from, int to) {
    int temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;  
  }
  
  /** Check if an array is sorted, returns boolean **/
  private static boolean issorted(int []a) {
    boolean result = true;
    for (int i = 1; result && i<a.length; i++) {
      if (a[i-1] > a[i]) {
        result = false;
      }
    } // for
    return result;
  } // issorted()
  
  /**Creates a random
    * integer array of "size" elements. Each item 
    * between the range: [10, 99]
    */
  public static int [] randArr(int size) {
    int [] result = new int [size];
    int lo = 10;
    int hi = 99;
    
    int range = hi-lo;
    for (int i = 0; i < result.length; i++)
      result[i] = lo + (int)(Math.random() * range);
    return result;
  }
}