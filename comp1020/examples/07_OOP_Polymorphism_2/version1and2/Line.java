import java.awt.Color;

/* A particular type of Shape that draws 
 * a line connecting two endpoints. 
 */
public class Line extends Shape {
  // Instance variables
  private Point start, end;
  private double radius;
  
  public Line(Point start, Point end, Color c, double radius) {
    super(c);
    this.start = start;
    this.end = end;
    this.radius = radius;
  }
  
  public void draw() {
    super.draw(); // Set the colour of the pen
    StdDraw.setPenRadius(radius); // Set the width of pen lines
    StdDraw.line(start.x, start.y, end.x, end.y);
  }
}