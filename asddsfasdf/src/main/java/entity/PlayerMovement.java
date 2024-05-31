package entity;
import java.awt.*;
import util.*;

import java.awt.event.KeyEvent;

import main.Main;


public class PlayerMovement extends _GameObject{
	private Vector2 thisPos;
	private Vector2 movement;
	private static final int normSpeed = 2;
	private static final int sprintSpeed = 3;
	private int realSpeed;

	public PlayerMovement(int x, int y){
		_ObjectList.objects.add(this);
		thisPos = new Vector2(x, y);
		movement = new Vector2(0, 0);
		realSpeed = normSpeed;
    }

	@Override
	public void start() {
	}

	@Override
	public void update() {
		if(Main.panel.in.keyPresses[KeyEvent.VK_SHIFT]){
			realSpeed = sprintSpeed;
		}
		else{
			realSpeed = normSpeed;
		}

		if(Main.panel.in.keyPresses[KeyEvent.VK_W]){
			movement.y -= realSpeed; 
		}
		if(Main.panel.in.keyPresses[KeyEvent.VK_A]){
			movement.x -= realSpeed; 
		}
		if(Main.panel.in.keyPresses[KeyEvent.VK_S]){
			movement.y += realSpeed; 
		}
		if(Main.panel.in.keyPresses[KeyEvent.VK_D]){
			movement.x += realSpeed; 
		}

		if(movement.x != 0 && movement.y != 0){
			movement.x = (int) Math.round(Integer.signum(movement.x) * Math.sqrt((realSpeed*realSpeed) / 2.0));
			movement.y = (int) Math.round(Integer.signum(movement.y) * Math.sqrt((realSpeed*realSpeed) / 2.0));
		}

		thisPos.add(movement);
		movement.reset();
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(thisPos.x, thisPos.y, 16, 36);
	}
}