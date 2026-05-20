package Operations;

import java.util.Scanner;

/**
 * The {@code Operations.OpenFileInterface} defines a method to open and process a file containing planet and Jedi.Jedi data.
 */
public interface OpenFileInterface {

    /**
     * Opens the specified file, reads its contents, and initializes planets and jedis in {@code Operations.FileOperations}.
     *
     * @param fileOperations the {@code Operations.FileOperations} object to manage planets and jedis
     * @param scanner        the {@code Scanner} object to read user input
     * @throws NullPointerException if {@code fileOperations} or {@code scanner} is null
     */
    void execute(FileOperations fileOperations, Scanner scanner);
}
