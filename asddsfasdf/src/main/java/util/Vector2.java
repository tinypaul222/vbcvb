package util;

public class Vector2{
	public int x;
	public int y;

	public Vector2(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void add(Vector2 v){
		 x += v.x;
		 y += v.y;
	}

	public void subtract(Vector2 v){
		 x -= v.x;
		 y -= v.y;
	}

	public String toString(){return x + " " + y;}

	public boolean equals(Vector2 v){
		return x == v.x && y == v.y;
	}

	public void addX(int X){
		x += X;
	}

	public void addY(int Y){
		y += Y;
	}

	public void reset(){x = 0; y = 0;}
}