/** 
 * A subclass of the Person class
 */

public class Faculty extends Person {
  
  // extra instance variables
  private int numBooks;
  private String department;
  
  public Faculty(String name, int age, int numBooks, String dept){
    super(name, age);
    
    this.numBooks = numBooks;
    department = dept;
  }
  
  public int getBoks() { return numBooks; }
  
  public String toString() {
    String s = super.toString();
    
    return String.format("Faculty Member: %s, NumBooks = %d, Dept: %s", 
                         s, numBooks, department);
  }
}