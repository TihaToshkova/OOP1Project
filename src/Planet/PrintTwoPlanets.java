package Planet;

import Jedi.Jedi;
import Operations.FileOperations;

import java.util.*;

/**
 * The {@code Planet.PrintTwoPlanets} class implements {@code Planet.PrintTwoPlanetsInterface} to print details of jedis from two specified planets.
 */
public class PrintTwoPlanets implements PrintTwoPlanetsInterface {

    /**
     * Prints details of jedis from two specified planets, sorted by rank and then by Jedi.Jedi name.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data
     * @param planetName1    the name of the first planet to print details for
     * @param planetName2    the name of the second planet to print details for
     */
    @Override
    public void execute(FileOperations fileOperations, String planetName1, String planetName2) {
        Planet planet1 = fileOperations.getPlanets().get(planetName1);
        Planet planet2 = fileOperations.getPlanets().get(planetName2);

        if (planet1 == null) {
            System.out.println("Error: Planet.Planet " + planetName1 + " not found.");
            return;
        }
        if (planet2 == null) {
            System.out.println("Error: Planet.Planet " + planetName2 + " not found.");
            return;
        }

        List<Jedi> combinedJedis = new ArrayList<>();
        combinedJedis.addAll(planet1.getPopulation());
        combinedJedis.addAll(planet2.getPopulation());

        // Sorting combined jedis by rank and then by Jedi.Jedi name
        Collections.sort(combinedJedis, new Comparator<Jedi>() {
            @Override
            public int compare(Jedi j1, Jedi j2) {
                int rankComparison = j1.getRank().compareTo(j2.getRank());
                if (rankComparison != 0) {
                    return rankComparison;
                }
                return j1.getJediName().compareTo(j2.getJediName());
            }
        });

        // Printing sorted jedis
        for (Jedi jedi : combinedJedis) {
            System.out.println(jedi);
        }
    }
}
