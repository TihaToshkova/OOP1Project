/**
 * The {@code RemoveJedi} class implements {@code RemoveJediInterface} to remove a Jedi from a planet.
 */
public class RemoveJedi implements RemoveJediInterface {

    /**
     * Removes a Jedi identified by {@code jediName} from the specified {@code planetName}.
     *
     * @param fileOperations the {@code FileOperations} object containing the planets and jedis data
     * @param jediName       the name of the Jedi to remove
     * @param planetName     the name of the planet from which to remove the Jedi
     */
    @Override
    public void execute(FileOperations fileOperations, String jediName, String planetName) {
        if (!fileOperations.getPlanets().containsKey(planetName)) {
            System.out.println("Error: Planet not found - " + planetName);
            return;
        }

        Planet planet = fileOperations.getPlanets().get(planetName);

        if (planet.removeJedi(jediName)) {
            System.out.println("Jedi successfully removed from planet " + planetName + ": " + jediName);
        } else {
            System.out.println("Error: Jedi not found on planet " + planetName + ": " + jediName);
        }
    }
}
