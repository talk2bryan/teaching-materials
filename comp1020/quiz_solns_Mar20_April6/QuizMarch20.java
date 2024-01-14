public class QuizMarch20 {
  public static void main(String [] parms) {
    // Write your own damn tests..... :p
  }
}

class LinkedList {
  private Node start;
  
  public LinkedList() {
    start = null;
  }
  
  public void add(int datum) {
    // assume it's written, and works
    start = new Node(datum, start); // add at head
  }
  public void printOdd(){
    // If this is my linkedList, then...
//   0 -> 1 -> 2 -> 3 -> 4 -> null
//  odd  even  odd  E    O
//i= 1    2    3    4    5
    // Starting i from 1 to make i%2 make more sense...
    int i = 1;
    Node curr = start;
    
    while (curr != null) {
      if (i%2 != 0) { // If it's odd
        System.out.println(curr.getDatum());
      }
      i++;
      curr = curr.getNext();
    } // while.
  } // printOdd
  
  public void printEven(){
    // If this is my linkedList, then...
//   0 -> 1 -> 2 -> 3 -> 4 -> null
//  odd  even  odd  E    O
//i= 1    2    3    4    5
    // Starting i from 1 to make i%2 make more sense...
    int i = 1;
    Node curr = start;
    
    while (curr != null) {
      if (i%2 == 0) { // If it's even
        System.out.println(curr.getDatum());
      }
      i++;
      curr = curr.getNext();
    } // while.
  } // printEven
  
  /** Same as printOdd **/
  public void printEveryOther(){ 
    // If this is my linkedList, then...
//   0 -> 1 -> 2 -> 3 -> 4 -> null
//  odd  even  odd  E    O
//i= 1    2    3    4    5
    // Starting i from 1 to make i%2 make more sense...
    int i = 1;
    Node curr = start;
    
    while (curr != null) {
      if (i%2 != 0) { // If it's odd
        System.out.println(curr.getDatum());
      }
      i++;
      curr = curr.getNext();
    } // while.
  } // printEveryOther
  
  public int sumEven(){ 
    int sum = 0;
    Node curr = start;
    
    while (curr != null) {
      int item = curr.getDatum();
      if (item %2 == 0) { // If it's even
        sum += item;
      }
      curr = curr.getNext();
    } // while.
    return sum;
  } // sumEven
  
  public int sumOdd(){ 
    int sum = 0;
    Node curr = start;
    
    while (curr != null) {
      int item = curr.getDatum();
      if (item %2 != 0) { // If it's odd
        sum += item;
      }
      curr = curr.getNext();
    } // while.
    return sum;
  } // sumEven
}

class Node {
  private Node next;
  private int datum;
  
  public Node (int datum) {
    this.datum = datum;
  }
  
  public Node (int datum, Node next) {
    this.datum = datum;
    this.next = next;
  }
  
  public Node getNext() {
    return next;
  }
  public void setNext(Node next) {
    this.next = next;
  }
  public int getDatum() {
    return datum;
  }
  public void setDatum(int datum) {
    this.datum = datum;
  }
}