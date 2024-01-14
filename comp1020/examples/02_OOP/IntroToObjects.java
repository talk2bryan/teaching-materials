import java.util.Arrays;

public class IntroToObjects {
  public static void main(String [] parms) {
    // Creating objects using the default constructor
    Person mike = new Person();
    Person p = new Person();
    // Create objects using the other constructors
    Person person = new Person("Bryan");
    Person person2= new Person("Daniel Robin", 200);
    
    // Calling methods
    mike.setName("Mike");
    mike.setAgeTo(18);
    mike.haveBirthday();
    
    // Printing oout the content of the objects using 
    // accessor methods
    System.out.println("Person's name is " + mike.getName() + 
                       ", they're " + mike.getAge() + 
                       " years old");
    
    System.out.println("Person's name is " + p.getName() + 
                       ", they're " + p.getAge() + 
                       " years old");
    System.out.println("Person's name is " + person.getName() + 
                       ", they're " + person.getAge() + 
                       " years old");
    System.out.println("Person's name is " + person2.getName() + 
                       ", they're " + person2.getAge() + 
                       " years old");
    
    // Users can modify the content of the object any time they want
    // by calling the public methods we've made available to them.
    person2.setName("Danielle Robin");
    person2.setAgeTo(20);
    
    System.out.println("Person's name is now " + person2.getName() + 
                       ", they're now " + person2.getAge() + 
                       " years old");
    
    
    // Creating an array of 4 Person objects
    // persons after this line will be:
    // [null, null, null, null]
    Person [] persons = new Person[4]; 
    
    // Initialize each Person object in the array
    // After this, each object will contain actual data.
    // Here we define a name and age at creation.
    // Using arbitrary names ("person0", "person1", ...)
    // and ages (10, 11, 12, 13)
    for (int i = 0; i<persons.length;i++)
      persons[i] = new Person("person" + i, i+10);
    
    // Using a for-each loop, we print each object.
    // The print() invokes the ".toString()" method
    // of the Person class. See the method definition.
    for (Person personObj : persons)
      System.out.print(personObj + "\t");
    System.out.println();
    
  }
}