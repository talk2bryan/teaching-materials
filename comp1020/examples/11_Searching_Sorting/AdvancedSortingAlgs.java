import java.util.Arrays;
import java.util.Date;

/**Demonstrating the 3 advanced searching algorithms
  * 1 - Shell Sort
  * 2 - Merge Sort
  * 3 - Quick Sort
  */
public class AdvancedSortingAlgs {
  
  public static void main(String [] parms) throws Exception {
    
    final int SIZE = 10000;
    // for tracking time
    long startTime, endTime; 
    double elapsedTime;
    
    
    int [] data1 = ArrayUtilities.randArr(SIZE);
    int [] data2 = ArrayUtilities.randArr(SIZE);
    int [] data3 = ArrayUtilities.randArr(SIZE);
    
//    System.out.format("Arr before shell sort:    %s%n", Arrays.toString(data1));
    startTime = new Date().getTime(); 
    shellSort(data1);
    endTime = new Date().getTime();
    elapsedTime = (endTime - startTime)/ 0.001; // Milliseconds to seconds
    System.out.format("Shell sort took %.4f seconds%n", elapsedTime);
//    System.out.format("Arr after shell sort:     %s%n", Arrays.toString(data1));
    
//    System.out.format("Arr before merge sort:    %s%n", Arrays.toString(data2));
    startTime = new Date().getTime(); 
    data2 = mergesort(data2);
    endTime = new Date().getTime();
    elapsedTime = (endTime - startTime)/ 0.001; // Milliseconds to seconds
    System.out.format("Merge sort took %.4f seconds%n", elapsedTime);
//    System.out.format("Arr after merge sort:     %s%n", Arrays.toString(data2));
    
//    System.out.format("Arr before quick sort:    %s%n", Arrays.toString(data3));
    startTime = new Date().getTime(); 
    quicksort(data3);
    endTime = new Date().getTime();
    elapsedTime = (endTime - startTime)/ 0.001; // Milliseconds to seconds
    System.out.format("Quick sort took %.4f seconds%n", elapsedTime);
//    System.out.format("Arr after quick sort:     %s%n", Arrays.toString(data3)); 
    
  } // main()
  

  private static int [] mergesort(int []arr) {
    
    // base case: size == 1, return it as it is sorted
    
    if (arr.length > 1) { // recursive case
      // Split the array into 2 halves
      int [] part1 = new int[arr.length/2]; // n/2
      int [] part2 = new int[arr.length - (arr.length/2)]; // n- (n/2) for odd sizes
      
      // Copy the first end/2 elements from arr to part1
      System.arraycopy(arr, 0, part1, 0, part1.length);
      // Copy the remaining items in arr into part2
      System.arraycopy(arr,  part1.length, part2, 0, part2.length);
      // O(log n)
      part1 = mergesort(part1); // sort left half
      part2 = mergesort(part2); // sort right half
      // O( n)
      arr = ArrayUtilities.merge(part1, part2); // merge both sorted halves
    }
    return arr;
  } // mergesort()
  
  private static void shellSort (int [] arr) {
    int size = arr.length;
    int interval;
    // Based on the slides, let's start from k = 3^4 down to 3^0 as the interval
    int exponent = 4;
    
    while (exponent >= 0) {
      interval = (int)(Math.pow(3, exponent));
      shellSort(arr, interval);
//      System.out.println("interval = " + interval); // Debug print statemement (remove)
      exponent--;
    } // while
  } // shellSort()
  
  private static void quicksort(int [] a) {
    // Call the recursive Quicksort
    quicksort(a, 0, a.length-1);
  }
  
  /** Overloaded Quicksort method with extra params for
    * lower and upperbounds of the array.
    * 
    * Quicksort takes O(n * log n)
    */
  private static void quicksort(int [] a, int lo, int hi) {
    if (lo < hi) { // Recursive case
      int pivot = partition(a, lo, hi); // This takes O(n)
      // These two lines take O(log n)
      quicksort(a, lo, pivot-1); // sort left half
      quicksort(a, pivot+1, hi); // // sort right half
    }
  }
  
  /**
   * Complexity: O(n)
   * 
   * return: index of the partition (pivot), where all the items to the 
   *         left of the pivot are less than than the pivot, and all the
   *         elements to the right are >= a[pivot]
   */
  private static int partition(int [] a, int lo, int hi) {
    int pivot = a[hi];// We choose the last element as the pivot
    int pivotIndex = lo; // pivotIndex is i in the algorithm on the slides
    
    // One for-loop goes through the span of the array => O(n)
    for (int j = lo; j < hi; j++) { 
      if (a[j] < pivot) {
        ArrayUtilities.swap(a, pivotIndex, j);
        pivotIndex++;
      }
    }
    ArrayUtilities.swap(a, pivotIndex, hi);
    return pivotIndex;
  }
  
  
  // Overloaded shell sort method with an extra param for 
  // interval called step
  private static void shellSort (int [] arr, int step) {
    for (int i = step; i < arr.length; i++) {
      int j = i;
      int item = arr[j];
      
      /**Insertion sort's inner loop is: 
        *    while(j > 0 && arr[j-1] > arr[j])
        * step is never 0 hence 
        *   j >= 1 is the same as j > 0
        * 
        * also: j = j-1 in insertion sort is same as
        *       j = j-step where step is always 1 in insertion sort
        */
      while(j >= step &&  arr[j-step] > arr[j]) {
        ArrayUtilities.swap(arr, j, j-step);
        j = j-step;
      } // inner while
    } // outer for-loop
  } // shellSort()
} // class AdvancedSortingAlgs