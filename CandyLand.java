import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
public class CandyLand extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private JPanel cardPanel;
    private CardLayout cardLayout;
     
    public CandyLand() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        JPanel initialScreen = createInitialScreen();
        cardPanel.add(initialScreen, "InitialScreen");

        GameBoard gameBoard = new GameBoard();
        cardPanel.add(gameBoard, "GameBoard");
                      
        getContentPane().add(cardPanel);
        setVisible(true);
    }

    private JPanel createInitialScreen() {
    JPanel initialScreenPanel = new JPanel();
    initialScreenPanel.setLayout(new BorderLayout());

    JButton startButton = new JButton("Start Game (Press Enter)");
    startButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, "GameBoard");
        }
    });

 
    initialScreenPanel.setFocusable(true);
    initialScreenPanel.requestFocusInWindow(); 
    initialScreenPanel.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                cardLayout.show(cardPanel, "GameBoard");
            }
        }
    });

    initialScreenPanel.add(startButton, BorderLayout.CENTER);

    return initialScreenPanel;
}

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new CandyLand();
        });
    }
}
