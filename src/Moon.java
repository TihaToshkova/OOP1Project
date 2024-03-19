public class Moon {
    private String name;
    private Jedi[] population;

    public Moon(String name, Jedi[] population)
    {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Jedi[] getPopulation() {
        return population;
    }

    public void setPopulation(Jedi[] population) {
        this.population = population;
    }
}
