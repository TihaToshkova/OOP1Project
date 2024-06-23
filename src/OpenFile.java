import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OpenFile implements OpenFileInterface {
    AddPlanet addPlanet = new AddPlanet();
    CreateJedi createJedi = new CreateJedi();

    public void open(FileOperations fileOperations,Scanner scanner) {
        System.out.print("Enter file name to open: ");
        String fileName = scanner.nextLine().trim();

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist. Creating a new file with empty content.");
            fileOperations.setFileName(fileName);
            fileOperations.clearPlanetsAndJedis();
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            fileOperations.setFileName(fileName);
            fileOperations.clearPlanetsAndJedis();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("Planet ")) {
                    String planetName = line.substring(7).trim();
                    addPlanet.addPlanet(fileOperations, planetName);
                } else if (line.startsWith("Jedi ")) {
                    String[] parts = line.substring(5).trim().split(" ");
                    if (parts.length == 6) {
                        String jediName = parts[0];
                        String jediRank = parts[1];
                        int jediAge = Integer.parseInt(parts[2]);
                        String saberColor = parts[3];
                        int jediStrength = Integer.parseInt(parts[4]);
                        String planetName = parts[5];

                        createJedi.createJedi(fileOperations, planetName, jediName, jediRank, jediAge, saberColor, jediStrength);
                    }
                }
            }
            System.out.println("Successfully opened " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to open file " + fileName);
            e.printStackTrace();
        }
    }
}
