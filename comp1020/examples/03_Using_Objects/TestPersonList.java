public class TestPersonList {
  public static void main(String [] parms) {
    Person p0 = new Person ("Kobe", 41);
    Person p1 = new Person ("Vanessa", 30);
    
    p0.setSpouse(p1);
    Person p2 = new Person ("AA", 10);
    Person p3 = new Person ("BB", 8);
    Person p4 = new Person ("CC", 6);
    
    p0.addChild(p2);
    p0.addChild(p3);
    p0.addChild(p4);
    
    System.out.println(p0);
    System.out.println(p1);
//    
    System.out.println(p0.removeChild("CC"));
    System.out.println(p1.removeChild("AA"));
    
    System.out.println(p0);
    System.out.println(p1);    
  }
}