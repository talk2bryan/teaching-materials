/**In-class demo on the basics of the 
  * LinkedList data structure.
  * 
  * See a similar version of this in Python:
  * https://towardsdatascience.com/linked-lists-in-python-91906f22a282
  */
public class LinkedListDemo1 {
  public static void main (String [] parms) {
    
    LinkedList myList = new LinkedList();
    myList.add(99);
    myList.add(10);
    myList.add(12);
    myList.add(5);
    
    System.out.println(myList);
    
    myList.delete(10);
    System.out.println(myList);
    
    myList.delete(5);
    System.out.println(myList);
    
    myList.add(1, 6);
    System.out.println(myList);
    
    myList.add(100, 6); // Try inserting at end of list
    System.out.println(myList);
    
    myList.add(-1, 8); // Try inserting at beginning
    System.out.println(myList);

    insertStrings();
  } // main()
  
  /**
   * Demontrating ordered insertion into a 
   * LinkedList of String objects
   */
  private static void insertStrings() {
    LinkedList myList = new LinkedList();
    myList.orderedInsert("keto");
    myList.orderedInsert("apple");
    myList.orderedInsert("xerox");
    myList.orderedInsert("zero");
    myList.orderedInsert("bread");
    
    System.out.println(myList);
  } // insertStrings()
} // LinkedListDemo1



