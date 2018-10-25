package cz.mendelu.vui2.agents;

import cz.mendelu.vui2.agents.greenfoot.AbstractAgent;
import greenfoot.Greenfoot;

public class HumanAgent extends AbstractAgent {

    @Override
    public Action doAction(boolean canMove, boolean dirty, boolean dock) {
        String key = Greenfoot.getKey();
        if (key != null) {
            switch (key) {
                case "up":
                    return Action.FORWARD;
                case "left":
                    return Action.TURN_LEFT;
                case "right":
                    return Action.TURN_RIGHT;
                case "space":
                    return Action.CLEAN;
            }
        }
        return null;
    }
}
