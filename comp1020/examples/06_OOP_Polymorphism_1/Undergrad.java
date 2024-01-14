/** 
 * A subclass of the Student class
 *     which is a subclass of Person.
 * An undergrad has everything in Person and Student,
 * and more!!!
 */
public class Undergrad extends Student {
  private String degree;
  private double creditHoursTaken;
  private double creditHoursNeededToGraduate;
  
  public Undergrad() {
    super(null, 0, 0, 0.0);
    
    degree = "Bachelors";
    creditHoursTaken = 0.0;
    creditHoursNeededToGraduate = 120.0;
  }
}