import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

public class Block extends Cards  
{
   private int xPos;
   private int yPos;
   private Color color;
   private int length;
   private int width;
   
   public Block()
   {
      xPos = 100;
      yPos = 480;
      length = 50;
      width = 65;
      setColors();
      color = getRandomColor();
    }
    
   
    public Color getRandomColor()
    {
      int index = (int) (Math.random() * 6);
      Color col =  colors[index];
      return col; 
    }

   public Block(int x, int y, int x2, int y2,Color color)
   {
      xPos = x;
      yPos = y;
      width = Math.abs(x-x2);
      length = Math.abs(y-y2);  
      this.color = color; 
   }
   public void setXPos(int x)
   {
     xPos = x;
   }
   
   public void setYpos(int y)
   {
      yPos = y;
   }
   
   public void setWidth(int w)
   {
      width = w;
   }
   
   public void setLength(int l)
   {
      length = l;
   }
   public void setColor(Color col)
   {
      this.color = col;
   }

   public void draw(Graphics window)
   {
   	window.setColor(getColor());
      window.fillRoundRect(getX(), getY(), getWidth(), getLength(),20,20);
  }

   public void draw(Graphics window, Color col)
   {
      window.setColor(col);
      window.fillRect(getX(), getY(), getWidth(), getLength());
   }
   
  public int getX()
  {
      return xPos; 
  } 
   
  public int getY()
  {
      return yPos; 
  }  
  
  public int getWidth()
  {
      return width; 
  }
  
  public int getLength()
  {
      return length; 
  }
  
  public Color getColor()
  {
      return color; 
  }

  
  public String toString()
  {
   return ("The x pos is: " + getX() + " The y pos is: " + getY() + " The width is: " + getWidth() + " The length is: "  + getLength() + " The color is: " + getColor()); 
  }

   
}