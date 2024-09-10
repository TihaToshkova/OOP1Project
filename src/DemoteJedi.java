/**
 * The {@code DemoteJedi} class provides a method to demote a Jedi managed by {@code FileOperations}.
 * <p>
 * This class implements the {@code DemoteJediInterface} interface.
 * </p>
 */
public class DemoteJedi implements DemoteJediInterface{
    /**
     * Demotes a Jedi by decreasing their rank and prints the result of the operation.
     * <p>
     * This method checks if the provided multiplier is a positive number. If not, it prints an error message
     * and returns. It then searches for the Jedi by name across all planets managed by the {@code FileOperations}
     * object. If the Jedi is found, it attempts to demote them using the Jedi's {@code demote} method and prints
     * a success or failure message. If the Jedi is not found, it prints an error message.
     * </p>
     *
     * @param fileOperations the {@code FileOperations} object that manages the collection of planets and jedis
     * @param jediName       the name of the Jedi to be demoted
     * @param multiplier     the multiplier to be used in the demotion process (must be a positive number)
     * @throws NullPointerException     if {@code fileOperations} or {@code jediName} is null
     */
    public void execute(FileOperations fileOperations,String jediName, double multiplier) {
        if (multiplier <= 0) {
            System.out.println("Error: Multiplier must be a positive number.");
            return;
        }

        for (Planet planet : fileOperations.getPlanets().values()) {
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equals(jediName)) {
                    if (jedi.demote()) {
                        System.out.println("Jedi " + jediName + " demoted successfully.");
                    } else {
                        System.out.println("Error: Could not demote Jedi " + jediName + ".");
                    }
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " not found on any planet.");
    }
}