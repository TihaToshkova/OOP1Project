import java.util.Map;

public class PrintJedi implements PrintInterface{
    public void print(FileOperations fileOperations,String jediName) {
        for (Map.Entry<String, Planet> entry : fileOperations.getPlanets().entrySet()) {
            Planet planet = entry.getValue();
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    System.out.println("Jedi: " + jedi);
                    System.out.println("Planet: " + planet.getName());
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " does not exist.");
    }
}
