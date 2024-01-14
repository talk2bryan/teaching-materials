public class Chars {
  public static void main(String [] parms) {
    char lowerCase = 'h';
    
    char upperCase = (char)((lowerCase - 'a') + 'A');
    System.out.println((int)lowerCase);
    
    System.out.println(upperCase);
  }
}