// Rename PersonVersion0 to Person
public class PersonVersion0 {
  // Instance variables of this Class
  private String name;
  private int age;
  private Person spouse;
  
  // class variable
  private static int population = 0;
  
//   User-defined default constructor
//   This does not have to be defined,
//   if we were to delete this, the interpreter
//   will assign default values to the instance
//   variables.
//   name = null; age = 0;
  public Person() {
    name = "noName";
    age = 100;
    population++;
  }
  
  // A constructor that only sets the name variable.
  // age will be set to the default value of 0
  public Person(String anything) {
    name = anything;
    population++;
  }
  // Another constructor that sets both instance variables
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    population++;
  }
  // Another constructor that receives a Person object
  // other can be null - which means this Person is single :(
  public Person (String name, int age, Person other) {
    this.name = name;
    this.age = age;
    spouse = other;
    // Make sure the other person is married to you :D
    if (other != null)
      other.spouse = this;
  }
  
  // Instance methods begin here:
  
  // Mutator method as it modofies
  // the value of age.
  public void haveBirthday() { 
    this.age++; 
  }
  
  // Also a mutator method
  public void setAgeTo(int age) {
    this.age = age;
    // THIS.AGE REFERES TO LINE 4
  }
  // Same as above
  public void setName(String name) {
    this.name = name;
  }
  
  // Accessors
  public String getName() {
    return name;
  }
  // Also an accessor
  public int getAge() {
    return age;
  }
  
  // Class method
  public static int census() { return population; }
  
  public boolean equals(Person other) {
    boolean result = false;
    if (name.equals(other.name) &&
        age == other.age) {
      result = true; 
    }
    return result;
  }
  
  // Setter method that references this' spouse and vice versa
  public void setSpouse(Person other) {
    this.spouse = other;
    other.spouse = this; // do a null check before!
  }
  
  public String toString() {
    /* This enables us print the contents of the object
     * nicely when we do a 
     *     System.out.println(person);
     * Now instead of: 
     *     Person@7d5f97f
     * we get something like:
     *     "Mike(19)" 
     * when we try to print a Person object
     * with name "Mike" and age 19.
     * 
     * You can format the String however you see fit 
     * before you return it to the user.
     * 
     * */
    String result = name + "(" + getAge() +")";
    
    if (spouse != null)
      result += " is with " + spouse.name;
    return result;
  }  
}