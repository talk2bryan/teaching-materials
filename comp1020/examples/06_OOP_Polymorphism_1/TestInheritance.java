public class TestInheritance {
  public static void main(String [] parms) {
    
    Student s = new Student("Jon", 20, 67444443, 4.0);
    Faculty m = new Faculty("Dr. Young", 19, 50, "Computer Science");
    
    Person p0 = new Person ("Bryan", 20);
    
    System.out.println(s);
    
    s.increaseAge();
    System.out.println(s);
    // Calling the haveBirthday method of the Person
    // class as the Student class does not have a 
    // haveBirthday() without parameters.
    s.haveBirthday();
    System.out.println(s);
    
    // Calling the haveBirthday(int x) method of the
    // Student class.
    s.haveBirthday(7);
    System.out.println(s);
    
    System.out.println(m);
    System.out.println(p0);
    
    // Casting: Down-casting a Person to a Student class
    Person newPerson = new Student("Jon", 20, 67444443, 4.0);
    
    int stdNum = ((Student)newPerson).getStudentNum();
    
    Student temp = (Student)newPerson;
    
    // Bad. Would cause a classCastException
    // Student temp2 = (Student)p;
    
    stdNum = temp.getStudentNum();
    // Student newStd = new Person("name", 0); --- bad
    
    // using instanceof to test type before casting
    Person person = new Person("Sandy", 25);
    int studentNum;
    
    if (person instanceof Student)
      studentNum = ((Student)person).getStudentNum();
    else
      System.out.println("Yo this person is not a student!");
    
    
    Person [] people = new Person[5];
    
    people[0] = new Student("Daniel", 19, 7737129, 3.0);
    people[1] = new Student("Blessing", 18, 6756435, 2.0);
    
    people[2] = new Faculty("Robert", 30, 6, "CS");
    people[3] = new Faculty("Sarada", 26, 31, "Bio");
    
    people[4] = new Person("Michelle", 22);
    
    /**Activity - using instanceof
      * 
      * if Person is a student, print student #
      * if Person is Faculty, print numBooks
      * else, print their toString()
      */
    for (Person p : people) {
      if (p instanceof Student)
        System.out.format("Student #: %d%n", ((Student)p).getStudentNum());
      else if(p instanceof Faculty)
        System.out.format("Faculty has %d books%n", ((Faculty)p).getBoks());
      else
        System.out.println(p);
    }
    
    /**Dynamic polymorphism:
      * Due to method overriding, the JVM determines
      * the correct method to call for any given object 
      * at runtime.
      */
    System.out.format("%n%nDynamic Polymorphism deiciding correct toString() at runtime:%n");

    for (Person p : people)
      System.out.println(p);
    
    
    System.out.println("End of Program");
  }
}