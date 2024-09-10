import java.util.Comparator;

/**
 * The {@code PrintPlanet} class implements {@code PrintInterface} to print details of jedis inhabiting a specific planet.
 */
public class PrintPlanet implements PrintInterface {

    /**
     * Prints details of jedis inhabiting a specific planet, sorted by rank and then by Jedi name.
     *
     * @param fileOperations the {@code FileOperations} object containing the planets and jedis data
     * @param planetName     the name of the planet to print details for
     */
    @Override
    public void execute(FileOperations fileOperations, String planetName) {
        Planet planet = fileOperations.getPlanets().get(planetName);
        if (planet != null) {
            System.out.println("Planet: " + planet.getName());
            System.out.println("Jedi inhabitants:");
            planet.getPopulation().stream()
                    .sorted(Comparator.comparing(Jedi::getRank).thenComparing(Jedi::getJediName))
                    .forEach(jedi -> System.out.println(jedi.getJediName() + " - " + jedi.getRank()));
        } else {
            System.out.println("Planet not found: " + planetName);
        }
    }
}
