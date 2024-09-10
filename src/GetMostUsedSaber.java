import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;

/**
 * The {@code GetMostUsedSaber} class provides methods to find the most used saber color among jedis on a specified planet.
 * <p>
 * This class implements the {@code GetMostUsedSaberInterface} interface.
 * </p>
 */
public class GetMostUsedSaber implements GetMostUsedSaberInterface{

    /**
     * Finds and prints the most used saber color for jedis of a specified rank on a given planet.
     * <p>
     * This method searches for jedis with the specified rank on the given planet and counts the usage
     * of each saber color. It then prints the color that is used the most.
     * </p>
     *
     * @param fileOperations the {@code FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to search
     * @param rank           the rank of the jedis to filter by
     * @throws NullPointerException if {@code fileOperations}, {@code planetName}, or {@code rank} is null
     */
    public void getMostUsedSaberColor(FileOperations fileOperations,String planetName, String rank) {
        Planet planet = fileOperations.getPlanets().get(planetName);

        if (planet == null) {
            System.out.println("Error: Planet " + planetName + " not found.");
            return;
        }

        List<Jedi> jedis = planet.getPopulation();
        if (jedis.isEmpty()) {
            System.out.println("Error: No jedis found on planet " + planetName + ".");
            return;
        }

        Map<String, Integer> colorCount = new HashMap<>();
        for (Jedi jedi : jedis) {
            if(jedi.getRank().equals(rank)){
                String color = jedi.getLightSaberColor();
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            }
        }

        if (colorCount.isEmpty()) {
            System.out.println("Error: No jedis with rank " + rank + " found on planet " + planetName + ".");
            return;
        }

        String mostUsedColor = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostUsedColor = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        System.out.println("The most used saber color for rank " + rank + " on planet " + planetName + " is " + mostUsedColor + ".");
    }


    /**
     * Finds and prints the most used saber color among GRAND_MASTER jedis on a given planet.
     * <p>
     * This method searches for jedis with the rank of GRAND_MASTER on the given planet and counts the usage
     * of each saber color. It then prints the color that is used the most by GRAND_MASTER jedis.
     * </p>
     *
     * @param fileOperations the {@code FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to search
     * @throws NullPointerException if {@code fileOperations} or {@code planetName} is null
     */
    public void getMostUsedSaberColor(FileOperations fileOperations,String planetName) {
        Planet planet = fileOperations.getPlanets().get(planetName);

        if (planet == null) {
            System.out.println("Error: Planet " + planetName + " not found.");
            return;
        }

        List<Jedi> jedis = planet.getPopulation();
        if (jedis.isEmpty()) {
            System.out.println("Error: No jedis found on planet " + planetName + ".");
            return;
        }

        Map<String, Integer> colorCount = new HashMap<>();
        boolean hasGrandMaster = false;

        for (Jedi jedi : jedis) {
            if (jedi.getRank().equals(Rank.GRAND_MASTER.name())) {
                hasGrandMaster = true;
                String color = jedi.getLightSaberColor();
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            }
        }

        if (!hasGrandMaster) {
            System.out.println("Error: No GRAND_MASTER jedis found on planet " + planetName + ".");
            return;
        }

        String mostUsedColor = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostUsedColor = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        System.out.println("The most used saber color by GRAND_MASTER jedis on planet " + planetName + " is " + mostUsedColor + ".");
    }
}