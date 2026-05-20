package Jedi;

import Operations.FileOperations;

/**
 * The {@code Jedi.PromoteJediInterface} interface defines a method to promote a Jedi.Jedi to a higher rank.
 */
public interface PromoteJediInterface {

    /**
     * Promotes a Jedi.Jedi identified by {@code jediName} to a higher rank.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data
     * @param jediName       the name of the Jedi.Jedi to promote
     * @param multiplier     the multiplier factor for promotion (not used in the interface)
     */
    void execute(FileOperations fileOperations, String jediName, double multiplier);
}
