package Operations;

/**
 * The {@code Operations.CloseFile} class provides a method to close a file managed by {@code Operations.FileOperations}.
 * <p>
 * This class implements the {@code Operations.CloseFileInterface} interface.
 * </p>
 */
public class CloseFile implements CloseFileInterface {
    /**
     * Closes the currently open file in the {@code Operations.FileOperations} object.
     * <p>
     * This method checks if there is a currently open file by examining the file name.
     * If no file is open, it prints a message indicating that no file is currently open.
     * If a file is open, it sets the file name to {@code null} and clears the collections
     * of planets and jedis managed by the {@code Operations.FileOperations} object, then prints a
     * message indicating that the file has been closed.
     * </p>
     *
     * @param fileOperations the {@code Operations.FileOperations} object that manages the file and collections
     * @throws NullPointerException if {@code fileOperations} is null
     */
    public void execute(FileOperations fileOperations) {
        if (fileOperations.getFileName() == null) {
            System.out.println("No file is currently open.");
        } else {
            fileOperations.setFileName(null);
            fileOperations.clearPlanetsAndJedis();
            System.out.println("File closed.");
        }
    }
}