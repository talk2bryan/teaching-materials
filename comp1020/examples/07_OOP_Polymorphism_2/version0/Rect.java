/* A particular type of Shape that draws 
  * a rectangle given a centre point, the
  * horizontal radius (halfWidth) and 
  * vertical radius (halfHeight).
  */
public class Rect extends Shape {
  private Point centre;
  private double halfWidth, halfHeight;
  
  public Rect(Point c, double halfWidth, double halfHeight) {
    centre = c;
    this.halfWidth = halfWidth;
    this.halfHeight = halfHeight;
  }
  
  public void draw() {
    StdDraw.rectangle(centre.x, centre.y, halfWidth, halfHeight);
  }
}