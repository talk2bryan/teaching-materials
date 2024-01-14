/**Demonstrating how to create and use an 
  * abstract class.
  * 
  * Good Programming standard requires you to
  * place each class file in a different .java file.
  * Having all in one is simply for convenience
  * of the in-class demo.
  */
public class AbstractClassExample {
  public static void main(String [] parms) {
    Doggo goodboi = new Doggo("psam", "Malamute");
    System.out.println(goodboi);
    
    /** Cannot create instance of abstract class Pet **/
//    Pet p = new Pet();
    
  } // main
} // class AbstractClassExample


/*****************************************************************/
/*****************************************************************/
/**An abstract class that will allow generic Pet
  * objects to be stored in a Pet variable or array.
  * 
  * You cannot create an actual Pet object.
  * 
  * If this were in a separate .java file, you would need
  * to have:
  *     public abstract class Pet { ... }
  */
/*****************************************************************/
/*****************************************************************/
abstract class Pet {
  /**Just like regular superclasses, abstract classes can 
    * have instance variables that can be accessed by the
    * subclasses that inherit them. Here, since every pet
    * has a name, why not have the variable at the Pet
    * level.
    * 
    * Also, they can have static variables as well to count
    * how many instances of Pet objects exist (as in this
    * example).
    */
  protected String name;
  protected static int count = 0;
  
  /** They also have constructors - that is how they get 
    * instantiated. 
    * Even though we cannot instantiate abstract class objects,
    * they still get created when the constructors of their 
    * subclasses are called. You cannot have a subclass without
    * its superclass.
    * 
    * When no constructor is defined, the default Pet() 
    * constructor is called. 
    * Now that we defined a Pet(String name) constructor, EVERY
    * subclass of Pet must call this constructor as the first
    * statement in their constructors.
    */
  public Pet(String name) { this.name = name; count++; }
  
  /**Abstract method.
    * This forces any instance of Pet to define 
    * their own makeNoise() method.
    * So, it cannot have a method body.
    */
  public abstract String makeNoise();
  /**Not an abstract method.
    * Even though it is a method in an abstract class,
    * we can still have default methods as we have seen
    * in the Person superclass. These methods are called if
    * the subclasses do not have these methods implemented.
    * Go ahead and create a new type of Pet without a toString
    * method as a test.
    */
  public String toString() { return "Default toString() of a Pet"; }
} // class Pet

/** A new type of Pet **/
class Doggo extends Pet {
  private String breed;
  
  public Doggo(String name, String breed) {
    super(name);
    this.breed = breed;
  }
  // This must be implemented as it is an 
  // abstract method.
  public String makeNoise() {
    return "bork!";
  }
  // Optional method definition. We're overriding the
  // toString() of the superclass.
  // If we did not have one, it'll still be alright :)
  public String toString() {
    return String.format("I am %s, my breed is %s and I %s", name, breed, makeNoise());
  }
}