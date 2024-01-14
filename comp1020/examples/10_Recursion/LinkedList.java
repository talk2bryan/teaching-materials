/**LinkedList Implementation for in-class demo**/
public class LinkedList {
  
  private Node head = null; // No need for a constructor
  
  /* Add a new Node at the end of the list */
  public void add(int data) {
    // Create the Node.
    // Since it will be inserted at the end, its next node will be null
    Node newNode = new Node(data, null);
    
    if (head == null) // When the LinkedList is empty, head will be null
      head = newNode; // Make this new Node our head
    else { // The list has at least one Node 
      Node curr = head;
      
      // Find the last Node on the list
      while(curr.getNextNode() != null) { // While curr is not the last Node 
        curr = curr.getNextNode();
      }
      curr.setNextNode(newNode);
    } // else
  } // add()
  
  /** Search for n in the LinkedList
    * returns: -1 or index of the Node containing n
    */
  public int search(int n) {
//    return search2(n); // Search iteratively.
    return search(n, head, 0); // return -1
  }
  
  /**Search the LinkedList for n using Recursion.
    * Return:
    *   -1: if n is not on the list
    *   index if n is on the list
    * 
    * This looks at one Node at a time.
    * 
    * There are two base cases...
    * 1. When the node is null
    * 2. When the node isn't null and it contains the search item (n)
    */
  private int search(int n, Node node, int index) {
    if (node == null) // If the list is empty or we get to the end of list
      return -1;
    if (node.getData() == n) // We have found the Node containing n
      return index;
    return search(n, node.getNextNode(), index+1); // Recursive case
  }
  
  /** Iterative search of n in a LinkedList
    * Return:
    *   -1: if n is not on the list
    *   index if n is on the list
    */
  private int search2(int n) {
    Node curr = head;
    int index = 0;
    while(curr != null && curr.getData() != n){ 
      curr = curr.getNextNode();
      index++;
    }
    
    if (curr == null)
      index = -1;
    return index;
  }
  
  /** Challenge: Write this recursively **/
  public String toString() {
    String result = "[";
    
    Node curr = head;
    while (curr != null) {
      result += (curr.getNextNode() == null ? curr.getData() + "" : curr.getData() + ", ");
      curr = curr.getNextNode();
    }
    return result + "]";
  } // toString
} // LinkedList class

/** A simple Node class that holds int data **/
class Node {
  private int data; 
  private Node next;
  
  public Node(int data, Node nextNode) {
    this.data = data;
    this.next = nextNode;
  }
  
  // Getters
  public int getData() { return data; }
  public Node getNextNode() { return next; }
  
  // Setters
  public void setData(int data) { this.data = data; }
  public void setNextNode(Node nextNode) { this.next = nextNode; }
}