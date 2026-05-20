package Jedi;

import Operations.FileOperations;
import Planet.Planet;

import java.util.Map;

/**
 * The {@code Jedi.PromoteJedi} class implements {@code Jedi.PromoteJediInterface} to promote a Jedi.Jedi to a higher rank.
 */
public class PromoteJedi implements PromoteJediInterface {

    /**
     * Promotes a Jedi.Jedi identified by {@code jediName} to a higher rank.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data
     * @param jediName       the name of the Jedi.Jedi to promote
     * @param multiplier     the multiplier factor for promotion (not used in current implementation)
     */
    @Override
    public void execute(FileOperations fileOperations, String jediName, double multiplier) {
        for (Map.Entry<String, Planet> entry : fileOperations.getPlanets().entrySet()) {
            for (Jedi jedi : entry.getValue().getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    if (jedi.promote()) {
                        System.out.println("Successfully promoted Jedi.Jedi " + jediName);
                    } else {
                        System.out.println("Error: Jedi.Jedi " + jediName + " is already at the highest rank.");
                    }
                    return;
                }
            }
        }
        System.out.println("Error: Jedi.Jedi " + jediName + " does not exist.");
    }
}
