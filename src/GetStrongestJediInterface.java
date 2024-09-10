/**
 * The {@code GetStrongestJediInterface} defines a method to find and print the strongest Jedi on a specified planet.
 */
public interface GetStrongestJediInterface {

    /**
     * Finds and prints the strongest Jedi on a specified planet managed by {@code FileOperations}.
     * <p>
     * This method searches for the Jedi with the highest strength on the specified planet.
     * If the planet is not found in the collection managed by {@code FileOperations}, or if there are no jedis
     * on the planet, it prints an error message.
     * </p>
     *
     * @param fileOperations the {@code FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to search
     * @throws NullPointerException if {@code fileOperations} or {@code planetName} is null
     */
    void execute(FileOperations fileOperations, String planetName);
}