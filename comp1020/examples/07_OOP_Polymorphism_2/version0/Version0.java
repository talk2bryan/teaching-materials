/* Test the Point, and various Shape subclasses. 
 * Note that the Shape type is never directly used. 
 */
public class Version0 {
  public static void main(String [] parms) {
    // Draw one of the two at a time.
    if (false)
      drawBasicShapes();
    else
      drawFaceUsingComplexShape();
  }
  
  public static void drawBasicShapes() {
    Point lowerLeft = new Point(.25, .25);
    Point upperLeft = new Point(.5, .75);
    
    Circle one = new Circle(lowerLeft, 0.1);
    Circle two = new Circle(lowerLeft, 0.2);
    two.draw();
    one.draw();
    
    Rect rect = new Rect(upperLeft, 0.3, 0.1);
    rect.draw();
    
    Line l = new Line(lowerLeft, upperLeft);
    l.draw();
  }
  
  public static void drawFaceUsingComplexShape() {
    ComplexShape cs = new ComplexShape();
    
    Point centre = new Point(.5, .5);
    
    Point leftEye = new Point(centre.x/2, centre.y);
    Point rightEye = new Point(centre.x + centre.x/2, centre.y);
    
    
    Circle innerLeftEye = new Circle(leftEye, 0.025);
    Circle outerLeftEye = new Circle(leftEye, 0.05);
    
    Circle innerRightEye = new Circle(rightEye, 0.025);
    Circle outerRightEye = new Circle(rightEye, 0.05);
    
    Rect goggle = new Rect(new Point(centre.x, centre.y + centre.y/4), centre.x/2, centre.x/4);
    Line lip = new Line(new Point(leftEye.x, leftEye.y - leftEye.y/2), 
                        new Point(rightEye.x, rightEye.y - rightEye.y/2));
    
    Circle head = new Circle(centre, 0.45);
    
    cs.add(innerLeftEye);
    cs.add(outerLeftEye);
    
    cs.add(outerRightEye);
    cs.add(innerRightEye);
    
    cs.add(goggle);
    cs.add(lip);
    
    cs.add(head);
    
    cs.draw();
  }
  
}