import java.util.*;
import java.util.stream.Collectors;

/**
 * The {@code GetYoungestJedi} class provides a method to find the youngest Jedi of a specified rank on a given planet
 * managed by {@code FileOperations}.
 * <p>
 * This class implements the {@code GetYoungestJediInterface} interface.
 * </p>
 */
public class GetYoungestJedi implements GetYoungestJediInterface{

    /**
     * Finds and prints the youngest Jedi of a specified rank on a given planet.
     * <p>
     * This method filters the jedis on the specified planet by the given rank and finds the youngest one.
     * If the planet is not found, or if there are no jedis with the specified rank on the planet, it prints
     * an appropriate error message. Otherwise, it prints the name and age of the youngest Jedi with the specified rank.
     * </p>
     *
     * @param fileOperations the {@code FileOperations} object that manages the collection of planets
     * @param planetName     the name of the planet to search
     * @param jediRank       the rank of the jedis to filter by
     * @throws NullPointerException if {@code fileOperations}, {@code planetName}, or {@code jediRank} is null
     */
   public void execute(FileOperations fileOperations,String planetName, String jediRank) {

       Planet planet = fileOperations.getPlanets().get(planetName);

       if (planet == null) {
           System.out.println("Error: Planet " + planetName + " not found.");
           return;
       }

       List<Jedi> jedis = planet.getPopulation().stream()
               .filter(jedi -> jedi.getRank().equals(jediRank))
               .collect(Collectors.toList());

       if (jedis.isEmpty()) {
           System.out.println("Error: No jedis with rank " + jediRank + " found on planet " + planetName + ".");
           return;
       }

       Optional<Jedi> youngestJedi = jedis.stream()
               .min(Comparator.comparingInt(Jedi::getAge)
                       .thenComparing(Jedi::getJediName));

           Jedi jedi = youngestJedi.get();
           System.out.println("The youngest Jedi with rank " + jediRank + " on planet " + planetName + " is " + jedi.getJediName() + " with age " + jedi.getAge() + ".");
   }
}