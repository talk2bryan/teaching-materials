/* A collection class that will hold a list of 
 * Shapes. Shapes can be added to a ComplexShape, 
 * and the whole list can be drawn. 
 */
public class ComplexShape extends Shape {
  
  // Global constant - the limit to the number of 
  // Shapes per ComplexShape.
  private static final int MAX = 20;
  
  // Instance variables - a simple partially-full array 
  // This will not grow. Only MAX Shapes can be handled.
  private Shape [] shapes;
  private int count;
  
  // Constructor
  public ComplexShape() {
    shapes = new Shape[MAX];
    count = 0;
  }
  
  // Add a new Shape to the ComplexShape, at the end.
  public void add(Shape s) {
    if (count < MAX)
      shapes[count++] = s;
  }
  
  // draw() will draw all of the Shapes in the ComplexShape
  public void draw() {
    for (Shape s : shapes)
      if (s != null)
      s.draw();
  }
}