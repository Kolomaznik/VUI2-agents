package cz.mendelu.vui2.agents.greenfoot;

import cz.mendelu.vui2.agents.Action;
import greenfoot.Actor;

import java.util.EnumMap;
import java.util.Map;

public class AgentActor extends Actor {

    private AbstractAgent agent;

    private Direction direction = Direction.NORTH;

    private Map<Action, Runnable> actions = new EnumMap<>(Action.class);

    public AgentActor(AbstractAgent agent) {
        this.agent = agent;
        actions.put(Action.FORWARD, this::forward);
        actions.put(Action.FORWARD, this::turnLeft);
        actions.put(Action.FORWARD, this::turnRight);
        actions.put(Action.FORWARD, this::clean);
    }

    @Override
    public void act() {
        boolean wall = getOneObjectAtOffset(direction.dx, direction.dy, WallActor.class) != null;
        boolean dirty = getOneObjectAtOffset(0, 0, DirtyActor.class) != null;
        boolean dock = getObjectsAtOffset(0,0, DockActor.class) != null;
        Action action = agent.doAction(wall, dirty, dock);
        if (action != null) {
            actions.get(action).run();
        }
    }

    public void forward() {
        setLocation(getX() + direction.dx, getY() + direction.dy);
    }

    public void turnLeft() {
        direction = direction.onLeft();
    }

    public void turnRight() {
        direction = direction.onRight();
    }

    public void clean() {
        DirtyActor dirty = (DirtyActor) getOneObjectAtOffset(0,0, DirtyActor.class);
        if (dirty != null) {
            getWorld().removeObject(dirty);
        }
    }


}
