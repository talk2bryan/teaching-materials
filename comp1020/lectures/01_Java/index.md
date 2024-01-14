% COMP 1020: Introductory Computer Science 2
% Java Programming
% Bryan Wodi

#
## Volunteer Note takers needed by SAS
![](images/notetakers.png)

#
## Need special permission to get into COMP 1020?
- Speak to Dr. Young
- Contact information: [http://cs.umanitoba.ca/~young/](http://cs.umanitoba.ca/~young/)

#
## Contacting me via e-mail:
- Set subject to "[comp1020] Reason for the email"
  - Example: "[comp1020] Question about A1"
- Salutation: "Hi Bryan, ..."
- Please try to avoid calling me "Sir", "Professor Wodi", e.t.c
- "Mr. Wodi" makes me feel old :cry::cry:

# Introducing (and Reviewing) Java
##

#
## Processing in 1010
- Mostly the same as Java
- Java however is strongly typed
  - Once a type has been assigned to a variable, it stays that way
  - Every variable must be declared with a data type 
    - (e.g) `int radius = 5;`
- Functions in processing are Java functions

#
## Python in 1012
- Similarities:
  - Flow of the program is the same
  - Conditionals are <ins>mostly</ins> the same

#
## Python &rightarrow; Java
Differences:

- Java uses brackets ```{ }```
  - Python uses whitespaces
- Semicolons at the end of statements in Java
  - ```int radius = 5```<span style="color:red">;</span>

#
## Python &rightarrow; Java
Differences:

- Python is weakly typed
  - Line 1: ```radius = 5```
  - Line 2: ```radius = "Samantha"```
  - Java will not allow this
- Function syntax changes

#
## Java
Java is a compiled language

- Human-readable source code &rightarrow; object code
- We (programmers) write <span style="color:red">source code</span>
  - Stored in files named <span style="color:red">FileName.java</span>
- The source code goes through a <span style="color:green">compiler</span>
- The compiler produces an <span style="color:blue">object code</span>
  - Stored in files named <span style="color:blue">FileName.class</span>
  - This is called "Java Byte Code" (JBC)
- An interpreter now executes the JBC.
  - Interpreters for executing JBCs are called "Java Virtual Machines" (JVM)

#
## For languages that compile...

- source code &rightarrow; (compiles to) &rightarrow; object code &rightarrow;  (run by) &rightarrow; an interpreter

- .java &rightarrow; (compiles to) &rightarrow; .class &rightarrow;  (run by) &rightarrow; JVM



#
## Java's interpreter - JVM
- Enables the computer run Java programs
 - ...as well as programs that can be compiled into JBC
- It is everywhere
  - Android apps 
  - DVD players
  - JVM on Windows, Macs, even your phones
- Notably
  - Not on iOs :smirk::smirk:
    - Those use Objective-C :unamused:

#
##
![](images/brace.png)

#
## Java's interpreter - JVM
- Reads in Java Byte Code
- Runs on the computer's hardware and software

#
## JRE and JDK
- Java Runtime Environment (JRE): A platform for executing java programs
  - JRE = JVM + Other Java libraries for executing programs successfully
- Java Development Kit (JDK): Provides all the tools, executables and binaries required to compile, debug and execute a Java Program.

#
## JVM, JRE, and JDK
![Source: CodeMonk](images/jdk-jvm.png)

- Java as a language is platform independent, but JVM, JRE and JDK are _platform dependent_
- Take this with a grain of salt...

#
## That's it!

:grinning::grinning::grinning:

#
## Software
> - First download a JDK from [https://www.oracle.com/technetwork/java/javase/downloads](https://www.oracle.com/technetwork/java/javase/downloads)
> - Then one of:
>   - DrJava (Windows, Linux, _old_ Macs)
>     - Go to [https://sourceforge.net/projects/drjava/](https://sourceforge.net/projects/drjava/)
>   - Geany (All PC's including Macs)
>     - From [https://www.geany.org/download/releases/](https://www.geany.org/download/releases/)
>   - IntelliJ/Eclipse? Google it :stuck_out_tongue::stuck_out_tongue:

#
## Let's write some code
![](images/doggo-code.png)

#
## For each java program you will write, we need to put in
```java
public class ProgramName
```
in a file named ```ProgramName.java```. 

**Both names must match**.

#
## And then 
```java
public class ProgramName {
  public static void main (String [] parms) {
  
  }
}
```
- Use this as a template for all the programs you write
- Over time we will learn what all of it means

#
## Hello World
```java
public class HelloWorld {
  public static void main (String [] parms) {
    System.out.println("Hello, World!");
  }
}
```
#
## Java Syntax
```java
public class <identifier> {
  public static void main (String [] parms) {
    <statememt>
  }
}
```
- This must be saved in a file named `<identifier>.java`
- The <span style="color:blue">`main`</span> method is the entry point of our program
  - Similar to `setup()` in Processing 

#
## Java Syntax
Java is case-sensitive

`public` != `Public` != `PUBLIC`

- "`!=`" means not equal to

#
## Some Java Conventions
- CapitalCamelCase is used for class names. (e.g.) `HelloWorld`
- lowerCamelCase is used for
  - method names (e.g.) `getReportByName(String name)`, `print(String word)`, `print()`.
  - variable names (e.g.) `employeeNames`, `employees`.
- UPPER_CASE_WITH_UNDERSCORES for constants (e.g.) `MAX_LIST_SIZE`
- More to come...

#
## Java Syntax
Comments:

Programmers use comments to help readers understand what their program does.

<aside class="notes">
<ins>Usually</ins> ignored by the compiler
</aside>


:::::: {.columns}
::: {.column width="45%"}
Two styles in Java:

```java
// A single line comment

/*
A comment 
that spans
multiple lines.
*/
```
 
:::
::: {.column width="10%"}


:::
::: {.column width="45%"}
Two styles in Python:
```python
# A single line comment 

"""
A comment 
that spans
multiple lines.
"""
```
:::
::::::

#
## Java Syntax
Limiting Scope:

Java uses brackets to limit scope

- functions
- if statements (with one exemption)
- loops
- _Python uses whitespace_

#
## Java Syntax - Limiting Scope
:::::: {.columns}
::: {.column width="45%"}
While loop in Java:

```java

while (true) {
  <statement>
}
```
 
:::
::: {.column width="10%"}


:::
::: {.column width="45%"}
While loop in Python:

```python

while true: 
  <statement>

```
:::
::::::

#
## Java Syntax
Statements:

Statements end with a semicolon

:::::: {.columns}
::: {.column width="62%"}
Java:

```java
  System.out.println("Hello World");
```
 
:::
::: {.column width="1%"}


:::
::: {.column width="37%"}
Python:

```python
  print("Hello World")
```
:::
::::::
- We use `System.out` for printing output

#
## Data Types
- Java is a <span style="color:red">strongly typed</span> and <span style="color:green">declarative</span> language
  - Every variable has to be given a type. 
    - Once assigned, it cannot change
    - _Not the case in Python_
    - Hence, it is a <span style="color:purple">dynamically typed</span> language  
  - We must declare each variable before it can be used.
    - _With Python, you create as you go_

#
## Data Types
Data types specify the different <span style="color:red">sizes</span> and <span style="color:red">values</span> that can be stored in a variable

- Two data types:
  - Primitive data types (8): `boolean, char, byte, short, int, long, float, double`
  - Non-primitive data types: `String, Array, Class, Interface`
  - 

      ![Source: javaTpoint](images/java-data-types.png "Source: javaTpoint")

   
#
## Data Types
Primitive integers (whole numbers)

- `byte`: 8 bit signed integer can store values in the range (±127) 
  - ((2^8) / 2) - 1 = 127. 
- `short`: 16 bit signed integer (±32767)
- `int`: 32 bit signed integer (±2147483647)
   - we use this most times 
- `long`: 64 bit signed integer (±9223372036854775807)
  - use this for really big integers (like credit card numbers).

#
## Data Types
Primitive floating-point (decimal) numbers

* `float`: 32 bit, ~7 significant digits
* `double`: double a float! 64bit, ~15 significant digits

#
## Literals
Hard-coded representations of Java data types

- `4` is an `int`
- `4.2` is a `double`
- `4L` is a `long`
- `4.2F` is a `float`
- `true` is a `boolean` literal (more on boolean later)
- `"Ling-Ling"` is a `String` literal (more on Strings later)


#
## You may enter literals in Java like this
```java
int amount = 50;
double girth = 0.26;
long diameter = 0.3L;
float taxRate = 1.12F;
boolean todayIsWednesday = true;
String studentName = "Preetesh Hughes";
```
- All primitive types start with lowercase letters. All other types will start with uppercase letters (like String).

#
## Operators
- We have learned how to declare and initialize variables
- How can we _do something_ with them?
- BEDMAS
- `+  -  *  && %`
  - See full list of Java operators: [https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
- When we perform operations between types, the result will <ins>**always**</ins> be the "bigger" type
- Decimals have higher precedence than integers
  - double > float > long > int > short > byte
  
#
## Shorthand with Operators
Add one to current variable
```java
x++; // post-increment
++x; // pre-increment
x--; // post-decrement 
--x; // pre-decrement
```

Add more than one to current variable
```java
x += 3; // x = x + 3
x -= 2; // x = x - 2
```

#
## Boolean
A boolean variable is one of two choices

- `true` or `false`
- _Python uses `True` or `False`_


#
## Boolean
Used in determining truth by using the followuing operators

- and: `&&`
- or: `||`
- not: `!`
- equal to: `==`
- not equal to: `!=`
- greater than: `>`
- less than: `<`
- greater than or equal to: `>=`
- less than or equal to: `<=`

#
## if statements
If statements gives us choices.
```java
if (<expression>)
    <statement>
```

```java
if (<expression>) {
    <one or more statements>
}
```
- The `<expression>` must evaluate to a `boolean` (`true` or `false`)

#
## else
Used to match an if. We can chain them even:
```java
final int MAX_TEMP = 20;
final int MIN_TEMP = 10;

int temp = -1; 

if (temp > MAX_TEMP) {
    System.out.println("Wear shorts");
} else if (temp > MIN_TEMP) {
    System.out.println("Wear pants");
} else {
    System.out.println("Wear a jacket.");
}
```
#
## and, or
`&&`, `||`

```java
boolean beachDay = true;
boolean goingToWork = true;

if (temp > MAX_TEMP || beachDay) {
    System.out.println("Wear shorts");
} else if (temp > MIN_TEMP && goingToWork) {
    System.out.println("Wear pants");
}

```

#
##
![](images/next_slide.png)

#
## char `' '`
a single character

- 16-bit Unicode character
- `" " != ' '`  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; `'c' != "c"`
  - `" "` is a String
  - `' '` is a char
- Remember: `char` is a numeric type
  - See [http://www.asciitable.com/](http://www.asciitable.com/)
  - It behaves like an <span style="color:red">int</span>!


#
## Strings!!!
![](images/puppetmaster.png#small-img)

Strings are Objects, so, <span style="color:red">not primitives</span>. Used for "strings" of zero or more characters 

Literal representation: "< character >"

"Hi", "This is a long String constant", "k", "204", ""


#
## String Object
Objects have 2 components: data and the methods to work with the data

The data for Strings is the content

Some useful methods are:

```java
String name = "Jane Omar";

name.length(); // Number of characters in the String, 9 
name.charAt(1); // The char at position 1, 'a'
```

#
## String concatenation
We can use the "+" operator to append to the end of a string. 

```java
int amount = 10;

System.out.println("The amount is: " + amount);
System.out.println("45.0" + amount);
```

Special rule: You cannot break a String constant over multiple lines.

```java
System.out.println("The quick brown fox" +
" jumps over" +
" the lazy dog."
);
```

#
## String equality
We can compare equality using `==` or String's `.equals()` method.

```java
String str1 = "Hello";
String str2 = "Hello";

System.out.println(str1 == str2);
System.out.println(str1.equals(str2));
System.out.println(str1.equalsIgnoreCase(str2));

```

Prefer <span style="color:green">".equals()"</span> to <span style="color:red">"=="</span> as the former compares the <span style="color:green">values</span> of the Strings while the latter compares the <span style="color:red">reference</span>

#
## Take-home exercise: "Escape" sequences
Look up the "backslash" (\\) character in Java. It is special.

Using `System.out.println()`, print the following `chars`:

- "
- \\
- A new line (not this literal sentence)
- A new tab 

#
## Type conversions
Input from the user or a file is gotten as a String

- What happens when we ask the user for a number and we receive "10"?

#
## Converting from a String to primitives
We use wrapper classes:

```java
int intNum = Integer.parseInt("10");
long longNum = Long.parseLong("0000000000000000");
float floatNum = Float.parseFloat("25.77");
double doubleNum = Double.parseDouble("0.00054");
boolean bool = Boolean.parseBoolean("TRUE"); // or tRuE
```
- What if we passed in a _bad_ String?

#
## Converting from primitives to Strings 
Basically the opposite:

```java
String str = Integer.toString(intNum);
str = Long.toString(longNum);
str = Float.toString(floatNum);
str = Double.toString(doubleNum);
str = Boolean.toString(bool);
```
- What if we passed in a _bad_ data type?

#
## Conversion by Casting
Forces conversion between types

From smaller to bigger:
```java
int numInt = 60;
double numDouble = (double)numInt;
```

#
## From bigger to smaller 
```java
double numDouble = 12.9999;
int numInt = (int)numDouble;
```

- This results in an <span style="color:red">int</span> value `12`
- The double gets "truncated", throwing away everything after the decimal point


#
## You cannot cast Strings to/from numbers
One quick way of converting from primitive to String is by using the `+` operator.

```java
String str = ""+ numInt;
str = ""+ numDouble;
str = ""+ bool;
```

Rule of thumb:

- If one of the operands is a String, the result is a String
- If both are primitives, the result type is the "bigger" data type.
  - This is true for other operations involving just primitives
  
  
#
## Input using Scanner
![](images/scanner.png)

#
## Input using Scanner
Java utility class for getting user input 

```java
import java.util.Scanner;
```

This goes at the top of the file 

- Documentation: [https://docs.oracle.com/javase/9/docs/api/index.html?java/util/Scanner.html](https://docs.oracle.com/javase/9/docs/api/index.html?java/util/Scanner.html)

#
## Scanner, reading input
```java
Scanner keyboard = new Scanner(System.in);
String input = keyboard.nextLine(); 
```
The <span style="color:red">keyboard</span> can be given any name.

Others:

> * int: `keyboard.nextInt();`
> * float: `keyboard.nextFloat();`
> * double: `keyboard.nextDouble();`
> * long: `keyboard.nextLong();`
> * Also String: `keyboard.next();`

See documentation.

#
## Scanner, reading a file.
Now that, we're here... Might as well!

```java
import java.io.*;
Scanner kbd = new Scanner(new File("fileName.txt"));
```

More on this later!
![](images/ignoreme.png#small-img)

#
## Let's Write Some Code
Problem: 

You are a waiter at Fortune Cookie restaurant. Ali, a customer had a meal worth $24.11. Tell Ali the total cost of their meal, and ask if they will like to tip.

If Ali says ("yes", "YES", "yEs", "YEs"), prompt them to enter a tip percentage, and add that to their final bill. Then say thank you!

If not, tell Ali their bill. Then say thank you.

#
## Methods
![](images/methods.jpg#small-img)


#
## Methods
> * Called functions in Processing
> * Always return one predefined data type (_Python beware_)

Syntax:

```java
static <returnType> <name> (<paramType> <paramName> ...) {
    <statement(s)>
    <optional return statement>
}
```
#
## Methods
Examples:

```java
static double calculatePST(double total) {
    return total * 1.07;
}

static void printMyName() {
    System.out.print("Larry Bushwick");
}
```

#
## Method Parameters/arguments
Can be passed-by-reference or passed-by-copy

> * Objects are passed-by-reference
> * Primitives are passed-by-copy

#
## The return statement
The return statement exits the method and returns a value (except if return type is void).

All non-void methods must have a return statement.

When a return statement is reached, the program returns to the location where the method was invoked.

Syntax:

```java
return <expression>;
```

#
## Global Variables
A variable declared outside any method and can be accessed from all parts of the program.

Add the "`static`" keyword when defining them. We will talk about this later.

#
## Constants
a variable whose value CANNOT change once it has been assigned.

Use "`final`" keyword!

#
## Loops
![](images/loops.jpg)

#
## For Loops
For loops have three expressions

> * initialization - do once before the loop
> * continuation – the loop continues while it’s true
> * step – done after every iteration of the loop

:::::: {.columns}
::: {.column width="55%"}
Java:

```java
for (int i = 0; i  < 10; i++) {
    // Do something
}
```
:::
::: {.column width="5%"}
:::
::: {.column width="40%"}
Python:

```python
for i in range(0,10):
    # Do something

```
:::
::::::


#
## Take home Exercise
Write a method that converts each character in a String from one case to the opposite case <span style="color:red">using a for-loop</spa>

It accepts a String and a boolean as arguments (for simplicity). 

The String is the variable we want to convert to the opposite case.

The boolean indicates whether the String variable is in UPPERCASE.

This method returns the same String but in the opposite case. 

> * Examples:
>   * convertCase("chandler", false) &rightarrow; "CHANDLER"
>   * convertCase("CAT", true) &rightarrow; "cat"

#
## While Loops
Repeat while a condition is not met

```java
int i = 0;
while (i < 10) {
    i++;
}
```

* Look up `do-while` loops!

#
## For-each
Same as for-loops, with less words. Used for Arrays or a Collections class (e.g. ArrayList)

```java
int [] intArray = {1, 3, 2, -3, 0, 9};

for (int item : intArray)
    System.out.print(item + " ");
System.out.print("\n"); // Same as System.out.println();
```

Which brings us to...

#
## Arrays
* are objects, just like Strings
* have methods (again, just like Strings)
* have a FIXED LENGTH, let's call it <span style="color:red">n</span>
* homogenous - all <span style="color:red">n</span> values are the same type

#
## Array Decalations
```java
int [] arr = {1, 2, 3, 4};
int [] arr2 = new int [20]; // This makes an empty array
```
* you can initialize an array to fill it with zeroes, false, or null depending on the data type you assign it.
* arrays can hold <ins>**any**</ins> data type, objects included.


#
## Copying Arrays
* arrays can be copied via "deep copy" or "shallow copy"
  * this is a property of all objects in Java
* shallow copy: by reference. `arr1 = arr0;`
* deep copy: by copying over all the data, one by one
  * using a for loop
  * using `Arrays.copyOf(srcArr, srcArr.length)`
  * using `System.arraycopy(srcArr, srcIndex, destArr, destIndex, numItems)`

#
## Partially-Filled Arrays

```java
int size = 0;
int array [] = new int [100];

array[size++] = 32;
```

* we do not have to fill up an array at once
* we can keep a variable to tell us how many items are in the array
* Exercise: fill the next 10 spaces in `array` with random numbers [1, 4]

#
## Default variables

| **Data Type**              | **Default Value**                              |
|------------------------|--------------------------------------------|
| byte                   | 0                                          |
| short                  | 0                                          |
| int                    | 0                                          |
| long                   | 0L                                         |
| float                  | 0.0f                                       |
| double                 | 0.0d                                        |
| char                   | \'\\u0000\' (null character - prints a blank) |
| boolean                | false                                      |
| String (or any object) | null                                       |
|                        |                                            |

#
## References

[Java 8 API](https://docs.oracle.com/javase/8/docs/api/)

Slides also contain materials from Dr. Bate, R. Guderian (2019)

Memes created using [imgflip](https://imgflip.com/memegenerator)
