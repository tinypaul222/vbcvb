package main;
import java.awt.*;
import javax.swing.*;

import entity.*;

public class Main {
  public static JFrame frame;
  public static MainPanel panel;
  public final static int UNSCALED_WIDTH = 384;
  public final static int UNSCALED_HEIGHT = 216;

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    frame = new JFrame("Game");
    frame.setSize(UNSCALED_WIDTH, UNSCALED_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setUndecorated(true);
    frame.setVisible(true);
    frame.setBackground(Color.gray);
    panel = new MainPanel(UNSCALED_WIDTH, UNSCALED_HEIGHT);
    frame.add(panel);
    frame.pack();
    panel.requestFocusInWindow();

    Config.fullscreen = true; panel.setFullScreen();

    Loop gameLoop = new Loop();




    PlayerMovement player = new PlayerMovement(20, 20);


    for(_GameObject o: _ObjectList.objects){
      o.start();
    }


    gameLoop.startGame();


    
  }
}
