import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetStrongestJedi implements GetStrongestJediInterface{
    public void getStrongestJedi(FileOperations fileOperations,String planetName) {
        Planet planet = fileOperations.getPlanets().get(planetName);

        if (planet == null) {
            System.out.println("Error: Planet " + planetName + " not found.");
            return;
        }

        List<Jedi> jedis = planet.getPopulation();
        if (jedis.isEmpty()) {
            System.out.println("Error: No jedis found on planet " + planetName + ".");
            return;
        }

        Jedi strongestJedi = jedis.get(0);
        for (Jedi jedi : jedis) {
            if (jedi.getStrength() > strongestJedi.getStrength()) {
                strongestJedi = jedi;
            }
        }

        System.out.println("The strongest Jedi on planet " + planetName + " is " +
                strongestJedi.getJediName() + " with strength " + strongestJedi.getStrength() + ".");

    }
}
