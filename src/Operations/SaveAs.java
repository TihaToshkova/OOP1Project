package Operations;

import Jedi.Jedi;
import Planet.Planet;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The {@code Operations.SaveAs} class implements {@code Operations.SaveAsInterface} to save the current state of planets and jedis to a new file.
 */
public class SaveAs implements SaveAsInterface {

    /**
     * Saves the current state of planets and jedis to a new file specified by {@code newFileName}.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data to save
     * @param newFileName    the name of the new file to save as
     */
    @Override
    public void execute(FileOperations fileOperations, String newFileName) {
        if (fileOperations.getFileName() == null) {
            System.out.println("Error: No file is currently open.");
            return;
        }

        try (FileWriter writer = new FileWriter(newFileName)) {
            for (Planet planet : fileOperations.getPlanets().values()) {
                writer.write("Planet " + planet.getName() + "\n");
                for (Jedi jedi : planet.getPopulation()) {
                    writer.write("Jedi " + jedi.getJediName() + " " + jedi.getRank() + " " +
                            jedi.getAge() + " " + jedi.getLightSaberColor() + " " + jedi.getStrength() + " " +
                            planet.getName() + "\n");
                }
            }
            System.out.println("File saved successfully as " + newFileName);
        } catch (IOException e) {
            System.out.println("Error: Unable to save file as " + newFileName);
            e.printStackTrace();
        }
    }
}
