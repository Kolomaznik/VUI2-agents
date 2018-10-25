package cz.mendelu.vui2.agents.greenfoot;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class LabelActor extends Actor {

    public LabelActor(String label) {
        setLabel(label);
    }

    public void setLabel(String label) {
        GreenfootImage image = new GreenfootImage(label, 12, Color.WHITE, Color.BLACK);
        setImage(image);
    }
}
