public class IClickersWeek8 {
  public static void main(String [] parms) {
      
     Thing t = new ThingA();
    if (t instanceof Thing) System.out.print("Thing ");
    if (t instanceof ThingA) System.out.print("ThingA  ");
    if (t instanceof ThingB) System.out.print("ThingB  ");
    
    System.out.println();
    Thing.methodX(); // Change methodX to non-static to test t.methodX() in both classes
  }
}

 class Thing { 
   public static void methodX() { System.out.println("methodX from Thing"); }
 }
 class ThingA extends Thing {
   public static void methodX() { System.out.println("methodX from ThingA"); }
 }
 class ThingB extends ThingA { }
