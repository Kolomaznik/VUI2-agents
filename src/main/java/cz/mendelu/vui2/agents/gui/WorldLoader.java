package cz.mendelu.vui2.agents.gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorldLoader {

    private WorldLoader() {}

    public static byte[][] loadWorld(String name) {
        try (BufferedReader in = new BufferedReader(new FileReader("worlds/" + name))) {
            String line;
            List<String> buffer = new ArrayList<>();
            while ((line = in.readLine()) != null) {
                buffer.add(line);
            }

            byte[][] result = new byte[buffer.get(0).length()][];
            for (int i = 0; i < buffer.size(); i++) {
                line = buffer.get(i);
                result[i] = line.getBytes();
            }

            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
