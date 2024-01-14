/** 
 * A class to hold a list of Objects, by 
 * storing them as a linked list. 
 */
public class LinkedList {
  private Node head; // reference to first node
  
  public LinkedList() {
    head = null;
  }
  
  /** accessors and mutators **/
  
  /**add a Node to the front of the
    * LinkedList
    */
  public void add(Object data) {
    Node newNode = new Node(data, head); // Set this new node to point to the current head so we don't lose it
    head = newNode; // head will become this new node
  }
  
  /** 
   * Add a new Node to a particular position in the 
   * LinkedList
   * 
   * Edge cases: For our implementation, if:
   *   index <= 0, insert at the beginning of the list
   *   index > countOfNodes, insert at end of the list
   */
  public void add (int position, Object o) {
    Node prev = null;
    Node curr = head;
    
    // Walk to that position
    for (int i = 0; i < position && curr != null; i++) {
      prev = curr;
      curr = curr.getNextNode();
    }
    
    /* At this point, curr is either null or it is 
     * pointing to the Node at position index.
     * 
     * The new node belongs between prev and curr.
     * 
     * If curr == null, then we reached the end of the list,
     * so we will insert at the end of the list
     */
    Node newNode = new Node(o, curr); 
    if (prev == null)
      head = newNode;
    else
      prev.setNextNode(newNode);
  }
  
  /**
   * Given some data, delete the Node that contains
   * the data from the list, if it exists.
   */
  public void delete(Object o) {
    Node prev = null;
    Node curr = head;
    
    // Search the entire list for the Object
    while (curr != null && !curr.getData().equals(o)) {
      prev = curr;
      curr = curr.getNextNode();
    }
    
    // At this point, curr either points to the Node that
    // contains the data, or null. If curr is null, it means
    // the item was not found on the list
    if (curr != null && curr.getData().equals(o)) {
      // If prev is null, we did not get past the first node,
      // which means that the first node on the list is what we 
      // want to delete. So, make head point to the next thing
      if (prev == null)
        head = curr.getNextNode();
      else
        prev.setNextNode(curr.getNextNode());
    }
  }
  
  /**Ordered insertion for Strings only
    */
  public void orderedInsert(String theWord) {
    int index = 0;
    Node curr  = head;
    
    while(curr != null && theWord.compareTo((String)curr.getData()) >= 0) {
      curr = curr.getNextNode();
      index++;
    }
    // Call the add(int, Object) method to add this new node at this position
    add(index, theWord);
  }
  
  public String toString() {
    String result = "<< "; // Just because...
    
    Node curr = head;
    
    while (curr != null) {
      result += curr.getData() + " ";
      curr = curr.getNextNode();
    }
    return result + ">>";
  }
}