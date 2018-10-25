package cz.mendelu.vui2.agents.greenfoot;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class TraceActor extends Actor {

    private GreenfootImage image;

    private int x, y;

    public TraceActor(int width, int height, int x, int y) {
        this.x = x;
        this.y = y;
        this.image = new GreenfootImage(toPixel(width),toPixel(height));
        this.image.setColor(Color.RED);
        this.setImage(image);
    }

    private int toPixel(int coordinate) {
        return coordinate * RobotWorld.CELL_SIZE;
    }

    public void traceTo(int x, int y) {
        image.drawLine(toPixel(this.x), toPixel(this.y), toPixel(x), toPixel(y));
        this.x = x;
        this.y = y;
    }

    public void traceClean(boolean success) {
        int size = RobotWorld.CELL_SIZE / 2;
        int move = size / 2;
        if (success) {
            image.fillOval(toPixel(this.x) - move, toPixel(this.y) - move, size, size);
        } else {
            image.drawOval(toPixel(this.x) - move, toPixel(this.y) - move, size, size);

        }
    }


}
