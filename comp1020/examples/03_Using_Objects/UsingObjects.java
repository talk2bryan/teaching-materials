public class UsingObjects {
  
  public static void main(String [] parms)  {
    
    /**
     * Creating two single Person objects
     * 
     * You could also use the newer constructor
     * passing null, it achieves the same result:
     * 
     * Person bryan = new Person("Bryan", 20, null);
     * 
     */
    Person bryan = new Person("Bryan", 20);
    Person valerie = new Person("Valerie", 19);
    
    System.out.println(bryan);
    System.out.println(valerie);
    
    // They met and fell in <3
    bryan.setSpouse(valerie);
    
    // See the updated toString() method
    System.out.println(bryan);
    System.out.println(valerie);
    
    Person roy = new Person("Roy", 0);
    bryan.addChild(roy);
    
    System.out.println(bryan);
    System.out.println(valerie);
    
  }
}