package cz.mendelu.vui2.agents.greenfoot;

import cz.mendelu.vui2.agents.Action;

public abstract class AbstractAgent {

    public abstract Action doAction(boolean canMove, boolean dirty, boolean dock);

}
