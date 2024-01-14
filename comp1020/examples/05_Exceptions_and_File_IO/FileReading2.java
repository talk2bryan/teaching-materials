import java.io.*;
import java.util.Arrays;

public class FileReading2 {
  public static void main(String [] parms) {
    
    BufferedReader br; 
    String line;
    int numNames = -1;
    
    try {
      // Initialize the BufferedReader, opening the file using FileReader
      br = new BufferedReader(new FileReader("student.txt"));
      System.out.println("File read successfully");
      
      // Get the first line in student.txt
      line = br.readLine();
      
      // If line is null, then we have reached the end of the file.
      if (line != null) {
        // Get rid of leading and trailing whitespace
        line = line.trim();
        /**
         * The first line should tell us how many lines
         * of names the student has. If line contains a 
         * non-numeric value, a NumberFormatException is thrown.
         */
        numNames = Integer.parseInt(line);
      }
      // If we successfully retrieved numNames, then the
      // next `numNames` lines should contain the student's
      // names
      for(int i = 0; i < numNames; i++) {
        line = br.readLine(); // get the line
        if (line != null) {
          line = line.trim();
          System.out.println("line : " + line + "."); // display the content.
        }
      }
      
      // date of birth
      // The next line after names contains the student's date
      // of birth in the format YYYY MM DD
      // extract each token and convert them to integers.
      
      // read the line
      line = br.readLine();
      String [] dates; // would hold the 3 parts of a valid date
      int year, month, day; // for storing the dates when we successfully convert them from Strings
      
      
      if (line != null) {
        // There is actual data on there, good
        line = line.trim();
        // Split the line into tokens separated by whitespace
        dates = line.split("\\s+"); 
        
        // We defined a valid date as one having 3 components, year, month and day.
        // So if we see anything less than 3 or more than 3, throw a NotABirthdayException.
        if (dates.length != 3) {
          throw new NotABirthdayException("this is not a date man");
        }
        
        // We will only continue from here if dates has 3 elements, so no need for else.
        
        System.out.println(Arrays.toString(dates));
        /**
         * Here we assume that if it has 3 elements, it is a date.
         * But this may not always be the case. Having the same length as that of the
         * data we are expecting is not enough validation.
         * For instance, line could contain "Not a date", and the length of dates would 
         * still be 3.
         */
        year = Integer.parseInt(dates[0]);
        month = Integer.parseInt(dates[1]);
        day = Integer.parseInt(dates[2]);
        
        // Sanity check that this actually worked haha
        System.out.format("year:%d, year+1: %d\n", year, ++year);
        System.out.format("month:%d, month+1: %d\n", month, ++month);
        System.out.format("day:%d, day+1: %d\n", day, ++day);
      }
    } catch(IOException ioe) {
      System.out.println("IOException" + ioe.getMessage());
    } catch (NumberFormatException nfe) {
      System.out.println("NumberFormatException" + nfe.getMessage());
    } catch (NotABirthdayException nab) {
      System.out.println("NotABirthdayException: " + nab.getMessage());
    }
    
    
    System.out.println("Program ended gracefully.");
  } // main
} // FileReading2 class

/*
 * Our new Exception type called NotABirthdayException
 * 
 */
class NotABirthdayException extends Exception {
  public NotABirthdayException(String message) {
    /**
     * Calling the parent's (i.e. Exception class) constructor.
     * We do this because we want to set the message when we create
     * this exception object in the future. By doing so, we can 
     * retrieve this message with .getMessage() when we catch
     * this exception.
     */
    super(message);
  }
}
