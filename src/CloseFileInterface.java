/**
 * The {@code CloseFileInterface} defines a method to close a file and clear associated data.
 */
public interface CloseFileInterface {

    /**
     * Closes the currently open file and clears associated data managed by {@code FileOperations}.
     * <p>
     * If no file is currently open (i.e., {@code fileName} is {@code null}), this method prints a message
     * indicating that no file is open and does nothing else. Otherwise, it sets {@code fileName} to {@code null}
     * and clears the collection of planets and their jedis.
     * </p>
     *
     * @param fileOperations the {@code FileOperations} object that manages the file and associated data
     * @throws NullPointerException if {@code fileOperations} is null
     */
    void execute(FileOperations fileOperations);
}
