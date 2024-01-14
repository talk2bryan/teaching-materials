import java.util.Arrays;

public class ComparingObjects {
  public static void main(String [] parms) {
    Person p = new Person();
    System.out.println("Census = " + Person.census());
    Person q = new Person();
    System.out.println("Census = " + Person.census());
    
    Person r = new Person();
    System.out.println("Census = " + Person.census());
    
    Person mike = new Person("Mike", 10);
    System.out.println(mike);
    
    Person person1 = new Person("Henry", 67);
    Person person2 = new Person("Henry", 67);
    Person person3 = new Person("Henry", 67);
    System.out.println(person1 == person2);
    
    System.out.println(person1.equals(person2));
    
    System.out.println(person1.compareTo(person3));
    
    tryCopy();
  }
  public static void tryCopy() {
    int [] arr = {1, 2, 3, 4, 5, 6};
    
    int [] arr2 = new int[arr.length];
    int [] arr3 = new int[arr.length];
    
//    for (int i=0; i<arr.length; i++)
//      arr2[i] = arr[i];
//    
//// Or using System.arraycopy()
//    System.arraycopy(arr, 0, arr2, 0, arr.length);
    int j = 1;
    int numElementsToCopy = 4;
    for (int i=j; i< (j+numElementsToCopy); i++)
      arr2[i] = arr[i];
    
    // Doing the same thing in one line is cleaner
    System.arraycopy(arr, 1, arr3, 1, 4);
    
    // Display them:
    System.out.println("arr: " + Arrays.toString(arr));
    System.out.println("arr2: " + Arrays.toString(arr2));
    System.out.println("arr3: " + Arrays.toString(arr3));
  }
}