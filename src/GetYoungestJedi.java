import java.util.*;
import java.util.stream.Collectors;

public class GetYoungestJedi implements GetYoungestJediInterface{
   public void getYoungestJedi(FileOperations fileOperations,String planetName, String jediRank) {

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
