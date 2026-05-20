package Planet;

import Jedi.Jedi;
import Operations.FileOperations;
import Operations.PrintInterface;

import java.util.Comparator;

/**
 * The {@code Planet.PrintPlanet} class implements {@code Operations.PrintInterface} to print details of jedis inhabiting a specific planet.
 */
public class PrintPlanet implements PrintInterface {

    /**
     * Prints details of jedis inhabiting a specific planet, sorted by rank and then by Jedi.Jedi name.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data
     * @param planetName     the name of the planet to print details for
     */
    @Override
    public void execute(FileOperations fileOperations, String planetName) {
        Planet planet = fileOperations.getPlanets().get(planetName);
        if (planet != null) {
            System.out.println("Planet.Planet: " + planet.getName());
            System.out.println("Jedi.Jedi inhabitants:");
            planet.getPopulation().stream()
                    .sorted(Comparator.comparing(Jedi::getRank).thenComparing(Jedi::getJediName))
                    .forEach(jedi -> System.out.println(jedi.getJediName() + " - " + jedi.getRank()));
        } else {
            System.out.println("Planet.Planet not found: " + planetName);
        }
    }
}
