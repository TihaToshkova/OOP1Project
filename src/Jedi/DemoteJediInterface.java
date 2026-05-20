package Jedi;

import Operations.FileOperations;

/**
 * The {@code Jedi.Jedi.DemoteJediInterface} defines a method to demote a Jedi.Jedi by applying a multiplier to their strength.
 */
public interface DemoteJediInterface {

    /**
     * Demotes a Jedi.Jedi by applying a multiplier to their strength.
     * <p>
     * This method searches for the Jedi.Jedi with the specified name across all planets managed by {@code Operations.FileOperations}.
     * If found, it attempts to demote the Jedi.Jedi by multiplying their current strength by the given multiplier.
     * If the multiplier is less than or equal to 0, this method prints an error message and does not demote the Jedi.Jedi.
     * </p>
     *
     * @param fileOperations the {@code Operations.FileOperations} object that manages the collection of planets and jedis
     * @param jediName       the name of the Jedi.Jedi to be demoted
     * @param multiplier     the multiplier to adjust the Jedi.Jedi's strength (must be greater than 0)
     * @throws NullPointerException if {@code fileOperations} or {@code jediName} is null
     */
    void execute(FileOperations fileOperations, String jediName, double multiplier);
}
