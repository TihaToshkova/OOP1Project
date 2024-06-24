import java.util.Comparator;

public class PrintPlanet implements PrintInterface{
    public void print(FileOperations fileOperations, String planetName) {
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
