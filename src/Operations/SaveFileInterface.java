package Operations;

import java.io.IOException;

/**
 * The {@code Operations.SaveFileInterface} interface defines a contract for classes that provide functionality to save the current state of planets and jedis to a file.
 */
public interface SaveFileInterface {

    /**
     * Saves the current state of planets and jedis from {@code fileOperations} to a file.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the planets and jedis data to save
     * @throws IOException if an I/O error occurs during file saving
     */
    void execute(FileOperations fileOperations) throws IOException;
}
