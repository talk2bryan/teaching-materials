import java.awt.Color;
/* An abstract class that will allow generic 
 * shapes to be stored in a Shape variable or array. 
 * You cannot create an actual Shape object. 
 */

public abstract class Shape {
  
  private Color colour; // A shape will have a colour
  // A constructor that sets the colour
  public Shape(Color c){
    colour = c;
  }
  // We set the colour before we draw in the subclass
  public void draw() {
    StdDraw.setPenColor(colour);
  }
}