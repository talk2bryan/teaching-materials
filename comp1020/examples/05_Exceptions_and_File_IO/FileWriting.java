import java.io.*;

public class FileWriting {
  public static void main(String [] args) {
    try {
      FileWriter fw = new FileWriter("output.txt"); // new FileWriter("output.txt", true) - to append to end of file.
      PrintWriter pw = new PrintWriter(fw);
     
      int x = 10;
      String name = "Pooja";
      
      pw.println("This is line 1");
      
      pw.printf("I am %d years old.\n", x);
      pw.printf("My name is %s, thank you.\n", name);
      
      pw.println("Here is another string");
      
      pw.println("Let's see if this adds to this file.");
      pw.close();
    } catch(IOException ioe) {
      ;
    }
  }
}