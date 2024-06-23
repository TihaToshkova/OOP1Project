import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SaveFile implements SaveFileInterface{
    public void save(FileOperations fileOperations) {
        if (fileOperations.getFileName() == null) {
            System.out.println("Error: No file is currently open.");
            return;
        }

        try (FileWriter writer = new FileWriter(fileOperations.getFileName())) {
            for (Planet planet : fileOperations.getPlanets().values()) {
                writer.write("Planet " + planet.getName() + "\n");
                for (Jedi jedi : planet.getPopulation()) {
                    writer.write("Jedi " + jedi.getJediName() + " " + jedi.getRank() + " " +
                            jedi.getAge() + " " + jedi.getLightsaberColor() + " " + jedi.getStrength() + " " +
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
