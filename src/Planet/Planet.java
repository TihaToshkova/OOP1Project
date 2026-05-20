package Planet;

import Jedi.Jedi;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Planet.Planet} class represents a planet with a name and a population of jedis.
 */
public class Planet {
    private String name;
    private List<Jedi> population;

    /**
     * Constructs a planet with the specified name.
     *
     * @param name the name of the planet
     */
    public Planet(String name) {
        this.name = name;
        this.population = new ArrayList<>();
    }

    /**
     * Returns the name of the planet.
     *
     * @return the name of the planet
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the population of jedis on the planet.
     *
     * @return the list of jedis on the planet
     */
    public List<Jedi> getPopulation() {
        return population;
    }

    /**
     * Adds a Jedi.Jedi to the population of the planet.
     *
     * @param jedi the Jedi.Jedi to add to the planet
     */
    public void addJedi(Jedi jedi) {
        population.add(jedi);
    }

    /**
     * Removes a Jedi.Jedi from the population of the planet based on the Jedi.Jedi's name (case-insensitive).
     *
     * @param jediName the name of the Jedi.Jedi to remove
     * @return {@code true} if the Jedi.Jedi was removed successfully, {@code false} otherwise
     */
    public boolean removeJedi(String jediName) {
        return population.removeIf(jedi -> jedi.getJediName().equalsIgnoreCase(jediName));
    }

    /**
     * Returns a string representation of the Planet.Planet object.
     *
     * @return a string representation of the Planet.Planet object
     */
    @Override
    public String toString() {
        return "Planet.Planet{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
