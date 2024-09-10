import java.util.Map;

/**
 * The {@code PrintJedi} class implements {@code PrintInterface} to print details of a Jedi and the planet they belong to.
 */
public class PrintJedi implements PrintInterface {

    /**
     * Prints details of a Jedi and the planet they belong to based on the Jedi's name.
     *
     * @param fileOperations the {@code FileOperations} object containing the planets and jedis data
     * @param jediName       the name of the Jedi to print details for
     */
    @Override
    public void execute(FileOperations fileOperations, String jediName) {
        for (Map.Entry<String, Planet> entry : fileOperations.getPlanets().entrySet()) {
            Planet planet = entry.getValue();
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    System.out.println("Jedi: " + jedi);
                    System.out.println("Planet: " + planet.getName());
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " does not exist.");
    }
}