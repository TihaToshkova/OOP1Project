import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileOperations implements FileOperationsInterface{
    private String fileName;
    private String content;
    private Map<String, Planet> planets;

    public FileOperations(){
        this.planets = new HashMap<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void open(Scanner scanner)
    {
        System.out.print("Enter file name to open: ");
        fileName = scanner.nextLine();

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist. Creating a new file.");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error: Unable to create the file.");
            }
        } else {
            try {
                List<String> lines = Files.readAllLines(Paths.get(fileName));
                String currentPlanetName = null;
                for (String line : lines) {
                    if (line.startsWith("Planet: ")) {
                        currentPlanetName = line.substring(8).trim();
                        planets.put(currentPlanetName, new Planet(currentPlanetName));
                    } else if (line.startsWith("Jedi: ")) {
                        if (currentPlanetName == null) {
                            System.out.println("Error: Jedi found without a planet.");
                            continue;
                        }
                        String[] jediInfo = line.substring(6).split(", ");
                        String jediName = jediInfo[0];
                        String jediRank = jediInfo[1].split(": ")[1];
                        int jediAge = Integer.parseInt(jediInfo[2].split(": ")[1]);
                        String saberColor = jediInfo[3].split(": ")[1];
                        int jediStrength = Integer.parseInt(jediInfo[4].split(": ")[1]);

                        Jedi newJedi = new Jedi(jediName, Rank.valueOf(jediRank.toUpperCase()), jediAge, saberColor, jediStrength);
                        planets.get(currentPlanetName).addJedi(newJedi);
                    }else{
                        System.out.println("Error");
                    }
                }
                System.out.println("Successfully opened " + fileName);
            } catch (IOException e) {
                System.out.println("Error: Unable to read the file.");
            }
        }
    }

    public void close() {
        if (fileName != null) {
            fileName = null;
            content = null;
            System.out.println("Successfully closed file.");
        } else {
            System.out.println("Error: No file is currently open.");
        }
    }

    public void save() {
        if (fileName == null) {
            System.out.println("Error: No file is currently open.");
            return;
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            for (Planet planet : planets.values()) {
                writer.write("Planet: " + planet.getName() + "\n");
                for (Jedi jedi : planet.getPopulation()) {
                    writer.write(String.format("Jedi: %s, Rank: %s, Age: %d, SaberColor: %s, Strength: %.2f\n",
                            jedi.getJediName(), jedi.getRank().toString(), jedi.getAge(), jedi.getLightsaberColor(), jedi.getStrength()));
                }
            }
            System.out.println("Successfully saved " + fileName);
        } catch (IOException e) {
            System.out.println("Error: Unable to save the file.");
        }
    }

    public void saveAs(String newFileName) {
        try (FileWriter writer = new FileWriter(newFileName)) {
            writer.write(content);
            System.out.println("Successfully saved " + newFileName);
        } catch (IOException e) {
            System.out.println("Error: Could not save changes to file.");
        }
    }

    public void help() {
        System.out.println("The following commands are supported:");
        System.out.println("open <file>       - opens <file>");
        System.out.println("close             - closes currently opened file");
        System.out.println("save              - saves the currently open file");
        System.out.println("save_as <file>     - saves the currently open file in <file>");
        System.out.println("help              - prints this information");
        System.out.println("exit              - exits the program");
        System.out.println("add_planet <name>  - adds a new planet");
        System.out.println("create_jedi <planet_name> <jedi_name> <rank> <age> <saber_color> <strength>");
        System.out.println("                  - creates a new jedi on a planet");
        System.out.println("remove_jedi <jedi_name> <planet_name>");
        System.out.println("                  - removes a jedi from a planet");
        System.out.println("promote_jedi <jedi_name> <multiplier>");
        System.out.println("                  - promotes a jedi");
        System.out.println("demote_jedi <jedi_name> <multiplier>");
        System.out.println("                  - demotes a jedi");
        System.out.println("print <planet_name>");
        System.out.println("                  - prints all jedis on a planet");
        System.out.println("print <jedi_name>");
        System.out.println("                  - prints details of a jedi");
        System.out.println("print <planet_name1> + <planet_name2>");
        System.out.println("                  - prints all jedis on two planets sorted lexicographically");
    }

    public void addPlanet(String planetName)
    {
        if (!planets.containsKey(planetName)) {
            planets.put(planetName, new Planet(planetName));
            System.out.println("Successfully added planet " + planetName);
        } else {
            System.out.println("Error: Planet already exists.");
        }
    }

    public void createJedi(String planetName, String jediName, String jediRank, int jediAge, String saberColor, int jediStrength) {
        Planet planet = planets.get(planetName);
        if (planet == null) {
            System.out.println("Error: Planet " + planetName + " does not exist.");
            return;
        }

        for (Jedi jedi : planet.getPopulation()) {
            if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                System.out.println("Error: Jedi " + jediName + " already exists.");
                return;
            }
        }

        Jedi newJedi = new Jedi(jediName, Rank.valueOf(jediRank.toUpperCase()), jediAge, saberColor, jediStrength);
        planet.addJedi(newJedi);
        System.out.println("Successfully added Jedi " + jediName + " to planet " + planetName);

    }

    public void removeJedi(String jediName, String planetName) {
        Planet planet = planets.get(planetName);
        if (planet == null) {
            System.out.println("Error: Planet " + planetName + " does not exist.");
            return;
        }

        if (planet.removeJedi(jediName)) {
            System.out.println("Successfully removed Jedi " + jediName + " from planet " + planetName);
        } else {
            System.out.println("Error: Jedi " + jediName + " does not exist on planet " + planetName);
        }
    }

    public void promoteJedi(String jediName, double multiplier) {
        for (Planet planet : planets.values()) {
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    if (jedi.promote()) {
                        System.out.println("Successfully promoted Jedi " + jediName);
                    } else {
                        System.out.println("Error: Jedi " + jediName + " is already at the highest rank.");
                    }
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " does not exist.");
    }

    public void demoteJedi(String jediName, double multiplier) {
        for (Planet planet : planets.values()) {
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    if (jedi.demote()) {
                        System.out.println("Successfully demoted Jedi " + jediName);
                    } else {
                        System.out.println("Error: Jedi " + jediName + " is already at the lowest rank.");
                    }
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " does not exist.");
    }

    public void getStrongestJedi(String planetName) {
        Planet planet = planets.get(planetName);
        if (planet == null) {
            System.out.println("Error: Planet " + planetName + " does not exist.");
            return;
        }

        Jedi strongestJedi = planet.getPopulation().stream()
                .max(Comparator.comparingDouble(Jedi::getStrength))
                .orElse(null);

        if (strongestJedi != null) {
            System.out.println("The strongest Jedi on " + planetName + " is " + strongestJedi.getJediName() + ", Strength: " + strongestJedi.getStrength());
        } else {
            System.out.println("Error: No Jedi found on planet " + planetName);
        }
    }

    public void getYoungestJedi(String planetName, String jediRank) {
        Planet planet = planets.get(planetName);
        if (planet == null) {
            System.out.println("Error: Planet " + planetName + " does not exist.");
            return;
        }

        Jedi youngestJedi = planet.getPopulation().stream()
                .filter(jedi -> jedi.getRank().toString().equalsIgnoreCase(jediRank))
                .min(Comparator.comparingInt(Jedi::getAge))
                .orElse(null);

        if (youngestJedi != null) {
            System.out.println("The youngest " + jediRank + " on " + planetName + " is " + youngestJedi.getJediName() + ", Age: " + youngestJedi.getAge());
        } else {
            System.out.println("Error: No Jedi of rank " + jediRank + " found on planet " + planetName);
        }
    }

    public void getMostUsedSaberColor(String planetName, Rank rank) {
        Map<String, Integer> colorCount = new HashMap<>();

        for (Planet planet : planets.values()) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                for (Jedi jedi : planet.getPopulation()) {
                    if (jedi.getRank() == rank) {
                        String saberColor = jedi.getLightsaberColor();
                        colorCount.put(saberColor, colorCount.getOrDefault(saberColor, 0) + 1);
                    }
                }
                break;
            }
        }

        String mostUsedColor = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostUsedColor = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        if (mostUsedColor != null) {
            System.out.println("Most used saber color for rank " + rank + " on planet " + planetName + ": " + mostUsedColor);
        } else {
            System.out.println("Error: No jedis with rank " + rank + " found on planet " + planetName + ".");
        }
    }

    public void getMostUsedSaberColor(String planetName) {
        Map<String, Integer> colorCount = new HashMap<>();
        boolean grandMasterExists = false;

        for (Planet planet : planets.values()) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                for (Jedi jedi : planet.getPopulation()) {
                    if (jedi.getRank() == Rank.GRAND_MASTER) {
                        grandMasterExists = true;
                    }
                    String saberColor = jedi.getLightsaberColor();
                    colorCount.put(saberColor, colorCount.getOrDefault(saberColor, 0) + 1);
                }
                break;
            }
        }

        if (grandMasterExists) {
            String mostUsedColor = null;
            int maxCount = 0;

            for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostUsedColor = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            if (mostUsedColor != null) {
                System.out.println("Most used saber color on planet " + planetName + ": " + mostUsedColor);
            } else {
                System.out.println("Error: No jedis found on planet " + planetName + ".");
            }
        } else {
            System.out.println("Error: No GRAND_MASTER found on planet " + planetName + ".");
        }
    }

    public void printPlanet(String planetName) {
        Planet planet = planets.get(planetName);
        if (planet == null) {
            System.out.println("Error: Planet " + planetName + " does not exist.");
            return;
        }

        System.out.println("Planet: " + planet.getName());
        List<Jedi> jediList = planet.getPopulation();
        jediList.sort(Comparator.comparing(Jedi::getRank).thenComparing(Jedi::getJediName));
        for (Jedi jedi : jediList) {
            System.out.println(jedi);
        }
    }

    public void printJedi(String jediName) {
        for (Planet planet : planets.values()) {
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    System.out.println("Jedi: " + jedi);
                    System.out.println("Planet: " + planet.getName());
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " does not exist.");
    }

    public void printTwoPlanets(String planetName1, String planetName2) {

        Planet planet1 = planets.get(planetName1);
        Planet planet2 = planets.get(planetName2);
        if (planet1 == null || planet2 == null) {
            System.out.println("Error: One or both planets do not exist.");
            return;
        }

        List<Jedi> combinedJediList = new ArrayList<>();
        combinedJediList.addAll(planet1.getPopulation());
        combinedJediList.addAll(planet2.getPopulation());

        combinedJediList.sort(Comparator.comparing(Jedi::getJediName));

        for (Jedi jedi : combinedJediList) {
            System.out.println(jedi);
        }
    }
}