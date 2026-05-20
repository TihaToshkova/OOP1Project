package Planet;

import Operations.FileOperations;

/**
 * The {@code Planet.Planet.AddPlanetInterface} defines a method to add a planet to the collection managed by {@code Operations.FileOperations}.
 */
public interface AddPlanetInterface {

    /**
     * Adds a planet to the collection managed by {@code Operations.FileOperations}.
     * <p>
     * If the planet already exists in the collection, this method does nothing.
     * </p>
     *
     * @param fileOperations the {@code Operations.FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to be added
     * @throws NullPointerException if {@code fileOperations} or {@code planetName} is null
     */
    void execute(FileOperations fileOperations, String planetName);
}
