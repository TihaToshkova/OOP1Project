import java.util.HashMap;
import java.util.Map;

/**
 * The {@code FileOperations} class manages file-related operations and the collection of planets.
 * <p>
 * It provides methods to get and set the file name, manage the collection of planets, and clear
 * all planets and jedis from the collection.
 * </p>
 */
public class FileOperations {
    private String fileName;
    private Map<String, Planet> planets = new HashMap<>();

    /**
     * Returns the name of the currently open file.
     *
     * @return the name of the currently open file, or {@code null} if no file is open
     */
    public String getFileName() {return fileName;}

    /**
     * Sets the name of the file to be managed.
     *
     * @param fileName the name of the file to be managed
     */
    public void setFileName(String fileName) {this.fileName = fileName;}

    /**
     * Returns the collection of planets.
     *
     * @return a map where the keys are planet names and the values are {@code Planet} objects
     */
    public Map<String, Planet> getPlanets() {return planets;}

    /**
     * Clears the collection of planets and their jedis.
     */
    public void clearPlanetsAndJedis() {planets.clear();}

    /**
     * Sets the collection of planets.
     *
     * @param planets a map where the keys are planet names and the values are {@code Planet} objects
     */
    public void setPlanets(Map<String, Planet> planets) {this.planets = planets;}
}
