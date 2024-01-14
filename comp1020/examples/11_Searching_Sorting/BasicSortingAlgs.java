import java.util.Arrays;

/**Demonstrating the 3 simple searching algorithms
  * 1 - Selection Sort
  * 2 - Insertion Sort
  * 3 - Bubble Sort
  */
public class BasicSortingAlgs {
  public static void main(String [] parms) {
    final int SIZE = 15;
    int [] data = ArrayUtilities.randArr(SIZE);
    int [] data2 = ArrayUtilities.randArr(SIZE);
    int [] data3 = ArrayUtilities.randArr(SIZE);
    
    
    System.out.format("Arr before selection sort: %s%n", Arrays.toString(data));
    selectionSort(data);
    System.out.format("Arr after selection sort:  %s%n", Arrays.toString(data));
    
    System.out.println();
    
    System.out.format("Arr before insertion sort: %s%n", Arrays.toString(data2));
    insertionSort(data2);
    System.out.format("Arr after insertion sort:  %s%n", Arrays.toString(data2));
    
    System.out.println();
    
    System.out.format("Arr before bubble sort:    %s%n", Arrays.toString(data3));
    bubbleSort(data3);
    System.out.format("Arr after bubble sort:     %s%n", Arrays.toString(data3));
  } // main()
  
  private static void selectionSort(int [] arr) {
    for (int i = 0; i < arr.length; i++) { // n
      int min = arr[i];
      int pos = i;
      
      for (int j = i+1; j < arr.length; j++) { // n - 1 -> n
        if (arr[j] < min) {
          min = arr[j];
          pos = j;
        }
      } // for j (inner loop)
      // We have a new min, pos
      // Swap arr[i] with (arr[pos] == min)
      ArrayUtilities.swap(arr, i, pos);
    } // outer for-i
  } // selectionSort()
  
  private static void insertionSort(int [] arr) {
    for (int i = 1; i < arr.length; i++) { // n-1 = n
      int item = arr[i];
      int j = i;
      
      while(j > 0 && arr[j-1] > arr[j]) { // n-1 = n
        ArrayUtilities.swap(arr, j, j-1);
        j--;
      } // inner while
    } // outer for-i
  } // insertionSort()
  
  private static void bubbleSort(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      // Last i elements are already in place
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j+1]) {
          ArrayUtilities.swap(arr, j, j+1);
        }
      } // inner for-j
    } // outer for-i
  } // bubbleSort()
} // class BasicSortingAlgs