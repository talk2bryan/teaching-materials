import java.awt.Color;

/* A particular type of Shape that draws 
 * a rectangle given a centre point, the
 * horizontal radius (halfWidth) and 
 * vertical radius (halfHeight).
 */
public class Rect extends Shape {
  private Point centre;
  private double halfWidth, halfHeight;
  
  public Rect(Point c, double halfWidth, double halfHeight,Color cc) {
    super(cc);
    centre = c;
    this.halfWidth = halfWidth;
    this.halfHeight = halfHeight;
  }
  
  public void draw() {
    super.draw(); // Set the pen colour
    StdDraw.filledRectangle(centre.x, centre.y, halfWidth, halfHeight);
  }
}