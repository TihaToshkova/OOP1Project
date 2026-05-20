package Operations;

/**
 * The {@code Operations.PrintInterface} defines a method to print information based on specified criteria.
 */
public interface PrintInterface {

    /**
     * Prints information based on the specified criteria.
     *
     * @param fileOperations the {@code Operations.FileOperations} object containing the data to print
     * @param printByName    the name or identifier used to determine what information to print
     */
    void execute(FileOperations fileOperations, String printByName);
}
