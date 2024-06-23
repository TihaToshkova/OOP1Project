import java.util.HashMap;
import java.util.Map;

public class RemoveJedi implements RemoveJediInterface{
    public void removeJedi(FileOperations fileOperations,String jediName, String planetName) {
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
