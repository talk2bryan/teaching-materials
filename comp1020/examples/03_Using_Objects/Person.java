public class Person {
  // Instance variables of this Class
  private String name;
  private int age;
  private Person spouse;
  
  private PersonList children;
  
  
  // class variable
  private static int population = 0;
  
  /** Omitted the other constructors to make room **/
  
  // Constructor that sets both instance variables
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    
    children = new PersonList();
    population++;
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
    String result = name + "(" + getAge() +")";
    // If we have a spouse, get their name.
    if (spouse != null)
      result += " is with " + spouse.name + ".";
    
    // If we have kids, get their names.
    if ( !children.isEmpty() ) {
      String newString = " " + name + "'s kids' names are: ";
      
      // toString() calling toString() of a different class.
      result += newString + children.toString();
    }
    return result;
  }
  
  public boolean isMarried() { return spouse == null; }
  
  public Person clone() {
    return new Person(name, age);
  }
  
  public boolean addChild(Person child) {
    // We need to kknow if we successfully added
    // child to both of their PersonList objects.
    boolean addToMyList = false;
    boolean addToSpouseList = false;
    
    // true if we added child to my list 
    //         and my spouse's list (if I have a spouse)
    boolean success = false;
    
    addToMyList = children.addPerson(child);
    if (spouse != null) {
      addToSpouseList = spouse.children.addPerson(child);
      
      success = addToMyList && addToSpouseList;
    }    
    else success = addToMyList;
    
    return success;
  }
  
  /*
   * Removes a child with the given name from me
   * and my spouse's children list!
   * 
   * The logic to remove child from both lists
   * is the same as addChild(). Here we just use 
   * less variables and if-statements.
   */
  public boolean removeChild(String name) {
    boolean result = false;
    if (spouse == null)
      result = children.delete(name);
    else
      result = children.delete(name) && spouse.children.delete(name);
    return result;
  }
}