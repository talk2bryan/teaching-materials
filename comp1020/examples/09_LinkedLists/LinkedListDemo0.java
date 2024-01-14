/**In-class demo on the basics of the 
  * LinkedList data structure.
  * 
  * See a similar version of this in Python:
  * https://towardsdatascience.com/linked-lists-in-python-91906f22a282
  */
public class LinkedListDemo0 {
  public static void main (String [] parms) {
    
    LinkedList myList = new LinkedList();
    myList.add(5);
    myList.add(3);
    myList.add("This is a String");
    myList.add(new int [] {5, 12});
    
    System.out.println(myList);
    
    LinkedList stringsList = new LinkedList();
    
    stringsList.add("best");
    stringsList.add("better");
    stringsList.add("good");
    
    System.out.format("LinkedList contains: %n%s%n", stringsList);
    
  } // main()
  
} // LinkedListDemo0



