package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameInput implements KeyListener{
	int i = 0;
	public boolean[] keyPresses;
	public GameInput(){
		keyPresses = new boolean[128];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){System.exit(0);}
		if(e.getKeyCode() > keyPresses.length){}
		else{keyPresses[e.getKeyCode()] = true;}	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		i = 0;
		if(e.getKeyCode() > keyPresses.length){}
		else{keyPresses[e.getKeyCode()] = false;}		
	}

}