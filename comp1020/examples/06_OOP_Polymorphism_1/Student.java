/** 
 * A subclass of the Person class
 */

public class Student extends Person {
  // Extra instance variables
  private int studentNum;
  private double gpa;
  
  // Constructor
  public Student(String name, int age, int studentNum, double gpa) {
    // pass these to create the Person object by calling the 
    // constructor that receives a name and an age.
    super(name, age); 
    
    // init private instance variables of the 
    // Student object
    this.studentNum = studentNum;
    this.gpa = gpa;
  }
  
  // Extra methods
  public int getStudentNum() { return studentNum; }
  // Since age is a protected variable in the superclass,
  // we can access it directly instead of calling
  // super.haveBirthday()
  public void increaseAge() { super.age++; }
  /**NOTE: This is not a method override of the 
    * haveBirthday() in the super class
    * Reason: this has a different signature from
    * that of the superclass
    * 
    * This method does nothing. Make it do something like
    *  
    *     super.age = x;
    * for instance to see how your object behaves.
    */
  public void haveBirthday(int x) { ; }
  
  // Overriding the toString() method of Person class
  public String toString() {
    String s = super.toString();
    
    return String.format("Student: %s, Student #: %d, GPA: %4.2f", s, studentNum, gpa);
  }
  
}