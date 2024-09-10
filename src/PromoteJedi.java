import java.util.Map;

/**
 * The {@code PromoteJedi} class implements {@code PromoteJediInterface} to promote a Jedi to a higher rank.
 */
public class PromoteJedi implements PromoteJediInterface {

    /**
     * Promotes a Jedi identified by {@code jediName} to a higher rank.
     *
     * @param fileOperations the {@code FileOperations} object containing the planets and jedis data
     * @param jediName       the name of the Jedi to promote
     * @param multiplier     the multiplier factor for promotion (not used in current implementation)
     */
    @Override
    public void execute(FileOperations fileOperations, String jediName, double multiplier) {
        for (Map.Entry<String, Planet> entry : fileOperations.getPlanets().entrySet()) {
            for (Jedi jedi : entry.getValue().getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    if (jedi.promote()) {
                        System.out.println("Successfully promoted Jedi " + jediName);
                    } else {
                        System.out.println("Error: Jedi " + jediName + " is already at the highest rank.");
                    }
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " does not exist.");
    }
}
