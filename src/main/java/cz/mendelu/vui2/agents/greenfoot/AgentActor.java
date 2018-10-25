package cz.mendelu.vui2.agents.greenfoot;

import cz.mendelu.vui2.agents.Action;
import cz.mendelu.vui2.agents.gui.WorldLoader;
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
            RobotWorld.simulationLabel.update(-1);
            RobotWorld.scoreLabel.update(-1);
        }
        if (getOneObjectAtOffset(0, 0, WallActor.class) != null) {
            setImage("images/explosion.png");
            Greenfoot.stop();
        }
        if (RobotWorld.simulationLabel.getValue() == 0) {
            setImage("images/time-off.png");
            finalScore();
            Greenfoot.stop();
        }
    }

    public void forward() {
        setLocation(getX() + direction.dx, getY() + direction.dy);
        RobotWorld.traceActor.traceTo(getX(), getY());
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
            RobotWorld.scoreLabel.update(100);
            RobotWorld.traceActor.traceClean(true);
        } else {
            RobotWorld.traceActor.traceClean(false);
        }
    }

    public void turnOff() {
        finalScore();
        setImage("images/done.png");
        Greenfoot.stop();
    }

    private void updateImage() {
        String direction = this.direction.name().toLowerCase();
        String filename = "images/" + direction + ".png";
        setImage(filename);
    }

    private void finalScore() {
        if (getOneObjectAtOffset(0, 0, DockActor.class) == null) {
            RobotWorld.scoreLabel.update(-1000);
        }
    }

}
