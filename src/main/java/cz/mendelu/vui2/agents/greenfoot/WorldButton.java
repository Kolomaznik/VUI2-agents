package cz.mendelu.vui2.agents.greenfoot;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;
import java.io.File;

public class WorldButton extends Actor {

    public WorldButton(File file) {
        GreenfootImage image = new GreenfootImage(
                file.getName(),
                18,
                Color.BLACK,
                Color.CYAN
        );
        setImage(image);
    }
}
