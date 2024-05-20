import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Planet {
    private String name;
    private List<Jedi> population;

    public Planet(String name)
    {
        this.name = name;
        this.population = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Jedi> getPopulation()
    {
        return population;
    }

    public  void addJedi(Jedi jedi)
    {
        population.add(jedi);
    }

    public boolean removeJedi(String jediName) {
        return population.removeIf(jedi -> jedi.getJediName().equalsIgnoreCase(jediName));
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}

