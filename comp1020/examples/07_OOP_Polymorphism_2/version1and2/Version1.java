/* Test the MeanMugging and SmileyFace subclasses. 
 * Note that the ComplexShape type is never directly used. 
 */
public class Version1 {
  public static void main(String [] parms) {    
    MeanMugging guy = new MeanMugging();
    SmileyFace sf = new SmileyFace();
    
    // Pick which one you want to see
    if (false)
      guy.draw();
    else
      sf.draw();
  }  
}