import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLists {

  public static void main(String[] args) {
    testArrayListMethods();
    activity();
  }
  
//    @SuppressWarnings("unchecked") - Turn off "unchecked" warnings
  private static void testArrayListMethods() {
    ArrayList<String> list = new ArrayList<String>(); // ArrayList to hold only String objects
    list.add("Hello there");
    list.add("Bonjour");
    
    System.out.format("ArrayList of Strings: %s%n", list);
    
    // Testing wrapper classes: Integer which wraps an int
    int n = 5;
    Integer n2 = new Integer(5); // creates a new Integer object with the value of 5
    n2++; // Behaves like the common int
    
    // We can also instatiate an Integer like the basic int
    Integer n3 = 5; // This does "n3 = new Integer(5)" under the hood.
    n3 += 9; // Again, like an int
    
    System.out.format(" %n%nLet's try an ArrayList of numbers: %n%n");
    
    // Hold an array of numbers and test more methods.
    ArrayList<Integer> list2 = new ArrayList<Integer>();
    list2.add(n);
    list2.add(new Integer(30));
    
    System.out.format("Adding the numbers {5 30} to the list%n");
    
    System.out.format("ArrayList of numbers: %s%n", list2);
    System.out.format("get index 1: %d%n", list2.get(1));
    list2.set(1, 9);
    System.out.format("set index 1 to 9: %s%n", list2);
    
    System.out.format("Adding the numbers {3 4 7 3 8 10 3} to the list%n");
    
    list2.add(3);
    list2.add(4);
    list2.add(7);
    list2.add(3);
    list2.add(8);
    list2.add(10);
    list2.add(3);
    
    System.out.format("ArrayList of numbers: %s%n", list2);
    
    System.out.format("Remove item at position 3 from list: ");
    list2.remove(3);
    System.out.format("ArrayList of numbers: %s%n", list2);
    
    System.out.format("Remove the first occurrence of the number 3 from list: ");
    list2.remove(new Integer(3));
    System.out.format("ArrayList of numbers: %s%n", list2);
    
    System.out.format("Remove the last occurrence of the number 3 from list: ");
    list2.remove( list2.lastIndexOf(new Integer(3)) );
    System.out.format("ArrayList of numbers: %s%n", list2);
  } // testArrayListMethods()
  
  
  /**An activity from class.
    * 
    * We collect words from the user using Scanner and
    * add them to the arrayList.
    * 
    * We perform ordered insertion into the list
    * We also have a method to remove duplicate strings
    *   from the arrayList.
    */
  private static void activity() {
    
    System.out.format(" %n%nAdd words to an ArrayList using a loop: %n%n");
    
    Scanner kbd = new Scanner(System.in);
    String prompt = "Enter a word, q to Quit";
    String input;
    ArrayList<String> list = new ArrayList<String>();
    
    do {
      System.out.format("%n%s%n",prompt);
      input = kbd.nextLine();
      
      if (!input.equalsIgnoreCase("Q")) {
        sort(list, input); // Ordered insertion
      }
      System.out.format("Arraylist: %s%n", list);
    } while (!input.equalsIgnoreCase("Q"));
    
    System.out.format(" %n%n Let's remove duplicate in our list...: %n%n");
    removeDups(list);
    System.out.format("Arraylist w/o dups: %s%n", list);
    
    kbd.close(); // Close resource to avoid leak.
    System.out.println("End of processing");
  } // activity()
  
  /**A method that inserts word in the arrayList words
    * in alphabetical order.
    */
  private static void sort(ArrayList<String> words, String word) {
    String theWord;
    boolean inserted = false;
    
    for (int i = 0; !inserted && i< words.size(); i++) {
      theWord = words.get(i);
      // If a "bigger" word is found, insert the new word here.
      if (theWord.compareTo(word) >= 0) {
        words.add(i, word);
        inserted = true; // We want to stop searching to avoid having an infinite loop
      } // if
    } // for
    // Add the word at the end of the list if no other spot was found
    if (!inserted)
      words.add(word);
  } // sort()
  
  /**Private utility method that goes through the arrayList
    * and removes the duplicate strings.
    */
  private static void removeDups(ArrayList<String> words) {
    String word;
    int index;
    
    for (int i = 0; i< words.size(); i++) {
      word = words.get(i);
      index = words.lastIndexOf(word); // Start searching from the end of the list
      // Remove any duplicates of word that are beyond position i
      while(index > i) {
        words.remove(index);
        index = words.lastIndexOf(word);
      } // while
    } // for
  } // removeDups()
} // class ArrayLists