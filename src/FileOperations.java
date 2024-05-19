import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileOperations implements FileOperationsInterface{
    private String fileName;
    private String content;
    private List<Planet> planets;

    public FileOperations(){
        this.planets = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void open(Scanner scanner)
    {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine().trim();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
                content = "";
                System.out.println("File created successfully.");
            } else {
                StringBuilder sb = new StringBuilder();
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine()).append("\n");
                }
                scanner.close();
                content = sb.toString();
            }
            this.fileName = fileName;
            System.out.println("Successfully opened " + fileName);
        } catch (IOException e) {
            System.out.println("Error: Could not open file.");
            System.exit(1);
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
        if (fileName != null) {
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(content);
                System.out.println("Successfully saved " + fileName);
            } catch (IOException e) {
                System.out.println("Error: Could not save changes to file.");
            }
        } else {
            System.out.println("Error: No file is currently open.");
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
        System.out.println("saveas <file>     - saves the currently open file in <file>");
        System.out.println("help              - prints this information");
        System.out.println("exit              - exits the program");
        System.out.println("addplanet <name>  - adds a new planet");
        System.out.println("create_jedi <planet_name> <jedi_name> <rank> <age> <saber_color> <strength>");
        System.out.println("                  - creates a new jedi on a planet");
        System.out.println("removejedi <jedi_name> <planet_name>");
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
        planets.add(new Planet(planetName));
        System.out.println("Successfully added planet: " + planetName);
    }

    public void createJedi(String planetName, String jediName, String jediRank, int jediAge, String saberColor, double jediStrength) {
        for (Planet planet : planets) {
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    System.out.println("Error: A Jedi with the name " + jediName + " already exists on planet " + planet.getName());
                    return;
                }
            }
        }

        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                Rank rank;
                try {
                    rank = Rank.valueOf(jediRank.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: Invalid Jedi rank.");
                    return;
                }

                Jedi newJedi = new Jedi(jediName, rank, jediAge, saberColor, jediStrength);
                planet.addJedi(newJedi);
                System.out.println("Successfully added Jedi " + jediName + " to planet " + planetName);
                return;
            }
        }

        System.out.println("Error: No planet with the name " + planetName + " found.");
    }

    public void removeJedi(String jediName, String planetName) {
        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                boolean removed = planet.removeJedi(jediName);
                if (removed) {
                    System.out.println("Successfully removed Jedi " + jediName + " from planet " + planetName);
                } else {
                    System.out.println("Error: Jedi " + jediName + " does not inhabit planet " + planetName);
                }
                return;
            }
        }
        System.out.println("Error: Planet " + planetName + " not found.");
    }

    public void promoteJedi(String jediName, double multiplier) {
        for (Planet planet : planets) {
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    Rank currentRank = jedi.getRank();
                    int currentRankIndex = currentRank.ordinal();
                    int nextRankIndex = Math.min(currentRankIndex + 1, Rank.values().length - 1);
                    Rank nextRank = Rank.values()[nextRankIndex];

                    double currentStrength = jedi.getStrength();
                    double newStrength = currentStrength + (multiplier * currentStrength);

                    jedi.setRank(nextRank);
                    jedi.setStrength(newStrength);

                    System.out.println("Successfully promoted Jedi " + jediName + " to " + nextRank + " and increased strength to " + newStrength);
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " not found.");
    }

    public void demoteJedi(String jediName, double multiplier) {
        for (Planet planet : planets) {
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    Rank currentRank = jedi.getRank();
                    int currentRankIndex = currentRank.ordinal();
                    int nextRankIndex = Math.max(currentRankIndex - 1, 0);
                    Rank nextRank = Rank.values()[nextRankIndex];

                    double currentStrength = jedi.getStrength();
                    double newStrength = currentStrength - (multiplier * currentStrength);

                    jedi.setRank(nextRank);
                    jedi.setStrength(newStrength);

                    System.out.println("Successfully demoted Jedi " + jediName + " to " + nextRank + " and decreased strength to " + newStrength);
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " not found.");
    }

    public void getStrongestJedi(String planetName) {
        Jedi strongestJedi = null;
        double maxStrength = Double.MIN_VALUE;

        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                for (Jedi jedi : planet.getPopulation()) {
                    if (jedi.getStrength() > maxStrength) {
                        maxStrength = jedi.getStrength();
                        strongestJedi = jedi;
                    }
                }
                break;
            }
        }

        if (strongestJedi != null) {
            System.out.println("Strongest Jedi on planet " + planetName + ":");
            System.out.println("Name: " + strongestJedi.getJediName());
            System.out.println("Rank: " + strongestJedi.getRank());
            System.out.println("Age: " + strongestJedi.getAge());
            System.out.println("Saber Color: " + strongestJedi.getLightsaberColor());
            System.out.println("Strength: " + strongestJedi.getStrength());
        } else {
            System.out.println("Error: Planet " + planetName + " not found or no jedis inhabit it.");
        }
    }

    public void getYoungestJedi(String planetName, Rank rank) {
        Jedi youngestJedi = null;
        int minAge = Integer.MAX_VALUE;

        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                for (Jedi jedi : planet.getPopulation()) {
                    if (jedi.getRank() == rank && jedi.getAge() < minAge) {
                        minAge = jedi.getAge();
                        youngestJedi = jedi;
                    }
                }
                break;
            }
        }

        if (youngestJedi != null) {
            System.out.println("Youngest Jedi with rank " + rank + " on planet " + planetName + ":");
            System.out.println("Name: " + youngestJedi.getJediName());
            System.out.println("Age: " + youngestJedi.getAge());
            System.out.println("Saber Color: " + youngestJedi.getLightsaberColor());
            System.out.println("Strength: " + youngestJedi.getStrength());
        } else {
            System.out.println("Error: No Jedi with rank " + rank + " found on planet " + planetName + ".");
        }
    }

    public void getMostUsedSaberColor(String planetName, Rank rank) {
        Map<String, Integer> colorCount = new HashMap<>();

        for (Planet planet : planets) {
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

        for (Planet planet : planets) {
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
        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                System.out.println("Planet: " + planet.getName());
                System.out.println("Jedis:");

                Collections.sort(planet.getPopulation(), Comparator.comparing(Jedi::getRank).thenComparing(Jedi::getJediName));

                for (Jedi jedi : planet.getPopulation()) {
                    System.out.println("  Name: " + jedi.getJediName());
                    System.out.println("  Rank: " + jedi.getRank());
                    System.out.println("  Age: " + jedi.getAge());
                    System.out.println("  Saber Color: " + jedi.getLightsaberColor());
                    System.out.println("  Strength: " + jedi.getStrength());
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Error: Planet " + planetName + " not found.");
    }

    public void printJedi(String jediName) {
        for (Planet planet : planets) {
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    System.out.println("Jedi Name: " + jedi.getJediName());
                    System.out.println("Planet: " + planet.getName());
                    System.out.println("Rank: " + jedi.getRank());
                    System.out.println("Age: " + jedi.getAge());
                    System.out.println("Saber Color: " + jedi.getLightsaberColor());
                    System.out.println("Strength: " + jedi.getStrength());
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " not found.");
    }

    public void printTwoPlanets(String planet1Name, String planet2Name) {
        List<Jedi> allJedis = new ArrayList<>();

        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(planet1Name)) {
                allJedis.addAll(planet.getPopulation());
                break;
            }
        }

        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(planet2Name)) {
                allJedis.addAll(planet.getPopulation());
                break;
            }
        }

        Collections.sort(allJedis, Comparator.comparing(Jedi::getRank).thenComparing(jedi -> {
            for (Planet planet : planets) {
                if (planet.getPopulation().contains(jedi)) {
                    return planet.getName();
                }
            }
            return "";
        }));

        for (Jedi jedi : allJedis) {
            System.out.println("Jedi Name: " + jedi.getJediName());
            System.out.println("Planet: " + getJediPlanet(jedi));
            System.out.println("Rank: " + jedi.getRank());
            System.out.println("Age: " + jedi.getAge());
            System.out.println("Saber Color: " + jedi.getLightsaberColor());
            System.out.println("Strength: " + jedi.getStrength());
            System.out.println();
        }
    }

    private String getJediPlanet(Jedi jedi) {
        for (Planet planet : planets) {
            if (planet.getPopulation().contains(jedi)) {
                return planet.getName();
            }
        }
        return "Unknown";
    }
}