/**Demonstrating drawing fractal shapes using recursion.
  * This program draws a H-Tree (https://en.wikipedia.org/wiki/H_tree).
  * 
  */
public class HTree {
  public static void main(String [] parms) {
    drawHTree(0.5, 0.5, 0.5, 7);
  }
  
  /**This method constructs a H-tree, given its center (x and y)
    * a starting length, (and depth - add this extra param for the recursion).
    * 
    * @params x, y: double. Centre of the 'H' shape 
    * @param len: double. Length of whole line where (x,y) is its centre.
    * @param level: double. How deep want to recursively draw H. 
    *               A good range for my computer is (1 <= depth <= 10), 
    *               but experiment!
    */
  public static void drawHTree(double x, double y, double len, int level){
    // Given x, we can get x0 and x1. Same for y
     /*
              y1
              |
              |
      x0 ---(x,y)--- x1
              |
              |
              y0
      */
    
    if (level == 0) // Base case, end recursion
      return;
    
    double offset = len/2;
    double x0 = x - offset;
    double x1 = x + offset;
    
    double y0 = y - offset;
    double y1 = y + offset;
    
    // Draw a H (3 lines)
    drawLine(x0,y, x1, y); // Middle horizontal line
    drawLine(x0, y1, x0, y0); // Left Vertical
    drawLine(x1, y1, x1, y0); // Right Vertical
    
    // Recursive cases - 4 for a H at each edge...
    level = level - 1;
    len = len/2;
    drawHTree(x0, y1, len, level); // Top left corner
    drawHTree(x1, y1, len, level); // Top right
    drawHTree(x0, y0, len, level); // Bottom left
    drawHTree(x1, y0, len, level); // Bottom right
  }
  
  // Utility method to draw a line given start and end points.
  private static void drawLine(double startX, double startY, double endX,double endY) {
    StdDraw.line(startX, startY, endX, endY);
  }
}