package cz.mendelu.vui2.agents.greenfoot;

import cz.mendelu.vui2.agents.Action;
import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.EnumMap;
import java.util.Map;

public class AgentActor extends Actor {

    private AbstractAgent agent;

    private Direction direction = Direction.NORTH;

    private Map<Action, Runnable> actions = new EnumMap<>(Action.class);

    public AgentActor(AbstractAgent agent) {
        this.agent = agent;
        actions.put(Action.FORWARD, this::forward);
        actions.put(Action.TURN_LEFT, this::turnLeft);
        actions.put(Action.TURN_RIGHT, this::turnRight);
        actions.put(Action.CLEAN, this::clean);
        actions.put(Action.TURN_OFF, this::turnOff);
        updateImage();
    }

    @Override
    public void act() {
        boolean wall = getOneObjectAtOffset(direction.dx, direction.dy, WallActor.class) != null;
        boolean dirty = getOneObjectAtOffset(0, 0, DirtyActor.class) != null;
        boolean dock = getObjectsAtOffset(0,0, DockActor.class) != null;
        Action action = agent.doAction(wall, dirty, dock);
        if (action != null && actions.containsKey(action)) {
            actions.get(action).run();
            RobotWorld.timeToLive -= 1;
            RobotWorld.simulationLabel.setLabel("Simulation: " + RobotWorld.timeToLive);
        }
        if (getOneObjectAtOffset(0, 0, WallActor.class) != null) {
            Greenfoot.stop();
        }
    }

    public void forward() {
        setLocation(getX() + direction.dx, getY() + direction.dy);
    }

    public void turnLeft() {
        direction = direction.onLeft();
        updateImage();
    }

    public void turnRight() {
        direction = direction.onRight();
        updateImage();
    }

    public void clean() {
        DirtyActor dirty = (DirtyActor) getOneObjectAtOffset(0,0, DirtyActor.class);
        if (dirty != null) {
            getWorld().removeObject(dirty);
        }
    }

    public void turnOff() {
        Greenfoot.stop();
    }

    private void updateImage() {
        String direction = this.direction.name().toLowerCase();
        String filename = "images/" + direction + ".png";
        setImage(filename);
    }

}
