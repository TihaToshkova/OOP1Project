public class Jedi {
    private String jediName;
    private Rank rank;
    private int age;
    private String lightsaberColor;
    private double strength;

    public Jedi(String jediName, Rank rank, int age, String lightsaberColor, double strength)
    {
        this.jediName = jediName;
        this.rank = rank;
        this.age = age;
        this.lightsaberColor = lightsaberColor;
        this.strength = strength;
    }

    public String getJediName() {
        return jediName;
    }

    public void setJediName(String jediName) {
        this.jediName = jediName;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLightsaberColor() {
        return lightsaberColor;
    }

    public void setLightsaberColor(String lightsaberColor) {
        this.lightsaberColor = lightsaberColor;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Jedi{" +
                "jediName='" + jediName + '\'' +
                ", rank=" + rank +
                ", age=" + age +
                ", lightsaberColor='" + lightsaberColor + '\'' +
                ", strength=" + strength +
                '}';
    }
}
