import java.util.HashMap;
import java.util.Map;

public class AddPlanet implements AddPlanetInterface{
    public void addPlanet(FileOperations fileOperations, String planetName) {
        if (!fileOperations.getPlanets().containsKey(planetName)) {
            fileOperations.getPlanets().put(planetName, new Planet(planetName));
            System.out.println("Planet added: " + planetName);
        } else {
            System.out.println("Planet already exists: " + planetName);
        }
    }
}
