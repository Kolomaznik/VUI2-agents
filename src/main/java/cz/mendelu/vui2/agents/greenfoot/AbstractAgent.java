package cz.mendelu.vui2.agents.greenfoot;

import cz.mendelu.vui2.agents.Action;

public abstract class AbstractAgent {

    public abstract Action doAction(boolean isWall, boolean dirty, boolean dock);

}
