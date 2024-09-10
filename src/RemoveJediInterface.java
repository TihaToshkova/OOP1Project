/**
 * The {@code RemoveJediInterface} interface defines a method to remove a Jedi from a planet.
 */
public interface RemoveJediInterface {

    /**
     * Removes a Jedi identified by {@code jediName} from the specified {@code planetName}.
     *
     * @param fileOperations the {@code FileOperations} object containing the planets and jedis data
     * @param jediName       the name of the Jedi to remove
     * @param planetName     the name of the planet from which to remove the Jedi
     */
    void execute(FileOperations fileOperations, String jediName, String planetName);
}
