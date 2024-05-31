package main;
import entity.*;

public class Loop implements Runnable {
	private Thread gameThread;
	private int fps;
	private int fpsTime;
	private long nextUp;
	private long remainingTime;

	public Loop() {

	}

	public void startGame() {

		gameThread = new Thread(this);

		gameThread.run();
	}

	@SuppressWarnings("static-access")
	public void run() {
		while (gameThread != null) {
			fps = 60;
			fpsTime = 1000000000 / fps;
			nextUp = System.nanoTime() + fpsTime;

			update();
			Main.panel.drawToTempScreen();
			Main.panel.drawToRealScreen();

			remainingTime = nextUp - System.nanoTime();
			try {
				if (remainingTime < 0){
					remainingTime = 0;
				}
				gameThread.sleep(remainingTime / 1000000);
			} 
			catch (InterruptedException e) {

			}
		}
	}

	void update() {
		for(_GameObject o: _ObjectList.objects){
			o.update();
		}
	}

}