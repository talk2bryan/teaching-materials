import java.io.*;

public class FileReading1 {
  public static void main(String [] parms) {
    try {
      FileReader f = new FileReader("someFile2.txt");
      System.out.println("That worked");
    } catch(IOException ioe) {
      System.out.println("IOException: " + ioe.getMessage());
    }
    
    System.out.println("Program ended gracefully.");
  }
}