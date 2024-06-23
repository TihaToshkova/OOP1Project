import java.util.HashMap;
import java.util.Map;

public class FileOperations {
    private String fileName;
    private Map<String, Planet> planets = new HashMap<>();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, Planet> getPlanets() {
        return planets;
    }

    public void clearPlanetsAndJedis() {
        planets.clear();
    }

    public void setPlanets(Map<String, Planet> planets) {
        this.planets = planets;
    }
}
