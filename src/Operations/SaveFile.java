package Operations;

import Jedi.Jedi;
import Planet.Planet;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The {@code Operations.SaveFile} class implements the {@code Operations.SaveFileInterface} and provides functionality to save the current state of planets and jedis to the currently open file.
 */
public class SaveFile implements SaveFileInterface {

    /**
     * Saves the current state of planets and jedis from {@code fileOperations} to the currently open file.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data to save
     */
    @Override
    public void execute(FileOperations fileOperations) {
        if (fileOperations.getFileName() == null) {
            System.out.println("Error: No file is currently open.");
            return;
        }

        try (FileWriter writer = new FileWriter(fileOperations.getFileName())) {
            for (Planet planet : fileOperations.getPlanets().values()) {
                writer.write("Planet " + planet.getName() + "\n");
                for (Jedi jedi : planet.getPopulation()) {
                    writer.write("Jedi " + jedi.getJediName() + " " + jedi.getRank() + " " +
                            jedi.getAge() + " " + jedi.getLightSaberColor() + " " + jedi.getStrength() + " " +
                            planet.getName() + "\n");
                }
            }
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: Unable to save file.");
            e.printStackTrace();
        }
    }
}
