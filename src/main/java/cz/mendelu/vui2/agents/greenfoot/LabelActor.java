package cz.mendelu.vui2.agents.greenfoot;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class LabelActor extends Actor {

    private String label;
    private int value;

    public LabelActor(String label, int value) {
        this.label = label;
        this.value = value;
        this.updateImage();
    }

    public void update(int diff) {
        value += diff;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(label + value, 12, Color.WHITE, Color.BLACK);
        setImage(image);
    }

    public int getValue() {
        return value;
    }
}
