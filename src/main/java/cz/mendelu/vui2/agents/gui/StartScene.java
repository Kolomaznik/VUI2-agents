package cz.mendelu.vui2.agents.gui;

import com.sun.javafx.collections.ObservableListWrapper;
import cz.mendelu.vui2.agents.*;
import cz.mendelu.vui2.agents.greenfoot.RobotWorld;
import cz.mendelu.vui2.agents.greenfoot.Runner;
import greenfoot.Greenfoot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StartScene {

    private static final String[] AGENTS_NAMES = {"Human agent", "Reactive agent", "World agent", "Goal agent", "Benefit agent"};

    @FXML
    private Pane mainPanel;

    @FXML
    private ChoiceBox<String> worlds;

    @FXML
    private ChoiceBox<String> agents;

    @FXML
    private Spinner<Integer> timeToLive;

    @FXML
    void initialize(){
        List<String> worlds = Arrays.stream(new File("./worlds/").listFiles())
                .map(File::getName)
                .collect(Collectors.toList());
        this.worlds.setItems(new ObservableListWrapper<>(worlds));
        this.worlds.setValue(worlds.get(0));

        agents.getItems().addAll(AGENTS_NAMES);
        agents.setValue(AGENTS_NAMES[0]);

        timeToLive.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(100, 100_000, 1_000, 100));
    }

    @FXML
    public void run(ActionEvent e) {
        System.out.println(worlds.getValue() + " " + agents.getValue() + " " + timeToLive.getValue());
        RobotWorld.world = WorldLoader.loadWorld(worlds.getValue());
        if (agents.getValue() == AGENTS_NAMES[0]) {
            RobotWorld.agent = new HumanAgent();
        } else if (agents.getValue() == AGENTS_NAMES[1]) {
            RobotWorld.agent = new ReactionAgent();
        } else if (agents.getValue() == AGENTS_NAMES[2]) {
            RobotWorld.agent = new WorldAgent();
        } else if (agents.getValue() == AGENTS_NAMES[3]) {
            RobotWorld.agent = new GoalAgent();
        } else if (agents.getValue() == AGENTS_NAMES[4]) {
            RobotWorld.agent = new BenefitAgent();
        }
        RobotWorld.timeToLive = timeToLive.getValue();
        Runner runner = new Runner();
        Greenfoot.start();

        Stage stage = (Stage) mainPanel.getScene().getWindow();
        stage.close();
    }
}
