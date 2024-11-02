//Background 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.lang.Math;

public class Cards
{
   public Color[] colors = new Color[6];
   public Cards[] cards = new Cards[64];
   private Color color; 
   public void paintBackground()
   {
     ////
   }
   public void setColors()
   {
      colors[0] = Color.RED;
      colors[1] = Color.BLUE;
      colors[2] = Color.YELLOW;
      colors[3] = Color.GREEN;
      colors[4] = Color.MAGENTA;
      colors[5] = Color.ORANGE;
        
   }
   public Cards()
   {
      color = Color.BLUE; 
   }

   public Cards(Color col)
   {
      color = col; 
   }
   public void makeCards()
   {
      for (int i = 0; i < 65; i++)
      {
         if (i % 8 == 0)
            cards[i] = new Cards(Color.PINK);
         int index = (int) (Math.random() * 6);
         Color color = colors[index]; 
         cards[i] = new Cards(color);
         
      }
   } 
   public Color getColor()
   { 
      return color; 
   }
   public String toString()
   {
      if (color == Color.PINK)
         return ("Move to the closest pink square. Wheter it's infront or behind your game piece.");
      return ("Move to the closest " + color + " square infront of your game piece."); 
   }



}