package Jedi;

import Operations.FileOperations;

/**
 * The {@code Jedi.Jedi.CreateJediInterface} defines a method to create and add a Jedi.Jedi to a specified planet.
 */
public interface CreateJediInterface {

    /**
     * Creates a new Jedi.Jedi with the specified attributes and adds them to the specified planet managed by {@code Operations.FileOperations}.
     * <p>
     * If the specified planet does not exist in the collection managed by {@code Operations.FileOperations}, this method prints an error message
     * and does not create the Jedi.Jedi. Otherwise, it creates a new Jedi.Jedi object with the provided attributes (name, rank, age, saber color,
     * strength) and adds them to the planet's population.
     * </p>
     *
     * @param fileOperations the {@code Operations.FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet where the Jedi.Jedi will be added
     * @param jediName       the name of the Jedi.Jedi to be created
     * @param jediRank       the rank of the Jedi.Jedi (e.g., "MASTER", "KNIGHT")
     * @param jediAge        the age of the Jedi.Jedi
     * @param saberColor     the color of the Jedi.Jedi's lightsaber
     * @param jediStrength   the strength of the Jedi.Jedi
     * @throws NullPointerException if {@code fileOperations}, {@code planetName}, {@code jediName}, {@code jediRank}, or {@code saberColor} is null
     */
    void execute(FileOperations fileOperations, String planetName, String jediName,
                 String jediRank, int jediAge, String saberColor, int jediStrength);
}
