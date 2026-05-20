package Jedi;

import Operations.FileOperations;

/**
 * The {@code Jedi.RemoveJediInterface} interface defines a method to remove a Jedi.Jedi from a planet.
 */
public interface RemoveJediInterface {

    /**
     * Removes a Jedi.Jedi identified by {@code jediName} from the specified {@code planetName}.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data
     * @param jediName       the name of the Jedi.Jedi to remove
     * @param planetName     the name of the planet from which to remove the Jedi.Jedi
     */
    void execute(FileOperations fileOperations, String jediName, String planetName);
}
