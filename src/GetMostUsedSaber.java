import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;

public class GetMostUsedSaber implements GetMostUsedSaberInterface{
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
