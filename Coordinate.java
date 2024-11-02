import java.awt.Graphics;
public class Coordinate 
{
   private int x;
   private int y;
   Graphics window; 
   public Coordinate(int x,int y,Graphics window)
   {
      this.x = x;
      this.y = y;
      this.window = window; 
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public Graphics getWindow()
   {
      return window;
   }
}