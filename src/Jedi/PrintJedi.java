package Jedi;

import Operations.FileOperations;
import Operations.PrintInterface;
import Planet.Planet;

import java.util.Map;

/**
 * The {@code Jedi.PrintJedi} class implements {@code Operations.PrintInterface} to print details of a Jedi.Jedi and the planet they belong to.
 */
public class PrintJedi implements PrintInterface {

    /**
     * Prints details of a Jedi.Jedi and the planet they belong to based on the Jedi.Jedi's name.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data
     * @param jediName       the name of the Jedi.Jedi to print details for
     */
    @Override
    public void execute(FileOperations fileOperations, String jediName) {
        for (Map.Entry<String, Planet> entry : fileOperations.getPlanets().entrySet()) {
            Planet planet = entry.getValue();
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    System.out.println("Jedi.Jedi: " + jedi);
                    System.out.println("Planet.Planet: " + planet.getName());
                    return;
                }
            }
        }
        System.out.println("Error: Jedi.Jedi " + jediName + " does not exist.");
    }
}