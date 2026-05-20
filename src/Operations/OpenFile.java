package Operations;

import Jedi.CreateJedi;
import Planet.AddPlanet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The {@code Operations.OpenFile} class implements {@code Operations.OpenFileInterface} to open and process a file containing planet and Jedi.Jedi data.
 * It reads the contents of the file, initializes planets and jedis accordingly in {@code Operations.FileOperations}, and handles file-related exceptions.
 */
public class OpenFile implements OpenFileInterface {
    AddPlanet addPlanet = new AddPlanet();
    CreateJedi createJedi = new CreateJedi();

    /**
     * Opens the specified file, reads its contents, and initializes planets and jedis in {@code Operations.FileOperations}.
     * <p>
     * If the file does not exist, it creates a new file with empty content. If the file exists, it reads each line,
     * identifies whether it describes a planet or a Jedi.Jedi, and adds them to the appropriate data structures in {@code Operations.FileOperations}.
     * </p>
     *
     * @param fileOperations the {@code Operations.FileOperations} object to manage planets and jedis
     * @param scanner        the {@code Scanner} object to read user input
     * @throws NullPointerException if {@code fileOperations} or {@code scanner} is null
     */
    public void execute(FileOperations fileOperations, Scanner scanner) {
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
                    addPlanet.execute(fileOperations, planetName);
                } else if (line.startsWith("Jedi ")) {
                    String[] parts = line.substring(5).trim().split(" ");
                    if (parts.length == 6) {
                        String jediName = parts[0];
                        String jediRank = parts[1];
                        int jediAge = Integer.parseInt(parts[2]);
                        String saberColor = parts[3];
                        int jediStrength = Integer.parseInt(parts[4]);
                        String planetName = parts[5];

                        createJedi.execute(fileOperations, planetName, jediName, jediRank, jediAge, saberColor, jediStrength);
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