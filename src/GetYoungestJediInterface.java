/**
 * The {@code GetYoungestJediInterface} defines a method to find and print the youngest Jedi of a specified rank on a given planet.
 */
public interface GetYoungestJediInterface {

    /**
     * Finds and prints the youngest Jedi of a specified rank on a given planet managed by {@code FileOperations}.
     * <p>
     * This method searches for jedis with the specified rank on the given planet and finds the youngest one.
     * If the planet is not found in the collection managed by {@code FileOperations}, or if there are no jedis
     * with the specified rank on the planet, it prints an error message.
     * </p>
     *
     * @param fileOperations the {@code FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to search
     * @param jediRank       the rank of the jedis to filter by (e.g., "MASTER", "KNIGHT")
     * @throws NullPointerException if {@code fileOperations}, {@code planetName}, or {@code jediRank} is null
     */
    void execute(FileOperations fileOperations, String planetName, String jediRank);
}
