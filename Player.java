import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.applet.Applet;
public class Player extends GameBoard
{
   private int amt;
   private Color col; 
   private int x;
   private int y; 
    public Player(int x)
   {
      amt = x;
      
      
   }
   public Player()
   {
      amt = 2;
      col = Color.GRAY;
      x = 80; 
      y = 800; 
         }
   
   public void create(Graphics window, int x, int y)
   {
      window.setColor(col); 
      window.fillOval(x,y,50,50); 
         }
   public void create1(Graphics window,int x, int y)
   {
      window.setColor(col); 
      window.fillOval(x,y,50,50); 
   }

   public int getAmt()
   {
      return amt;
   }
   public void setY(int y)
   {
      this.y = y;
   }
   public void setX(int x)
   {
      this.x = x;
   }
      public int getX()
   { return x;}
   public int getY()
   { return y;}
      public void setColor(Color color)
   {
      this.col = color;
   }
   public void setLocation(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   /*
   public void updatePosition(int newX, int newY,Graphics window) {
        this.x = newX;
        this.y = newY;
        if (currentPlayerIndex == 0)
            players.get(0).create(window,newX, newY);
        else 
            players.get(1).create(window,newX, newY); 
       }
      */
}