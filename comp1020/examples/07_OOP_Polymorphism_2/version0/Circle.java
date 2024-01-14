/* A particular type of Shape that draws 
  * a circle with a given centre and radius. 
  */
public class Circle extends Shape {
  private Point centre;
  private double radius;
  
  public Circle(Point p, double r) {
    centre = p;
    radius = r;
  }
  
  public void draw() {
    StdDraw.circle(centre.x, centre.y, radius);
  }
}