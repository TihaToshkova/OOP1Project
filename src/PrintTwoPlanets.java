import java.util.*;

public class PrintTwoPlanets implements PrintTwoPlanetsInterface{
    public void printTwoPlanets(FileOperations fileOperations,String planetName1, String planetName2) {
        Planet planet1 = fileOperations.getPlanets().get(planetName1);
        Planet planet2 = fileOperations.getPlanets().get(planetName2);

        if (planet1 == null) {
            System.out.println("Error: Planet " + planetName1 + " not found.");
            return;
        }

        if (planet2 == null) {
            System.out.println("Error: Planet " + planetName2 + " not found.");
            return;
        }

        List<Jedi> combinedJedis = new ArrayList<>();
        combinedJedis.addAll(planet1.getPopulation());
        combinedJedis.addAll(planet2.getPopulation());

        Collections.sort(combinedJedis, new Comparator<Jedi>() {
            @Override
            public int compare(Jedi j1, Jedi j2) {
                int rankComparison = j1.getRank().compareTo(j2.getRank());
                if (rankComparison != 0) {
                    return rankComparison;
                }
                return j1.getJediName().compareTo(j2.getJediName());
            }
        });

        for (Jedi jedi : combinedJedis) {
            System.out.println(jedi);
        }
    }
}
