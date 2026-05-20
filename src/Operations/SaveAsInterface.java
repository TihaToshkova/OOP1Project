package Operations;

/**
 * The {@code Operations.SaveAsInterface} interface defines a method to save the current state of planets and jedis to a new file.
 */
public interface SaveAsInterface {

    /**
     * Saves the current state of planets and jedis from {@code fileOperations} to a new file specified by {@code newFileName}.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data to save
     * @param newFileName    the name of the new file to save as
     */
    void execute(FileOperations fileOperations, String newFileName);
}
