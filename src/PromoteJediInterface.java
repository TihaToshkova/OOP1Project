/**
 * The {@code PromoteJediInterface} interface defines a method to promote a Jedi to a higher rank.
 */
public interface PromoteJediInterface {

    /**
     * Promotes a Jedi identified by {@code jediName} to a higher rank.
     *
     * @param fileOperations the {@code FileOperations} object containing the planets and jedis data
     * @param jediName       the name of the Jedi to promote
     * @param multiplier     the multiplier factor for promotion (not used in the interface)
     */
    void execute(FileOperations fileOperations, String jediName, double multiplier);
}
