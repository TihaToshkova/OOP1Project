import java.util.HashMap;
import java.util.Map;

public class CreateJedi implements CreateJediInterface{
    public void createJedi(FileOperations fileOperations,String planetName, String jediName, String jediRank, int jediAge, String saberColor, int jediStrength) {

        if (!fileOperations.getPlanets().containsKey(planetName)) {
            System.out.println("Error: Planet not found - " + planetName);
            return;
        }

        Jedi jedi = new Jedi(jediName, Rank.valueOf(jediRank.toUpperCase()), jediAge, saberColor, jediStrength);

        // Add the Jedi to the specified planet
        Planet planet = fileOperations.getPlanets().get(planetName);
        planet.addJedi(jedi);

        System.out.println("Successfully added Jedi " + jediName + " to planet " + planetName);

    }
}
