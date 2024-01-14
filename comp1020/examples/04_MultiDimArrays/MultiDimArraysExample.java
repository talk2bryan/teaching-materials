public class MultiDimArraysExample {
  public static void main(String [] args) {
    
    int [][][] arr = { 
      {
        {1, 2}, 
        {3, 4}
      }, 
      {
        {5, 6}, 
        {7, 8}
      }, 
      {
        {9, 0}, 
        {1, 2}
      } 
    };
    
    displayThreeDeeArray(arr);
    raggedArrayExample();
    activity1();
    System.out.println("The sum of my arr is " + sum(arr));
    System.out.println("The max in my arr is " + getMax(arr));
  } // main
  
  public static int getMax(int[][][] data) {
    System.out.println("Activity3 - max in a 3D array"); 
    int max = Integer.MIN_VALUE;
    int [] oneDee = data[0][0];
    int [][] twoDee = data[0];
    
    for (int i = 0; i<data.length; i++) {
      for (int j = 0; j<data[i].length; j++) {
        for (int k = 0; k<data[i][j].length; k++)
          if (data[i][j][k] > max)
          max= data[i][j][k];
      }
    }
    return max;
  }
  public static void raggedArrayExample() {
    // An uneven a.k.a "ragged" array
    int [][] arr2 = new int [3][]; 
    arr2[0] = new int[6];
    arr2[1] = new int[2];
    arr2[2] = new int[1];
    
    System.out.println("Ragged array: "); 
    for(int i = 0; i<arr2.length; i++){
      for(int j = 0; j <arr2[i].length; j++) {
        System.out.print( arr2[i][j] + " ");
      }
      System.out.println();
    }
    // Print extra space after printing our ragged array
    System.out.println(); 
  }
  
  
  
  
  public static void displayThreeDeeArray(int [][][]arr) {
    System.out.println("3D array:"); 
    // View the contents of arr (3x3)
    for(int i = 0; i<arr.length; i++){
      for(int j = 0; j <arr[i].length; j++) {
        for(int k = 0; k <arr[i][j].length; k++) {
          System.out.print( arr[i][j][k] + " ");
        }
        System.out.println(); // Next row in the 2x2 inner array
      }
      System.out.println(); // Leave space to print out next 2x2 array
    }
    // Print extra space after printing our 3D array
    System.out.println(); 
  }
  
  
  
  
  public static void activity1() {
    System.out.println("Activity1 - fill 2D array with random values"); 
    int [][] data = new int [3][3];
    int hi = 9;
    int lo = 8;
    
    int range = hi - lo + 1;
    
    for(int i = 0; i<data.length; i++){
      for(int j = 0; j <data[i].length; j++) {
        data[i][j] = lo + (int)(Math.random() * range);
      }
    }
    
    // display contents
    for(int i = 0; i<data.length; i++){
      for(int j = 0; j <data[i].length; j++) {
        System.out.print(data[i][j] + " " );
      }
      System.out.println();
    }
    // Print extra space after printing our array
    System.out.println(); 
  } // activity1()
  
  
  
  public static int sum(int [][][] data) {
    System.out.println("Activity2 - sum of a 3D array"); 
    int sum = 0;
    for(int i = 0; i<data.length; i++){
      for(int j = 0; j <data[i].length; j++) {
        for(int k = 0; k <data[i][j].length; k++) {
          sum += data[i][j][k];
        }
      }
    }
    return sum;
  } // activity2()
}