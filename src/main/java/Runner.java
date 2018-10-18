import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.vui2.agents.greenfoot.StartWorld;

/**
 * A sample runner for a greenfoot project.
 */
public class Runner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(Runner.class,
                // 3. Prepare the configuration for the runner based on the greenfoot class
                Configuration.forWorld(StartWorld.class)
                        // Set the project name as you wish
                        .projectName("Demo project")
                        .hideControls(true)
        );
    }
}