package Planet;

import Operations.FileOperations;

/**
 * The {@code Planet.Planet.AddPlanet} class provides a method to add a planet to a collection
 * of planets managed by {@code Operations.FileOperations}.
 * <p>
 * This class implements the {@code Planet.Planet.AddPlanetInterface} interface.
 * </p>
 */
public class AddPlanet implements AddPlanetInterface {
    /**
     * Adds a planet to the collection if it does not already exist.
     * <p>
     * This method checks if the specified planet name exists in the collection.
     * If the planet does not exist, it creates a new {@code Planet.Planet} object with the given name
     * and adds it to the collection. If the planet already exists, it prints a message indicating that
     * the planet already exists.
     * </p>
     *
     * @param fileOperations the {@code Operations.FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to be added
     * @throws NullPointerException if {@code fileOperations} or {@code planetName} is null
     */
    public void execute(FileOperations fileOperations, String planetName) {
        if (!fileOperations.getPlanets().containsKey(planetName)) {
            fileOperations.getPlanets().put(planetName, new Planet(planetName));
            System.out.println("Planet.Planet added: " + planetName);
        } else {
            System.out.println("Planet.Planet already exists: " + planetName);
        }
    }
}