import java.io.FileWriter;
import java.io.IOException;

public class SaveAs implements SaveAsInterface{
    public void saveAs(FileOperations fileOperations,String newFileName) {
        if (fileOperations.getFileName() == null) {
            System.out.println("Error: No file is currently open.");
            return;
        }

        try (FileWriter writer = new FileWriter(newFileName)) {
            for (Planet planet : fileOperations.getPlanets().values()) {
                writer.write("Planet " + planet.getName() + "\n");
                for (Jedi jedi : planet.getPopulation()) {
                    writer.write("Jedi " + jedi.getJediName() + " " + jedi.getRank() + " " +
                            jedi.getAge() + " " + jedi.getLightsaberColor() + " " + jedi.getStrength() + " " +
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
