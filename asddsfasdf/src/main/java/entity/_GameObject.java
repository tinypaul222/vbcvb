package entity;
import java.awt.*;

public abstract class _GameObject {
    public _GameObject(){}

    public abstract void start();
    public abstract void update();
    public abstract void draw(Graphics2D g);

}