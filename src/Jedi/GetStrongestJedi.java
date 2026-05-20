package Jedi;

import Operations.FileOperations;
import Planet.Planet;

import java.util.List;

/**
 * The {@code Jedi.Jedi.GetStrongestJedi} class provides a method to find the strongest Jedi.Jedi on a specified planet
 * managed by {@code Operations.FileOperations}.
 * <p>
 * This class implements the {@code Jedi.Jedi.GetStrongestJediInterface} interface.
 * </p>
 */
public class GetStrongestJedi implements GetStrongestJediInterface {

    /**
     * Finds and prints the strongest Jedi.Jedi on a given planet.
     * <p>
     * This method searches for the Jedi.Jedi with the highest strength on the specified planet. If the planet
     * is not found, or if there are no jedis on the planet, it prints an appropriate error message. Otherwise,
     * it prints the name and strength of the strongest Jedi.Jedi.
     * </p>
     *
     * @param fileOperations the {@code Operations.FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to search
     * @throws NullPointerException if {@code fileOperations} or {@code planetName} is null
     */
    public void execute(FileOperations fileOperations, String planetName) {
        Planet planet = fileOperations.getPlanets().get(planetName);

        if (planet == null) {
            System.out.println("Error: Planet.Planet " + planetName + " not found.");
            return;
        }

        List<Jedi> jedis = planet.getPopulation();
        if (jedis.isEmpty()) {
            System.out.println("Error: No jedis found on planet " + planetName + ".");
            return;
        }

        Jedi strongestJedi = jedis.get(0);
        for (Jedi jedi : jedis) {
            if (jedi.getStrength() > strongestJedi.getStrength()) {
                strongestJedi = jedi;
            }
        }

        System.out.println("The strongest Jedi.Jedi on planet " + planetName + " is " +
                strongestJedi.getJediName() + " with strength " + strongestJedi.getStrength() + ".");
    }
}
