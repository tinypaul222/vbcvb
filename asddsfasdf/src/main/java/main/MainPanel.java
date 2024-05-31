package main;
import javax.swing.*;

import entity._GameObject;
import entity._ObjectList;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel{


    public GameInput in;

    private BufferedImage tempScreen;
    private Graphics2D tempGraphics;
    public MainPanel(int w, int h) {
        setPreferredSize(new Dimension(w, h));
        setBackground(Color.gray);
        setDoubleBuffered(true);
        tempScreen = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        tempGraphics = (Graphics2D) tempScreen.getGraphics();

        in = new GameInput();
        addKeyListener(in);
        setFocusable(true);
        requestFocusInWindow();
        



    }

    public void drawToTempScreen(){
        super.paintComponent(tempGraphics);

        tempGraphics.setBackground(Color.gray);
        tempGraphics.fillOval(100, 100, 30, 30);
        for(_GameObject o: _ObjectList.objects){
            o.draw(tempGraphics);
        }
        tempGraphics.setBackground(Color.gray);

    }

    public void drawToRealScreen(){
        Graphics g = getGraphics();
        if(Config.fullscreen){
            g.drawImage(tempScreen, 0, 0, Config.fullScreenWidth, Config.fullScreenHeight, null);
        }
        else if(Config.windowed){
            g.drawImage(tempScreen, 0, 0, Config.windowedWidth, Config.windowedHeight, null);
        }
        else{
            g.drawImage(tempScreen, 0, 0, Main.UNSCALED_WIDTH, Main.UNSCALED_HEIGHT, null);
        }
        g.dispose();
    }

    public void setFullScreen(){
        /* 
        GraphicsEnvironment enver = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = enver.getDefaultScreenDevice();
        device.setFullScreenWindow(Main.frame);

        Config.fullScreenWidth = Main.frame.getHeight();
        Config.fullScreenHeight = Main.frame.getHeight();
        */

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		Main.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Config.fullScreenHeight = (int) height;
		Config.fullScreenWidth = (int) width;
		// fullScreenOffsetFactor = (float) screenWidth / (float) screenWidth2;
    }
}