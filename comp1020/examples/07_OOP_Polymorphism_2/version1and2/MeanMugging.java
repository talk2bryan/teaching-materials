import java.awt.Color;

/* A subclass of the ComplexShape class that 
 * draws a particular kind of ComplexShape.
 * This draws an angry-looking face. 
 * I accidentally stumbled into this beautiful 
 * illustration by failing miserably at drawing
 * a face with goggles.
 * Leonardo da Vinci got nothing on me!
 */
public class MeanMugging extends ComplexShape {
  // In the constructor, we create all the 
  // basic shapes and add them to the Shape []
  // this class inherits from its parent.
  public MeanMugging() {
    Point centre = new Point(.5, .5);
    
    Point leftEye = new Point(centre.x/2, centre.y);
    Point rightEye = new Point(centre.x + centre.x/2, centre.y);
    
    
    Circle innerLeftEye = new Circle(leftEye, 0.025, Color.YELLOW);
    Circle outerLeftEye = new Circle(leftEye, 0.05, Color.GREEN);
    
    Circle innerRightEye = new Circle(rightEye, 0.025, Color.YELLOW);
    Circle outerRightEye = new Circle(rightEye, 0.05, Color.GREEN);
    
    Rect goggle = new Rect(new Point(centre.x, centre.y + centre.y/4), centre.x/2, centre.x/4, Color.BLACK);
    Line lip = new Line(new Point(leftEye.x, leftEye.y - leftEye.y/2), 
                        new Point(rightEye.x, rightEye.y - rightEye.y/2), Color.RED, 0.05);
    
    
    Circle head = new Circle(centre, 0.45, Color.BLACK);
    add(head);
    add(outerLeftEye);
    add(innerLeftEye);
    
    add(outerRightEye);
    add(innerRightEye);
    
    add(goggle);
    add(lip);
  }
}