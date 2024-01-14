/** 
 * One particular node in a linked list of nodes. 
 */
public class Node {
  private Object data; // The data in this node
  private Node next; // The link to the next node

  
  public Node(Object data, Node nextNode) {
    this.data = data;
    this.next = nextNode;
  }
  
  /** accessors and mutators **/
  // Getters
  public Object getData() { return data; }
  public Node getNextNode() { return next; }
  
  // Setters
  public void setData(Object data) { this.data = data; }
  public void setNextNode(Node nextNode) { this.next = nextNode; }
  
}