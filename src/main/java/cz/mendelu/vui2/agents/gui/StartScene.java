package cz.mendelu.vui2.agents.gui;

import com.sun.javafx.collections.ObservableListWrapper;
import cz.mendelu.vui2.agents.greenfoot.StartWorld;
import cz.mendelu.vui2.agents.greenfoot.WorldButton;
import greenfoot.Greenfoot;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StartScene {

    private static final String[] AGENTS_NAMES = {"Human agent", "Reactive agent", "World agent", "Goal agent", "Benefit agent"};

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
        Greenfoot.setWorld(new StartWorld());
        Greenfoot.start();
    }
}
