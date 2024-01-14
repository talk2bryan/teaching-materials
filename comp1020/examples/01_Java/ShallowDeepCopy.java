import java.util.Arrays;

public class ShallowDeepCopy {
    public static void main (String [] parms) {
      int [] a  = {1,2,3,4,5};
      // shallow copy
      int [] b = a;
      
      System.out.println("a: " + Arrays.toString(a));
      System.out.println("b: " + Arrays.toString(b));
      
      a[0] = -1;
      System.out.println("after a[0] = -1;");
      System.out.println("a: " + Arrays.toString(a));
      System.out.println("b: " + Arrays.toString(b));
      
      // Deep copy
      int [] c = new int [a.length];
      System.arraycopy(a, 0, c, 0, a.length);
      
      a[1] = -1;
      System.out.println("after a[1] = -1;");
      System.out.println("a: " + Arrays.toString(a));
      System.out.println("b: " + Arrays.toString(b));
      System.out.println("c: " + Arrays.toString(c));
      
    }
}