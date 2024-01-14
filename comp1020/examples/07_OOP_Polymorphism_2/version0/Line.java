/* A particular type of Shape that draws 
  * a line connecting two endpoints. 
  */
public class Line extends Shape {
  // Instance variables
  private Point start, end;
  
  public Line(Point s, Point e) {
    start = s;
    end = e;
  }
  
  public void draw() {
    StdDraw.line(start.x, start.y, end.x, end.y);
  }
}