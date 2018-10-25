package cz.mendelu.vui2.agents.greenfoot;

import bh.greenfoot.runner.GreenfootRunner;

/**
 * A sample runner for a greenfoot project.
 */
public class Runner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(Runner.class,
                // 3. Prepare the configuration for the runner based on the greenfoot class
                Configuration.forWorld(RobotWorld.class)
                        // Set the project name as you wish
                        .projectName("Demo project")
                        .hideControls(false)
        );
    }

    public Runner() {
        super();
    }
}