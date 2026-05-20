package Jedi;

import Operations.FileOperations;
import Planet.Planet;

/**
 * The {@code Jedi.Jedi.CreateJedi} class provides a method to create a Jedi.Jedi and add it to a specified planet
 * managed by {@code Operations.FileOperations}.
 * <p>
 * This class implements the {@code Jedi.Jedi.CreateJediInterface} interface.
 * </p>
 */
public class CreateJedi implements CreateJediInterface {

    /**
     * Creates a Jedi.Jedi and adds it to the specified planet.
     * <p>
     * This method checks if the specified planet exists in the collection managed by the {@code Operations.FileOperations} object.
     * If the planet does not exist, it prints an error message and returns. If the planet exists, it creates a new {@code Jedi.Jedi}
     * object with the provided details and adds it to the planet's collection of jedis. Finally, it prints a success message.
     * </p>
     *
     * @param fileOperations the {@code Operations.FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to which the Jedi.Jedi will be added
     * @param jediName       the name of the Jedi.Jedi to be created
     * @param jediRank       the rank of the Jedi.Jedi to be created
     * @param jediAge        the age of the Jedi.Jedi to be created
     * @param saberColor     the color of the Jedi.Jedi's lightsaber
     * @param jediStrength   the strength of the Jedi.Jedi to be created
     * @throws NullPointerException     if {@code fileOperations}, {@code planetName}, {@code jediName}, {@code jediRank}, or {@code saberColor} is null
     * @throws IllegalArgumentException if {@code jediRank} is not a valid rank
     */
    public void execute(FileOperations fileOperations, String planetName, String jediName,
                        String jediRank, int jediAge, String saberColor, int jediStrength) {

        if (!fileOperations.getPlanets().containsKey(planetName)) {
            System.out.println("Error: Planet.Planet not found - " + planetName);
            return;
        }

        Jedi jedi = new Jedi(jediName, Rank.valueOf(jediRank.toUpperCase()), jediAge, saberColor, jediStrength);

        Planet planet = fileOperations.getPlanets().get(planetName);
        planet.addJedi(jedi);

        System.out.println("Successfully added Jedi.Jedi " + jediName + " to planet " + planetName);

    }
}