/**
 * The {@code GetMostUsedSaberInterface} defines methods to find the most used saber color among jedis on a specified planet.
 */
public interface GetMostUsedSaberInterface {

    /**
     * Finds and prints the most used saber color for jedis of a specified rank on a given planet.
     * <p>
     * This method searches for jedis with the specified rank on the given planet and counts the usage
     * of each saber color. It then prints the color that is used the most.
     * </p>
     *
     * @param fileOperations the {@code FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to search
     * @param rank           the rank of the jedis to filter by
     * @throws NullPointerException if {@code fileOperations}, {@code planetName}, or {@code rank} is null
     */
    void getMostUsedSaberColor(FileOperations fileOperations, String planetName, String rank);

    /**
     * Finds and prints the most used saber color among GRAND_MASTER jedis on a given planet.
     * <p>
     * This method searches for jedis with the rank of GRAND_MASTER on the given planet and counts the usage
     * of each saber color. It then prints the color that is used the most by GRAND_MASTER jedis.
     * </p>
     *
     * @param fileOperations the {@code FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to search
     * @throws NullPointerException if {@code fileOperations} or {@code planetName} is null
     */
    void getMostUsedSaberColor(FileOperations fileOperations, String planetName);
}
