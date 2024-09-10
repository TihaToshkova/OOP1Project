/**
 * The {@code PrintTwoPlanetsInterface} interface defines a method to print details of jedis from two specified planets.
 */
public interface PrintTwoPlanetsInterface {

    /**
     * Prints details of jedis from two specified planets.
     *
     * @param fileOperations the {@code FileOperations} object containing the planets and jedis data
     * @param planet1Name    the name of the first planet to print details for
     * @param planet2Name    the name of the second planet to print details for
     */
    void execute(FileOperations fileOperations, String planet1Name, String planet2Name);
}
