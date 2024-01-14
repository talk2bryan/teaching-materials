import java.awt.Color;

/** 
 * This is a "Happy Face" ComplexShape. 
 */
public class SmileyFace extends ComplexShape {
  public SmileyFace() {
    Point centre = new Point(0.5, .5); // Centre of the face
    Point leftE = new Point(0.3, 0.7); // Centre of the left eye
    Point rightE = new Point(0.7, .7); // And the right eye
    
    Point m1 = new Point(.28, .45); // The four points that
    Point m2 = new Point(.38, .35); // are joined
    Point m3 = new Point(.62, .35); // to make
    Point m4 = new Point(.72, .45); // a smiling mouth shape
    
    add(new Circle(centre, 0.5, Color.YELLOW));
    add(new Circle(leftE, 0.05, Color.BLACK));
    add(new Circle(rightE, 0.05, Color.BLACK));
    
    add(new Line(m1, m2, Color.BLACK, 0.05));
    add(new Line(m2, m3, Color.BLACK, 0.05));
    add(new Line(m3, m4, Color.BLACK, 0.05));
    
  }
}