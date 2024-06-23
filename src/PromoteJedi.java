import java.util.HashMap;
import java.util.Map;

public class PromoteJedi implements PromoteJediInterface{
    public void promoteJedi(FileOperations fileOperations,String jediName, double multiplier) {
        for (Map.Entry<String, Planet> entry : fileOperations.getPlanets().entrySet()) {
            for (Jedi jedi : entry.getValue().getPopulation()) {
                if (jedi.getJediName().equalsIgnoreCase(jediName)) {
                    if (jedi.promote()) {
                        System.out.println("Successfully promoted Jedi " + jediName);
                    } else {
                        System.out.println("Error: Jedi " + jediName + " is already at the highest rank.");
                    }
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " does not exist.");
    }
}
