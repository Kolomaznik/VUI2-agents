package cz.mendelu.vui2.agents.greenfoot;


import greenfoot.World;


public class RobotWorld extends World {

    public static byte[][] world;
    public static AbstractAgent agent;
    public static int timeToLive;
    public static int score;

    public static LabelActor simulationLabel;
    public static LabelActor scoreLabel;

    public RobotWorld() {
        super(world[0].length, world.length, 24);
        setPaintOrder(LabelActor.class, AgentActor.class, DockActor.class, DirtyActor.class, WallActor.class);

        simulationLabel = new LabelActor("Simulation: " + timeToLive);
        addObject(simulationLabel, 2, 0);
        
        setBackground("images/world-background.png");
        for (int r = 0; r < world.length; r++) {
            for (int c = 0; c < world[r].length; c++) {
                if (world[r][c] == 'X') {
                    addObject(new WallActor(), c, r);
                }
                else if (world[r][c] == '_') {
                    addObject(new AgentActor(agent), c, r);
                    addObject(new DockActor(), c, r);
                }
                else if (world[r][c] != '0') {
                    addObject(new DirtyActor(), c, r);
                }
            }
        }

    }
}