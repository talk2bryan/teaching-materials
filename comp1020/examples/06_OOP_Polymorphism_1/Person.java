public class Person {
  private String name;
  protected int age;
  
  public Person (String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  public void haveBirthday() { age++; }
  
  public int getAge() { return age; }
  public String toString() {
    return String.format("%s(%d)", name, age);
  }
} // Person