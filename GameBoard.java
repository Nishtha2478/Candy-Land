import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class GameBoard extends Canvas implements Runnable, MouseListener{

   private Block[] blocks = new Block[40];
   private Cards[] cards = new Cards[64];
   private Coordinate[] cord = new Coordinate[40];
   public List<Player> players;  
    int turn = 0;
   int newX;
    int newY;
    int newX2;
    int newY2;
   boolean inBoard = false;
    boolean oval = false;
    public Color col;
    boolean oval2 = false;
    boolean apear = true;
    int newXRed, newYRed; // Variables for the position of the red oval
int newXBlue, newYBlue; 
   //private BlockClickListener blockClickListener = new BlockClickListener();
   public GameBoard()
   { 
      
      setBackground(Color.WHITE);
      setVisible(true); 
      players = new ArrayList<>();
      addMouseListener(this);
            
      for (int i = 0; i < blocks.length; i++)
      {
         blocks[i] = new Block();
         if (i % 8 == 0)
            blocks[i].setColor(Color.PINK);
       }
       
      for (int i = 1; i < blocks.length; i++)
      {
         if (blocks[i].getColor() == blocks[i-1].getColor()){
             blocks[i].setColor(blocks[i].getRandomColor());
            }
         blocks[i].setXPos(blocks[i-1].getX()+65);
         if (i == 6)
            blocks[i].setYpos(blocks[i-1].getY()-5);
         if (i == 7)
             blocks[i].setYpos(blocks[i-1].getY()-10);
         if (i == 8)
              blocks[i].setYpos(blocks[i-1].getY()-15);
         if (i == 9) {
               blocks[i].setXPos(blocks[i-1].getX());
               blocks[i].setYpos(blocks[i-1].getY()-50);
             }
         if (i >= 10)
         {
            blocks[i].setXPos(blocks[i-1].getX()-65);
            blocks[i].setYpos(blocks[i-1].getY()-50);
         }
         if (i == 11){
             blocks[i].setXPos(blocks[i-1].getX()-65);
             blocks[i].setYpos(blocks[i-1].getY()-30);
          }
          if (i == 12)
          {
            blocks[i].setXPos(blocks[i-1].getX()+60);
            blocks[i].setYpos(blocks[i-1].getY()-46);
          }
          if (i == 13)
          {
            blocks[i].setXPos(blocks[i-1].getX()+60);
            blocks[i].setYpos(blocks[i-1].getY()-45);
          }
          if (i == 14)
          {
             blocks[i].setXPos(blocks[i-1].getX()+60);
             blocks[i].setYpos(blocks[i-1].getY());
          }
          if (i == 15)
          {
             blocks[i].setXPos(blocks[i-1].getX());
             blocks[i].setYpos(blocks[i-1].getY()-50);
          }
          if (i == 16)
            blocks[i].setYpos(blocks[i-1].getY()-5);
         if (i == 17)
             blocks[i].setYpos(blocks[i-1].getY()-10);
         if (i == 18)
              blocks[i].setYpos(blocks[i-1].getY()-15);
         if ( i >= 19 && i < 25)
         {
            blocks[i].setXPos(blocks[i-1].getX()-60);
            blocks[i].setYpos(blocks[i-1].getY()+40);
         }
         if (i >= 26 && i < 32)
         {
            blocks[i].setXPos(blocks[i-1].getX()+60);
            blocks[i].setYpos(blocks[i-1].getY()-40);
         }
             
         if(i >= 32 && i < 36)
         {
            blocks[i].setXPos(blocks[i-1].getX()-65);
            blocks[i].setYpos(blocks[i-1].getY());
         }
         if (i == 36){
            blocks[i].setXPos(blocks[i-1].getX()-65);
            blocks[i].setYpos(blocks[i-1].getY()-5);
            }
         if (i == 37){
             blocks[i].setXPos(blocks[i-1].getX()-65);
             blocks[i].setYpos(blocks[i-1].getY()-10);}
         if (i == 38){
               blocks[i].setXPos(blocks[i-1].getX());
               blocks[i].setYpos(blocks[i-1].getY()-50);
               }
        
               }
     
           new Thread(this).start();
    }
   public void addPlayer() {
       players.add(new Player(1));
       players.add(new Player(1));
    }
     public void update(Graphics window)
   {
        paint(getGraphics()); 
        paint(getGraphics()); // Use getGraphics() to get the Graphics object associated with this Canvas
    
    // Draw oval for player 1
    if (oval) {
        Graphics g = cord[0].getWindow();
        g.setColor(Color.RED); // Adjust color as needed
        g.fillOval(newX, newY, 50, 50);
    }
    
    // Draw oval for player 2
    if (oval2) {
        Graphics g = cord[0].getWindow();
        g.setColor(Color.BLUE); // Adjust color as needed
        g.fillOval(newX, newY, 50, 50);
    }
}

        
    
               
      
  public void paint(Graphics g) {
  super.paint(g);
  blocks[0].getColor();
    for (Block block : blocks) {
        block.draw(g);
        for (int i = 0; i < cord.length; i++)
        {
         cord[i] = new Coordinate(block.getX()+block.getWidth(), block.getY() + block.getLength(), g);
        }
    }
    addPlayer();
     players.get(0).setColor(Color.BLACK);
      
      players.get(0).create(g,40,480);
      players.get(1).create1(g,40,440);
      

 

      }
      
        // MOVE PLAYER TO THE MOUSE CURSOR'S LOCATION
      // Check the turn to determine which player to redraw
    public void updatePlayerPosition(int player){
    
    if (player == 1) {
        newXRed = newX; // Set position for red oval
        newYRed = newY;
        oval = true;
        oval2 = false;
        players.get(1).setColor(Color.WHITE);
        players.get(0).setColor(Color.WHITE);
    } else if (player == 2) {
        newXBlue = newX; // Set position for blue oval
        newYBlue = newY;
        oval2 = true;
        oval = false;
        
    }    
    repaint(); // Trigger a repaint to update the canvas
    turn++; // Increment turn

        // Trigger a repaint to update the canvas
        	}
       
      
       
  public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(19);
            
         }
      }catch(Exception e)
      {
      }
  	}	
   
   

    @Override
    public void mouseExited(MouseEvent e) {
     inBoard = false;
     System.out.println("Mouse exited the component.");
    }
 
     @Override
     public void mouseEntered(MouseEvent e){
         // When the mouse cursor enters an area (panel or frame), this is run
         inBoard = true;
 
     }
     
     public void mouseReleased(MouseEvent e){
     
             newX = e.getX();
             newY = e.getY();
      
         if (turn % 2 == 0) {
           updatePlayerPosition(1);
             
             
         } 
         else {
           updatePlayerPosition(2);
                      }
 
              // When the mouse cursor (not clicked) gets clicked, this is run
     }
    
         // Increment turn
 
         
                       
     @Override
     public void mouseClicked(MouseEvent e){
     }
          @Override
     public void mousePressed(MouseEvent e){

}
}