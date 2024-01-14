% Introductory Computer Science 2
% Basic Objects
% Bryan Wodi

# We have...
> - Reviewed programming in Java

# Now
> - Introduction to Objects
> - Creating new data types

# What is an Object?
* A noun
* Holds information, and has methods to work with that information

# Classes
* a <span style="color:blue">class</span> defines  a new data type
* they are prototypes from which objects are created
* it represents the set of properties/methods that are common to all objects of that (data) type.
* all values of this type are called Objects
  * an Object is an <span style="color:red">instance</span> of a <span style="color:blue">class</span>

#
## Classes cont'd
- A class has
  - <ins>a name</ins>: `class AnObject`
  - <ins>data</ins> it stores in each object, called <span style="color:blue">instance variables</span>
  - <ins>actions</ins> it can perform on the object, called <span style="color:blue">instance methods</span> 

#
## Class Definition

```java
public class Person {
    public String name;
    public int age;
}
```
* We have not created any values (or objects) yet
  * all we did was create a new data type
* Notice the lack of "static" in the variable declarations.

#
## Creating objects
* A class  creates a template for what an object will look like
* Creating a variable of type `Person` in the previous slide does not create an object either
  * objects are accessed only via references to the object
  * same as Strings, or arrays
  * the reference <span style="color:red">null</span> mean that there is no object being referred to
    * `Person a; // a is null`

#
## Creating objects
```java
Person mike = new Person();
```

#
## Accessing the data

We can access the instance variables of an object only if they're <span style="color:red">public</span>

```java
System.out.println("Person's name is " + mike.name + 
                    ", they're " + mike.age + 
                    " years old");

mike.name = "Mike";
mike.age = 18;

```

# Multiple objects
Each object is assigned their own data.

#
## Where can we use objects

Anywhere you can use other variables

> * as a parameter
> * have an array of them
> * as a variable within a different object

#
## Instance methods

Same as methods we have discussed, but we omit the "static" keyword

```java
class Person {
    [ ... ]
    // Instance methods
    public String getName() { return name; }
    public void haveBirthday() { age++ }
}
```

# Note
- Return type is similar to other methods
- Instance methods refer directly to instance variables
  - they are used as operations on object instances
  
#
## "this" keyword
> * A reference to the current object whose method is being called
> * We use "this" to avoid naming conflicts in the method

```java
public void setAgeTo(int age) {
    this.age = age;
}
```

#
## Constructors
We need to set the data when we create the object

It's primary purpose is to initialize the object

Syntax:

```java
public class Person {
    public Person() {
        // Initial values go here
    }
}
```

* It has no return type, not even void
* It has exactly the same name as the class

#
## Constructors 2
They are functions, so they can have arguments

```java
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }
}
```

* They are executed when an object instance is created with<br> `new Person(...)`

#
## Constructors 3
We can have more than one constructor in a class

```java
public class Person {
    private String name;
    private int age;
    
    public Person() { name = "noName"; age = 0; }
    public Person(String name) {
        this.name = name;
        age = 0;
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

#
## Visibility for methods and variables

`public`/`protected`/(default) a.k.a `package`/`private`

|   |  Class | Package | Subclass | World |
|---|---|---|---|---|
| `public`  | Y  | Y  | Y  | Y  |
| `protected` |  Y | Y  | Y  | N |
| (default)  |  Y | Y  | N | N |
| `private` | Y | N | N | N |

- Use private instance variables unless you have a good reason
- Most instance methods will be public

#
## Encapsulation
Keep all code that affect the inner workings of objects private

Provide users with <span style="color:red">accessor</span> and <span style="color:red">mutator</span> methods instead.

Instance methods act as these!

This is easier to maintain.


#
## Encapsulation

```java
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // Setter or mutator
    public void setAge(int age) {
        this.age = age;
    }
    // Getter or accessor
    public int getAge() { return age; }
}

```

#
## Class Variables and methods
* These are variables and methods that do not refer to any one specific instance, 
  but belong to the class as a whole
  
* To create these, we use the modifier "<span style="color:red">static</span>"


#
## Class Variables and methods

```java
class Person {
    // Instance variables - one per object
    private String name;
    private int age;
    
    // Class variable - only one for the whole class
    private static int population = 0;
    
    // Class method - cannot apply to an object
    public static int census() { return population; }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        population++;
    }
}
```
#
## Calling methods
![Source: Instagram](images/calling-methods.png#small-img "Source: Instagram")

#
## Calling methods

* instance methods: `someObject.method( ... )`
* class (<span style="color:red">static</span>) methods: `ClassName.method( ... )`
* any method from within the class: `method( ... )`
  * whether or not it is static
  * same as `this.method()` for instance methods
  * same as `ThisClassName.method()` for static methods
* Examples:
  * `int count = Person.census()`
  * `p.setAge(30);`

#
## The toString() method
It is usually great practice to create a `toString()` method for any class you create.

This automatically allows the interpreter print the object. It is called when you
attempt to convert an object to a String, usually via pprint.

It returns a String that "textually represents" the object.

```java
public String toString() { return name + "(" + age + ")"; }
```

Now we can do:
```java
Person p = new Person("Henry", 67);
System.out.println(p);
```

Avoid print statements from within your class, return a String instead.


#
## Comparing objects
What happens when you do...

```java
Person person1 = new Person("Henry", 67);
Person person2 = new Person("Henry", 67);
System.out.println(person1 == person2);

```
Comparing Object variables using "==" or "!=" only compares their references

It does not look inside the objects.

#
## Comparing objects
We need an "`.equals()`" method. Remember String's `.equals()`?

```java
public class Person {
    [ ... ]
    public boolean equals(Person other) {
        boolean result = false;
        if (this.name.equals(other.name) &&
            this.age == other.age) {
            result = true;    
        }
        return result;
    }
}
```

> * Now try:
>   * `System.out.println(person1.equals(person2));`

#
## Comparing Objects - compareTo() method
* Another method for comparing the actual data inside objects 
  * Remember <span style="color:red">object1</span><span style="color:blue">.equals</span>(<span style="color:red">object2</span>) -- gives a boolean
* <span style="color:red">object1</span><span style="color:blue">.compareTo</span>(<span style="color:red">object2</span>) -- this gives an int
  * Gives a **negative** number if object1 is **"smaller"**
  * Gives a **positive** number if object1 is **"larger"**
  * Gives a **zero** if both are **"equal"**
* For Strings, this checks "alphabetical order"


#
## References

[Java Documentation - OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)

Slides also contain materials from Dr. Bate, R. Guderian (2019)

Memes created using [imgflip](https://imgflip.com/memegenerator)
